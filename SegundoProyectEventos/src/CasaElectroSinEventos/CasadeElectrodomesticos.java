package CasaElectroSinEventos;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import electroDomesticoYDerivadas.ElectroDomestico;
import electroDomesticoYDerivadas.Heladera;
import electroDomesticoYDerivadas.Lavarropa;
import electroDomesticoYDerivadas.Televisor;

public class CasadeElectrodomesticos {
	
	private static  ArrayList<ElectroDomestico> productos;
	private static Scanner scanner;
	public CasadeElectrodomesticos () {
		scanner = new Scanner (System.in);
		 productos = new ArrayList<>();
		 agregarProductos();
		 ofrecerProductos();
	 
		
	}
	private static void agregarProductos() {
		   productos.add(new Heladera ("Whirpool", "H2745", 14999, false, 250));
	        productos.add(new Televisor("Philiphs", "49PGFS", 14370, 49, true));
	        productos.add(new Lavarropa("Drean", "CONCEPT", 6799, 6, true));
	        //Voy a agregar 2 productos mas q los q aparecian en el ejercicio
	        productos.add(new Lavarropa("Drean", "OTRO", 67995, 3, false));
	        productos.add(new Lavarropa("Drean", "TXT", 67934, 7, true));
	}
	private static void remover(ElectroDomestico producto) {
		if (productos.contains(producto)) {
			productos.remove(producto);
		}
	}
  private static void mostrarProductos() {
    	 System.out.println("Mostrando el detalle incompleto de los productos : ");
    		System.out.println("--------------------------------- ");
    	productos.forEach(producto->System.out.println(producto));
    		System.out.println("--------------------------------- ");
    	 
    }
	private  static void mostrarDetalleProducto(ElectroDomestico producto) {
       producto.mostrarDetalleCompleto();
    }
	 
		private static void mostrarTicket( ArrayList<ElectroDomestico> carrito) {
			System.out.println("-------------------");
	        System.out.println("Ticket de venta");
	        StringBuilder otro = new StringBuilder("Articulo");
	        System.out.println(carrito.size()>1? otro.append("s") : otro);
	        AtomicInteger precioAcumulado = new AtomicInteger(0);  
	        carrito.forEach(producto -> {
	            mostrarDetalleProducto(producto);
	            precioAcumulado.addAndGet((int) producto.getPrecio());  
	              
	        });
	  
	        System.out.println("Importe total: $" + precioAcumulado);
	        System.out.println("-------------------");
			
		}
		
		private static void ofrecerProductos() {
			 int opcion;
		 
		        ArrayList<ElectroDomestico> carritodeCompras = new ArrayList<>();
				 
			        do {
			            mostrarProductos();
			            System.out.println("Ingrese el nro del producto q desea comprar (0 para salir): ");
			            opcion =  scanner.nextInt();
			            if (opcion != 0) {
			                ElectroDomestico productoqEligio = productos.get(opcion - 1);
			                System.out.println("El producto q eligio es : ");
			                mostrarDetalleProducto(productoqEligio);
			                System.out.println("Confirma la seleccion ? (Si/No): ");
			                String confirmacion = scanner.next();
			                if (confirmacion.equalsIgnoreCase("Si")) {
			                	carritodeCompras .add(productoqEligio);
			                	remover((productoqEligio));
			                    System.out.println("Producto agregado al carrito.");
			                }
			            }

			        } while (opcion != 0);
			        scanner.close();
			        mostrarTicket(carritodeCompras);
			 
		}
		 
	 
	public static void main(String[] args) {
		CasadeElectrodomesticos casa = new CasadeElectrodomesticos();
         
    }
 
	
	         
	    }

 
	   