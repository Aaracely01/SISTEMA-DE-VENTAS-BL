
package Modelo;

public class Cliente extends Persona {
    public Cliente(String dni, String nom, String apell, String tel) {
        super(dni, nom, apell, tel);
    }

    @Override
    public String getRol() {
        return "Cliente";
    }

    public Object[] obtenerClientes(int num) {
        Object fila[] = {num, getDni(), getNombres(), getApellidos(), getTelefono()};
        return fila;
    }
}
