insert into Cliente
values (0001, '54429785P', 'Piruleta11', 'Manuel', 'Fernandez', 'Dominguez', 'Rosalia de Castro 11 2A', '684070539',
        'ES2114640100722030876293');
insert into Cliente
values (0002, '54429755F', 'Gomina5', 'Tomas', 'Hernandez', 'Alvarez', 'Rosalia de Castro 44 3A', '684057339',
        'ES7531640100722030876293');
insert into Cliente
values (0003, '57929785P', 'Chope65', 'Andres', 'Aspas', 'Juncal', 'Velazquez Moreno 11 3der', '666070539',
        'ES7410640100722030876293');
insert into Cliente
values (0004, '89729785T', 'BufandaVerde', 'Maria', 'Otero', 'Rodriguez', 'Garcia Barbon 18 1B', '956770539',
        'ES6391040100722030876293');
insert into Cliente
values (0005, '74109785P', 'Mandarina80', 'Angela', 'Fernandez', 'Vazquez', 'Gran Via 11 2A', '999070539',
        'ES6789640100722030876293');

insert into Material
values ('Maquina musculacion', 'Gimnasio', 'Madrid', '100x150x150');
insert into Material
values ('Botella de agua', 'Tienda', 'Jaen', '15x4x4');
insert into Material
values ('Mancuernas', 'Gimnasio', 'Bilbao', '30x15x15');
insert into Material
values ('Cuerda para saltar', 'Gimnasio', 'Avila', '200');
insert into Material
values ('Bici estatica', 'Gimnasio', 'Vigo', '100x150x75');

insert into Monitor
values ('54477788J', 'Pedro', 'Lopez-Chaves', 'Perez', '2020-03-06', '986436515', 'Combate', '11111');
insert into Monitor
values ('47569832Y', 'Brais', 'Miguez', 'Varela', '2020-05-06', '606436515', 'Cardio', '12345');
insert into Monitor
values ('87625891K', 'Diego', 'Penin', 'Seijas', '2021-03-06', '875436515', 'Relajacion', '67890');
insert into Monitor
values ('84567921R', 'Leticia', 'Martinez', 'Limeres', '2020-11-06', '758436515', 'Relajacion', '22222');
insert into Monitor
values ('75896428Q', 'Martin', 'Omil', 'Nogales', '2021-11-06', '741036515', 'Cardio', '555555');

insert into Instalacion
values ('Sala 1', 50, 15);
insert into Instalacion
values ('Sala 2', 50, 15);
insert into Instalacion
values ('Sala 3', 50, 15);
insert into Instalacion
values ('Sala 4', 50, 15);
insert into Instalacion
values ('Sala 5', 50, 15);

insert into Actividad
values ('Boxeo', 15, 'Combate', 'Sala 1');
insert into Actividad
values ('Zumba', 15, 'Cardio', 'Sala 2');
insert into Actividad
values ('Yoga', 15, 'Relajacion', 'Sala 3');
insert into Actividad
values ('Pilates', 15, 'Relajacion', 'Sala 4');
insert into Actividad
values ('Aerobic', 15, 'Cardio', 'Sala 3');

insert into Organizar
values ('2022-05-05 12:30:00', 'Boxeo', 'Sala 1', '54477788J', 14);
insert into Organizar
values ('2022-05-07 13:30:00', 'Zumba', 'Sala 2', '47569832Y', 14);
insert into Organizar
values ('2022-05-06 12:30:00', 'Yoga', 'Sala 3', '84567921R', 14);
insert into Organizar
values ('2022-05-05 17:30:00', 'Pilates', 'Sala 4', '84567921R', 14);

insert into Participar
values ('2022-05-05 12:30:00', 'Boxeo', 'Sala 1', '54429785P', '54477788J');
insert into Participar
values ('2022-05-07 13:30:00', 'Zumba', 'Sala 2', '54429755F', '47569832Y');
insert into Participar
values ('2022-05-06 12:30:00', 'Yoga', 'Sala 3', '57929785P', '84567921R');
insert into Participar
values ('2022-05-05 17:30:00', 'Pilates', 'Sala 4', '54429785P', '84567921R');

insert into Encargar
values ('2022-03-05', 500, 600, 'Botella de agua', '54477788J');
insert into Encargar
values ('2022-03-10', 100, 4, 'Mancuernas', '54477788J');
insert into Encargar
values ('2022-03-03', 30, 5, 'Cuerda para saltar', '47569832Y');
insert into Encargar
values ('2022-03-09', 2000, 1, 'Maquina musculacion', '87625891K');
insert into Encargar
values ('2022-03-06', 350, 1, 'Bici estatica', '84567921R');
insert into Encargar
values ('2022-03-07', 500, 600, 'Botella de agua', '54477788J');
insert into Encargar
values ('2022-03-13', 100, 4, 'Mancuernas', '54477788J');