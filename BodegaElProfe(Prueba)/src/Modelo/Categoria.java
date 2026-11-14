/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author mrfab
 */
public class Categoria{
    
    private String Categoria;
    
    public Categoria(){};
    
    public Object[] obtenerFila(int num) {
        Object fila[] = {num, Categoria};
        return fila;
    }
    
    public void actualizar(String cate) {
        Categoria = cate;
    }
    
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
}
