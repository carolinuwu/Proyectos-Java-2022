package CasaElectroConEventos;
import javax.swing.*;

import electroDomesticoYDerivadas.ElectroDomestico;
import electroDomesticoYDerivadas.Heladera;
import electroDomesticoYDerivadas.Lavarropa;
import electroDomesticoYDerivadas.Televisor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CasadeElectrodomesticosconEventos extends JFrame  implements ActionListener{    
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JComboBox<String> listaProductos;
    private  JButton botonCarrito;
	private  JButton botonPrecio;
    private JButton botonOut;
    private  ArrayList<ElectroDomestico> productosDisponibles;
	private  ArrayList<ElectroDomestico> carritoCompras;
	 
    public CasadeElectrodomesticosconEventos() {
    System.out.println("Casa de electrodomesticos usando eventos");
    this.productosDisponibles = new ArrayList<>();
    this.carritoCompras = new ArrayList<>();
        agregarProductos();
        Carrito();
        crearListaDesplegable();
       agregarBotonagregarAlCarrito();
       botonObtenerPrecio();
       botonFinalizarTodo();
       crearContenedor();
       

    }   
    private void agregarListener() {
        if (botonCarrito != null) {
            botonCarrito.addActionListener(this);
         
        }
        if (botonPrecio != null) {
            botonPrecio.addActionListener(this);
            
        }
        if (botonOut != null) {
            botonOut.addActionListener(this);
           
        }
    }

         @Override
        public  void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonCarrito) {
                carritoCompras.add(productosDisponibles.get(listaProductos.getSelectedIndex()));
                listaProductos.removeItemAt(listaProductos.getSelectedIndex());
                JOptionPane.showMessageDialog(this, "Producto agregado al carrito!");
            } else if (e.getSource() == botonPrecio) {
                float importe = importe();
                JOptionPane.showMessageDialog(this, "El importe total es: " + importe);
            } else if (e.getSource() == botonOut) {
         
                JOptionPane.showMessageDialog(this, "Finalizando compra");
                StringBuilder detalleCompra = new StringBuilder();
                detalleCompra.append("Articulos :  ");
               carritoCompras.forEach(producto->{
            	   detalleCompra.append(producto);
               });
                
                DetalleCompraDialogo detalleDialog = new DetalleCompraDialogo(this, detalleCompra.toString());
                detalleDialog.setVisible(true);
                this.dispose();
           
            }
        }
		private void agregarProductos() {
 		   productosDisponibles.add(new Heladera ("Whirpul", "H2745", 14999, false, 250));
 		  productosDisponibles.add(new Televisor("Filiphs", "49PGFS", 14370, 49, true));
 		 productosDisponibles.add(new Lavarropa("Dreaw", "CONCEPT", 6799, 6, true));
 		 productosDisponibles.add(new Lavarropa("Dreaw", "OTRO", 67995, 3, false));
 		 productosDisponibles.add(new Lavarropa("Dreaw", "TXT", 67934, 7, true));
 	}

    private void crearListaDesplegable() {   
    	  String[] nombresProductos = new String[productosDisponibles.size()];
          for (int i = 0; i < nombresProductos.length; i++) {
              nombresProductos[i] = productosDisponibles.get(i).getMarca() + " " + productosDisponibles.get(i).getModelo();
          }
          listaProductos = new JComboBox<>(nombresProductos);
	}
     
       
	private JButton agregarBotonagregarAlCarrito() {
		botonCarrito = new JButton("Agregar al carrito");
		return botonCarrito;
	} 
	 
	 
	private JButton botonObtenerPrecio() {
		botonPrecio = new JButton("Obtener precio total de carrito");
		return botonPrecio;
		 
	}

 private JButton botonFinalizarTodo() {
		botonOut = new JButton("Completar compra"); 
		getContentPane().remove(botonCarrito);
		return botonOut;
		
	}
         

	private void crearContenedor() {
	    Container c = getContentPane();
	    c.setLayout(new GridLayout(2, 3));
	    c.add(listaProductos);
	    botonCarrito = agregarBotonagregarAlCarrito();
	    botonPrecio= botonObtenerPrecio();
	    botonOut = botonFinalizarTodo();
	    if (botonCarrito != null) {
	        c.add(botonCarrito);
	      
	    }
	    if (botonPrecio != null) {
	        c.add(botonPrecio);
	         
	    }
	    if (botonOut != null) {
	        c.add(botonOut);
	       
	         
	        
	    }
	    agregarListener();

	}
      private void Carrito() {
            setSize(100, 200);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
         
       private float importe() {
    	   AtomicInteger importe = new AtomicInteger(0);
    	    carritoCompras.forEach(electrodomestico -> {
    	        float precio = electrodomestico.getPrecio();
    	        importe.addAndGet((int) precio);
    	    });

    	    return importe.get();
  	}
 
    public static void main(String[] args) {
    	CasadeElectrodomesticosconEventos casa =  new CasadeElectrodomesticosconEventos();
  
    }
    

   private class DetalleCompraDialogo extends JDialog {

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public DetalleCompraDialogo(JFrame parent, String detalle) {
            super(parent, " Detalle de compra ", true);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setPreferredSize(new Dimension(1800, 200));

            JLabel detalleLabel = new JLabel(detalle);
            panel.add(detalleLabel, BorderLayout.CENTER);

            add(panel);
            pack();
            setLocationRelativeTo(parent);
        }
    }

    
}
 

	 
	 
 
 

 
