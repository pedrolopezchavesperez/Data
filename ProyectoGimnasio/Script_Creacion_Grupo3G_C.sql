create table Cliente
(
    numAbonado  integer not null unique,
    dni         varchar(9) primary key,
    contrasenha varchar not null,
    nombre      varchar NOT NULL,
    ap1         varchar NOT NULL,
    ap2         varchar,
    direccion   varchar,
    telefono    varchar,
    cuenta      varchar NOT NULL
);


create table Monitor
(
    dni          varchar(9) primary key,
    nombre       varchar NOT NULL,
    ap1          varchar NOT NULL,
    ap2          varchar,
    fechaInicio  date,
    telefono     varchar,
    especialidad varchar,
    contrasenha  varchar not null
);

create table Instalacion
(
    nombre varchar primary key,
    metros numeric,
    aforo  integer not null
);

create table Actividad
(
    nombre            varchar NOT NULL,
    plazas            integer,
    campo             varchar,
    nombreInstalacion varchar not null
);

create table Material
(
    nombre      varchar primary key,
    materia     varchar,
    procedencia varchar,
    dimension   varchar
);

create table Participar
(
    horario           timestamp,
    nombreActividad   varchar not null,
    nombreInstalacion varchar not null,
    cliente           varchar not null,
    monitor           varchar
);
create table Organizar
(
    horario           timestamp,
    nombre            varchar,
    nombreInstalacion varchar,
    monitor           varchar,
    plazasRestantes   integer
);

create table Encargar
(
    fechaPedido    date    not null,
    precio         numeric,
    cantidad       integer,
    nombreMaterial varchar not null,
    monitor        varchar not null
);

create table ListaEspera
(
    posLista          integer    not null,
    cliente           varchar(9) not null,
    horario           timestamp  not null,
    nombreActividad   varchar    not null,
    nombreInstalacion varchar    not null,
    monitor           varchar    not null
);

create table Avisos
(
    aviso   varchar not null,
    cliente varchar not null
);

alter table only public.Actividad
    add constraint actividades_fk foreign key (nombreInstalacion) references public.Instalacion (nombre) on update cascade on delete cascade;

alter table only public.Actividad
    add constraint actividades_pk primary key (nombre, nombreInstalacion);

alter table only public.Organizar
    add constraint Organizar_fk1 foreign key (nombre, nombreinstalacion) references public.Actividad (nombre, nombreinstalacion) on update cascade on delete cascade,
    add constraint Organizar_fk2 foreign key (monitor) references public.Monitor (dni) on update cascade on delete cascade,
    add constraint Organizar_pk1 primary key (nombre, horario, nombreinstalacion, monitor);

alter table only public.Participar
    add constraint participar_fk1 foreign key (nombreActividad, nombreInstalacion, horario, monitor) references public.Organizar (nombre, nombreinstalacion, horario, monitor) on update cascade on delete cascade,
    add constraint participar_fk2 foreign key (cliente) references public.Cliente (DNI) on update cascade on delete cascade,
    add constraint participar_pk primary key (nombreActividad, horario, nombreInstalacion, cliente, monitor);

alter table only public.Encargar
    add constraint Encargar_fk1 foreign key (monitor) references public.Monitor (dni) on update cascade on delete no action,
    add constraint Encargar_fk2 foreign key (nombrematerial) references public.material (nombre) on update cascade on delete no action,
    add constraint Encargar_pk primary key (fechapedido, Monitor);

alter table only public.ListaEspera
    add constraint ListaEspera_fk1 foreign key (cliente) references public.Cliente (dni) on update cascade on delete cascade,
    add constraint ListaEspera_fk2 foreign key (nombreActividad, nombreInstalacion, horario, monitor) references public.Organizar (nombre, nombreinstalacion, horario, monitor) on update cascade on delete cascade,
    add constraint ListaEspera_pk primary key (nombreActividad, horario, nombreInstalacion, cliente, monitor, posLista);

alter table only public.Avisos
    add constraint Avisos_fk foreign key (cliente) references public.Cliente (dni) on update cascade on delete cascade,
    add constraint Avisos_pk primary key (aviso, cliente);


create or replace function public.meterlista(cli varchar, act varchar, ins varchar, hor timestamp, mon varchar)
    returns void
    language plpgsql
as
$function$
declare
    posicion       integer;
    declare plazas integer;
    declare existe integer;
begin
    select max(posLista)
    into posicion
    from listaEspera
    where nombreActividad = act
      and nombreInstalacion = ins
      and monitor = mon
      and horario = hor;
    if posicion is null then
        posicion = 0;
    end if;
    posicion = posicion + 1;
    select count(*)
    into existe
    from listaEspera
    where nombreactividad = act
      and nombreinstalacion = ins
      and horario = hor
      and cliente = cli
      and monitor = mon;
    if existe != 0 then
        raise exception 'Ya estas en la lista de espera de esta actividad';
    end if;	
    select distinct (plazasRestantes)
    into plazas
    from organizar
    where nombre = act
      and nombreinstalacion = ins
      and horario = hor;
    if plazas < 1 then
        insert into ListaEspera values (posicion, cli, hor, act, ins, mon);
    end if;
end;
$function$
;

create or replace function public.comprobarplazas()
    returns trigger
    language plpgsql
as
$function$
declare
    pzs integer;
begin
    select distinct(plazasRestantes)
    into pzs
    from Organizar
    where nombre = new.nombreActividad
      and nombreInstalacion = new.nombreInstalacion
      and horario = new.horario
      and monitor = new.monitor;

    if pzs < 1 then
        perform meterlista(new.cliente, new.nombreActividad, new.nombreInstalacion, new.horario, new.monitor);
        return null;
    end if;
    return new;
end;
$function$
;

create or replace function public.actualizarlista(act varchar, ins varchar, hor timestamp, mon varchar)
    returns void
    language plpgsql
as
$function$
begin
    delete
    from public.ListaEspera
    where poslista = 1
      and nombreActividad = act
      and nombreInstalacion = ins
      and horario = hor
      and monitor = mon;
    update public.ListaEspera
    set posLista = posLista - 1
    where nombreActividad = act
      and nombreInstalacion = ins
      and horario = hor
      and monitor = mon;
end;
$function$
;

create or replace function public.sacarlista()
    returns trigger
    language plpgsql
as
$function$
declare
    cli                  varchar;
    declare dif          integer;
    declare numMonitores integer;
begin
    dif = new.plazasRestantes - old.plazasRestantes;
    if dif > 0 then
        select cliente
        into cli
        from ListaEspera
        where poslista = 1
          and nombreActividad = old.nombre
          and nombreinstalacion = old.nombreInstalacion
          and horario = old.horario
          and monitor = old.monitor;
        while dif != 0 and cli is not null
            loop
                insert into participar values (old.horario, old.nombre, old.nombreInstalacion, cli, old.monitor);
                dif = dif - 1;
                perform actualizarlista(old.nombre, old.nombreInstalacion, old.horario, old.monitor);
                select cliente
                into cli
                from ListaEspera
                where poslista = 1
                  and nombreActividad = old.nombre
                  and nombreinstalacion = old.nombreInstalacion
                  and horario = old.horario
                  and monitor = old.monitor;
            end loop;
    end if;
    return old;
end;
$function$
;

create or replace function public.avisar()
    returns trigger
    language plpgsql
as
$function$
declare
    cuenta integer;
begin
    cuenta = count(*)
             from organizar
             where organizar.horario = old.horario
               and organizar.nombre = old.nombreactividad
               and organizar.nombreinstalacion = old.nombreinstalacion;
    if cuenta < 1 then
        insert into avisos
        values (concat('Se ha eliminado una actividad a la que estabas apuntado: ', old.nombreactividad, ' del dia ', old.horario), old.cliente);
    end if;
    return null;
end
$function$;

create trigger introducirLista
    before insert
    on public.Participar
    for each row
execute function comprobarplazas();

create trigger extraerlista
    after update of plazasRestantes
    on public.organizar
    for each row
execute function sacarlista();

create trigger avisar
    after delete
    on public.participar
    for each row
execute function avisar();
	



