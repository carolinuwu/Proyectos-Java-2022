package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

/*
	 *  No es lo solicitado, pero para esta clase quizas seria mas conveniente 
  utilizar un record ya que no es una clase donde haya que aplicar nada de lo que se evaluaba

	 */

public class Paciente implements Mostrable{
	private int nroInscripcion;
	private String nape;
	private int[] edadCronologica;
	
	public Paciente(int nroInscripcion, String nombreyape) {
		this.nroInscripcion = nroInscripcion;
		this.nape = nombreyape;
	}

	public void setEdadCronologica(int[] edad1) {
		 this.edadCronologica = edad1;
		
	}
	public int[] getEdadCronologica() {
		return edadCronologica;
	}

	private void mostrarEdadCronologica() {
	    int[] edad = this.getEdadCronologica();
	    int anios = edad[0];
	    int meses = edad[1];
	    System.out.println("Edad cronológica: " + anios + " años " + meses + " meses");
	}
 

	@Override
	public void mostrar() {
		System.out.println("Numero de inscripcion : " + this.nroInscripcion + "-- Nombre Completo : " + this.nape );
		this.mostrarEdadCronologica();
		
	}
 
}
