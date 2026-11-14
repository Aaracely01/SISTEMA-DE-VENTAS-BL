
package Modelo;

public class Empleado extends Usuario {
     public Empleado(String dni, String nom, String apell, String tel,
                    String usuario, String clave) {
        super(dni, nom, apell, tel, usuario, clave);
    }

    @Override
    public String getRol() {
        return "Empleado";
    }

    @Override
    public boolean puedeAdministrar() {
        return false;
    }
}
