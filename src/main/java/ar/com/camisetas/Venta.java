package ar.com.camisetas;
import java.time.LocalDate;

public class Venta {
	  private int id;
	  private Camiseta camiseta;
	  private int cantidad;
	  private float precioUnitario;
	  private LocalDate fecha;
	  
	  public Venta(int id, Camiseta camiseta, int cantidad, float precioUnitario, LocalDate fecha) {
		  this.id = id;
		  this.camiseta = camiseta;
		  this.cantidad = cantidad;
		  this.precioUnitario = precioUnitario;
		  this.fecha = fecha;
	  }
	  
	  public int getId() {
		    return id;
		}

		public Camiseta getCamiseta() {
		    return camiseta;
		}

		public int getCantidad() {
		    return cantidad;
		}

		public float getPrecioUnitario() {
		    return precioUnitario;
		}

		public LocalDate getFecha() {
		    return fecha;
		}
	  
	  public float calcularTotal() {
		    return cantidad * precioUnitario;
		}
}
