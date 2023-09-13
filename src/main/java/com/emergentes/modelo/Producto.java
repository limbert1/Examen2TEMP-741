
package com.emergentes.modelo;

public class Producto {
    
    private int id;
    private String Descripcion;
    private int Cantidad;
    private float Precio;
    private String Categoria;

    public Producto() {
     this.id=0;
     this.Descripcion="";
     this.Cantidad=0;
     this.Precio=0;
     this.Categoria="";  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
    
    
}
