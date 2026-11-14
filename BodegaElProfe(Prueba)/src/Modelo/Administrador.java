
package Modelo;

public class Administrador extends Usuario {
     public Administrador(String dni, String nom, String apell, String tel,
                         String usuario, String clave) {
        super(dni, nom, apell, tel, usuario, clave);
    }

    @Override
    public String getRol() {
        return "Administrador";
    }

    @Override
    public boolean puedeAdministrar() {
        return true;
    }
}
