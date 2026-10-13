package ar.com.camisetas;

public abstract class Camiseta {

    private String nombre;
    private float precio;
    private int stock;
    private Talle talle;

    protected Camiseta(String nombre, float precio, int stock, Talle talle) {

        this.nombre = nombre;
       
        this.precio = precio;
        this.stock = stock;
        this.talle = talle;
    }

    public abstract void mostrarDatos();

    
    // Getters
    public String getNombre() {
        return nombre;
    }


    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public Talle getTalle() {
        return talle;
    }
    
    //Setters
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    	
    }
    
    public void setPrecio(float precio) {
    	if(precio>=0) {
    		this.precio = precio;
    	}
    }
    
    public void setStock(int stock) {
    	if(stock>=0) {
    		this.stock = stock;
    	}
    }
    
    public void setTalle(Talle talle) {
    	this.talle = talle;
    }
    
    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            stock-= cantidad;
            return true;
        } else {
            return false;
        }
    }
    
    public void agregarStock(int cantidad) {
    	stock = stock + cantidad;
    }
    
}