package Modelo;

public class Producto {
    private String codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private int stockMinimo;
    static int contador = 0;
    //constructor
    public Producto(String cod, String nom, String cat, double pre, int sto, int smin) {
        validar(cod, nom, pre, sto, smin);   
        this.codigo = cod;
        this.nombre = nom;
        this.categoria = cat;
        this.precio = pre;
        this.stock = sto;
        this.stockMinimo = smin;
        contador++;
    }
    //validacion de datos
     private void validar(String cod, String nom, double pre, int sto, int smin) {
        if (nom.trim().isEmpty() || cod.trim().isEmpty())
            throw new IllegalArgumentException("El nombre y código son obligatorios.");
        if (pre <= 0)
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        if (sto < 0 || smin < 0)
            throw new IllegalArgumentException("El stock no puede ser negativo.");
    }
   //actualizar
    public void actualizar(String cod, String nom, String cat, double pre, int sto, int smin) {
        validar(cod, nom, pre, sto, smin);
        this.codigo = cod;
        this.nombre = nom;
        this.categoria = cat;
        this.stock = sto;
        this.precio = pre;
        this.stockMinimo = smin;
    }
    public boolean necesitaReposicion() {      
        return stock <= stockMinimo;
    }


    public Object[] RegistrarDatos(int num) {
        Object fila[] = {num, codigo, nombre, categoria, precio, stock, stockMinimo};
        return fila;
    }

    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public String getCategoria() {return categoria;}   
    public double getPrecio() {return precio;}
    public int getStock() {return stock;}   
    public int getStockMin() {return stockMinimo;}
    
    public void setStock(int stock) {this.stock = stock;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
}
