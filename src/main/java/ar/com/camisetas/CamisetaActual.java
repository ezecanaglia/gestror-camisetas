package ar.com.camisetas;

public class CamisetaActual extends Camiseta {

    private String modelo;
    

    public CamisetaActual(String nombre,
                          float precio, int stock, Talle talle,
                          String modelo) {

        super(nombre, precio, stock, talle);

        this.modelo = modelo;
    }

    @Override
    public void mostrarDatos() {

        System.out.println(getNombre());
        System.out.println(getPrecio());
        System.out.println(getStock());
        System.out.println(getTalle());
        System.out.println(modelo);
        
    }
}
