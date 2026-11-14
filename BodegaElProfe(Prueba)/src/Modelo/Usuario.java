
package Modelo;

public abstract class Usuario extends Persona {
    private String usuario;
    private String clave;

    public Usuario(String dni, String nom, String apell, String tel,
                   String usuario, String clave) {
        super(dni, nom, apell, tel);
        this.usuario = usuario;
        this.clave = clave;
    }

    // El usuario no distingue mayúsculas; la contraseña sí
    public boolean credencialesCorrectas(String usu, String cla) {
        return usuario.equalsIgnoreCase(usu) && clave.equals(cla);
    }

    public abstract boolean puedeAdministrar();

    public Object[] obtenerUsuarios(int num) {
        Object fila[] = {num, getDni(), getNombreCompleto(), usuario, getRol()};
        return fila;
    }

    public String getUsuario() {return usuario;}
}
