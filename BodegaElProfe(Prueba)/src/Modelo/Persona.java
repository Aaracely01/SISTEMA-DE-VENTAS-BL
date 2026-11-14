
package Modelo;

public abstract class Persona {
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;

    public Persona(String dni, String nom, String apell, String tel) {
        validar(dni, nom, apell, tel);
        this.dni = dni;
        this.nombres = nom.trim();
        this.apellidos = apell.trim();
        this.telefono = tel;
    }

    private boolean soloDigitos(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) return false;
        }
        return true;
    }

    private void validar(String dni, String nom, String apell, String tel) {
        if (nom.trim().isEmpty() || apell.trim().isEmpty())
            throw new IllegalArgumentException("Ingresa los Nombres y Apellidos.");
        if (dni.length() != 8 || !soloDigitos(dni))
            throw new IllegalArgumentException("El DNI Debe Tener 8 Dígitos Numéricos.");
        if (tel.length() != 9 || !soloDigitos(tel))
            throw new IllegalArgumentException("El Telefono Debe Tener 9 Dígitos Numéricos.");
    }

    public void actualizar(String dni, String nom, String apell, String tel) {
        validar(dni, nom, apell, tel);
        this.dni = dni;
        this.nombres = nom.trim();
        this.apellidos = apell.trim();
        this.telefono = tel;
    }

    public abstract String getRol();   // abstracto: cada hija lo sobrescribe

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public String getDni() {return dni;}
    public String getNombres() {return nombres;}
    public String getApellidos() {return apellidos;}
    public String getTelefono() {return telefono;}
}
