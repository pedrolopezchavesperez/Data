package aplicacion;



public class Usuario {
    private String dni;
    private String contrasenha;
    private TipoUsuario tipo;
    
    public Usuario (String dni, String contrasenha, TipoUsuario tipo){
        this.dni = dni;
        this.contrasenha = contrasenha;
        this.tipo = tipo;
    }

    public String getDni() {
        return dni;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }
    
    
}
