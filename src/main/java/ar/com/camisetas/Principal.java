package ar.com.camisetas;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
	
		//1. CREAR LAS CAMISETAS
		Camiseta camiseta1 = new CamisetaActual(
		        "Argentina 2026",
		        100000,
		        10,
		        Talle.M,
		        "Titular"
		);
		Camiseta camiseta2 = new CamisetaRetro(
		        "Argentina 1986",
		        80000,
		        5,
		        Talle.L,
		        1986
		);
		
		//2. CREAR Y CARGAR LISTAS
		ArrayList<Camiseta> camisetas = new ArrayList<>();
		ArrayList<Venta> ventas = new ArrayList<>();
		
		camisetas.add(camiseta1);
        camisetas.add(camiseta2);
        
		
        //3. CREAR EL SCANNER Y MOSTRAR EL MENU
		Scanner scanner = new Scanner (System.in);
		
		int opcion;
		
		do {
			System.out.println("\n=== GESTION DE CAMISETAS ===");
			System.out.println("1. Agregar camiseta");
			System.out.println("2. Listar camisetas");
			System.out.println("3. Buscar camisetas ");
			System.out.println("4. Modificar camisetas");
			System.out.println("5. Registrar venta");
			System.out.println("6. Consultar historial de ventas");
			System.out.println("7. Consultar ingresos totales");
			System.out.println("8. Salir");
			System.out.println("Seleccione una opcion: ");
			
			opcion = scanner.nextInt();
			
			
			System.out.println("Seleccionaste la opcion: "+opcion);
			
			if(opcion == 1) {
				System.out.println("¿Que tipo de camiseta desea agregar?");
				System.out.println("1. Camiseta actual");
				System.out.println("2. Camiseta retro");
				System.out.println("Seleccione una opcion: ");
				
				int tipoCamiseta = scanner.nextInt();
				
				if(tipoCamiseta == 1) {
					System.out.println("Seleccionaste camiseta actual");
					
					System.out.println("Ingrese el nombre de la camiseta: ");
					scanner.nextLine();
					String nombre = scanner.next();
					
					System.out.println("Ingrese el precio: ");
					float precio = scanner.nextFloat();
					
					System.out.println("Ingrese el stock inicial: ");
					int stock = scanner.nextInt();
					
					System.out.println("Seleccione un talle: ");
					for(Talle talleDisponible : Talle.values()) {
						System.out.println(talleDisponible);
					}
					
					System.out.println("Seleccione el talle: ");
					Talle talle = Talle.valueOf(scanner.next().toUpperCase());
					
					System.out.println("Ingrese el modelo (Titular o Suplente): ");
					String modelo = scanner.next();
					
					CamisetaActual nuevaCamiseta = new CamisetaActual (nombre, precio, stock, talle, modelo);
					
					camisetas.add(nuevaCamiseta);
					
					System.out.println("Camiseta actual agregada correctamente");
						
					
				}else if(tipoCamiseta == 2) {
					System.out.println("Seleccionaste camiseta retro");
					
					System.out.println("Ingrese el nombre de la camiseta: ");
					scanner.nextLine();
					String nombre = scanner.next();
					
					System.out.println("Ingrese el precio: ");
					float precio = scanner.nextFloat();
					
					System.out.println("Ingrese el stock inicial: ");
					int stock = scanner.nextInt();
					
					System.out.println("Seleccione un talle: ");
					for(Talle talleDisponible : Talle.values()) {
						System.out.println(talleDisponible);
					}
					
					System.out.println("Seleccione el talle: ");
					Talle talle = Talle.valueOf(scanner.next().toUpperCase());
					
					System.out.println("Ingrese la temporada de la camiseta: ");
					int temporada = scanner.nextInt();
					
					CamisetaRetro nuevaCamiseta = new CamisetaRetro (nombre, precio, stock, talle, temporada);
					
					camisetas.add(nuevaCamiseta);
					
					System.out.println("Camiseta retro agregada correctamente");
					
					
				}else {
					System.out.println("Opcion no valida");
				}
				
				
			}
			// LISTADO DE CAMISETAS
			if(opcion == 2) {
				for(Camiseta camiseta : camisetas) {
					camiseta.mostrarDatos();
				}
			}
			//BUSCAR CAMISETA
			if(opcion == 3) {
				System.out.println("Ingrese el nombre de la camiseta: ");
				scanner.nextLine();
				
				String nombreBuscado = scanner.nextLine();
				
				Camiseta encontrada = buscarCamiseta(camisetas, nombreBuscado);
				
				if(encontrada != null) {
					encontrada.mostrarDatos();
				}else {
					System.out.println("Camiseta no encontrada");
				}
			}
				
			//MODIFICAR CAMISETA
			if (opcion == 4) {
			    System.out.println("Ingrese el nombre de la camiseta: ");
			    scanner.nextLine();
			
			    String nombreBuscado = scanner.nextLine();
			    Camiseta encontrada = buscarCamiseta(camisetas, nombreBuscado);
			
			    if (encontrada != null) {
			        System.out.println("\n=== MODIFICAR CAMISETA ===");
			        System.out.println("1. Modificar precio");
			        System.out.println("2. Modificar talle");
			        System.out.println("3. Modificar stock");
			        System.out.println("4. Volver al menu principal");
			        System.out.print("Seleccione una opcion: ");
			
			        int opcionModificar = scanner.nextInt();
			
			        if (opcionModificar == 1) {
			            System.out.print("Ingrese un nuevo precio: ");
			            float nuevoPrecio = scanner.nextFloat();
			
			            encontrada.setPrecio(nuevoPrecio);
			            System.out.println("Precio actualizado correctamente.");
			            encontrada.mostrarDatos();
			
			        } else if (opcionModificar == 2) {
			            System.out.println("Talles disponibles:");
			
			            for (Talle talle : Talle.values()) {
			                System.out.println(talle);
			            }
			
			            System.out.print("Ingrese el nuevo talle: ");
			            String nuevoTalle = scanner.next().toUpperCase();
			
			            try {
			                encontrada.setTalle(Talle.valueOf(nuevoTalle));
			                System.out.println("Talle actualizado correctamente.");
			                encontrada.mostrarDatos();
			
			            } catch (IllegalArgumentException e) {
			                System.out.println("Talle no valido.");
			            }
			
			        } else if (opcionModificar == 3) {
			            System.out.println("Stock actual: " + encontrada.getStock());
			            System.out.print("Ingrese la cantidad a agregar: ");
			            int cantidad = scanner.nextInt();
			
			            if (cantidad > 0) {
			                encontrada.agregarStock(cantidad);
			                System.out.println("Stock actualizado correctamente.");
			                encontrada.mostrarDatos();
			            } else {
			                System.out.println("La cantidad debe ser mayor a cero.");
			            }
			
			        } else if (opcionModificar == 4) {
			            System.out.println("Volviendo al menu principal.");
			
			        } else {
			            System.out.println("Opcion no valida.");
			        }
			
			    } else {
			        System.out.println("Camiseta no encontrada.");
			    }
			}


			//REGISTRA VENTAS
			if(opcion == 5) {
				System.out.println("Ingrese el nombre de la camiseta: ");
				scanner.nextLine();
			
				String nombreBuscado = scanner.nextLine();
				Camiseta encontrada = buscarCamiseta(camisetas, nombreBuscado);
			
					if(encontrada != null) {
						System.out.println("Ingrese la cantidad a vender: ");
				
						int cantidad = scanner.nextInt();
				
						if(encontrada.vender(cantidad)) {
							float precioUnitario = encontrada.getPrecio();
					
							Venta venta = new Venta (
									ventas.size() +1,
									encontrada,
									cantidad,
									precioUnitario,
									LocalDate.now()
									);
					
								ventas.add(venta);
					
								System.out.println("Venta registrada correctamente");
								System.out.println("Total de la venta: $" + venta.calcularTotal());
								System.out.println("Stock restante: "+ encontrada.getStock());
				
						}else {
							System.out.println("Venta no realizada. Verifique la cantidad y el stock disponible");
						}
				
					}else {
						System.out.println("Camiseta no encontrada");
					}
				}
			//HISTORIAL DE VENTAS
			if (opcion == 6) {
			    System.out.println("\n=== HISTORIAL DE VENTAS ===");

			    if (ventas.isEmpty()) {
			        System.out.println("Todavia no hay ventas registradas.");
			    } else {
			        for (Venta venta : ventas) {
			            System.out.println("----------------------");
			            System.out.println("ID: " + venta.getId());
			            System.out.println("Camiseta: " + venta.getCamiseta().getNombre());
			            System.out.println("Cantidad: " + venta.getCantidad());
			            System.out.println("Precio unitario: $" + venta.getPrecioUnitario());
			            System.out.println("Fecha: " + venta.getFecha());
			            System.out.println("Total: $" + venta.calcularTotal());
			        }
			    }
			}
			//TOTAL DE UNIDADES VENDIDAS
			if(opcion == 7) {
				
				
				int unidadesVendidas = 0;
				
				float ingresosTotales = 0;
				
				for(Venta venta : ventas) {
					ingresosTotales += venta.calcularTotal();
					unidadesVendidas += venta.getCantidad();
					
				}
				
				System.out.println("Ingresos totales $: " + ingresosTotales);
				System.out.println("El total de unidades vendidas es: " + unidadesVendidas);
			}
			
		}while(opcion!=8);
		
			scanner.close();
	
		}
	
	public static Camiseta buscarCamiseta(ArrayList<Camiseta> camisetas, String nombreBuscado) {
		
		for (Camiseta camiseta : camisetas) {
			
			if(camiseta.getNombre().equals(nombreBuscado)) {
				
				return camiseta;
			}
		}
		
		return null;
	}
}





