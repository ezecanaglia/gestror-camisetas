package ar.com.camisetas;

public class CamisetaRetro extends Camiseta {

    private int temporada;

    public CamisetaRetro(String nombre,
                         float precio, int stock,
                         Talle talle, int temporada) {

        super(nombre, precio, stock, talle);

        this.temporada = temporada;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(getNombre());
        System.out.println(getPrecio());
        System.out.println(getStock());
        System.out.println(getTalle());
        System.out.println(temporada);
    }
}