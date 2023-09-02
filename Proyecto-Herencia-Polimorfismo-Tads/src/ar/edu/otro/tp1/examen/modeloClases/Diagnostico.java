package ar.edu.ort.tp1.examen.modeloClases;

import java.util.Arrays;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public class Diagnostico implements Mostrable{

	private String codigoDiagnostico;
	private Severidad severidad;
	private Evaluacion [][] evaluaciones;
 
	
	
	public Diagnostico(String codigoDiagnostico, Severidad severidad) {
		this.codigoDiagnostico = codigoDiagnostico;
		this.severidad = severidad;
		this.evaluaciones   = new Evaluacion[DiaEvaluacion.values().length][TurnoEvaluacion.values().length];
	}



	public Severidad getSeveridad() {
		return severidad;
	}



	public void mostrarEvaluaciones() {
		for (int i = 0; i < evaluaciones.length; i++) {
			for (int j = 0; j < evaluaciones[i].length; j++) {
				if (evaluaciones[i][j]!=null) {
					evaluaciones[i][j].mostrar();
				}
			}
		}
	}
	public void agregarEvaluacion(Evaluacion evaluacion, TurnoEvaluacion turno, DiaEvaluacion dia) throws RuntimeException {
	int posFila = dia.ordinal();
	int posColumna = turno.ordinal();
	if (evaluaciones[posFila][posColumna] == null) {
		evaluaciones[posFila][posColumna] = evaluacion;
	}
	else {
		throw new RuntimeException("Ya hay una evaluacion almacenada el " + dia + " " + turno);
	}
	}
	
	
	
	@Override
	public void mostrar() {
	
		
		System.out.println("\nCODIGO: " + codigoDiagnostico + " /SEVERIDAD: " + severidad + "\nEVALUACIONES");
		this.mostrarEvaluaciones();
		
	}
	public void evaluacionParticular() {
		 
		for (int i = 0; i < evaluaciones.length; i++) {
			for (int j = 0; j < evaluaciones[i].length; j++) {
				if (evaluaciones[i][j]!=null) {
					evaluaciones[i][j].mostrarOtraInfo();;
				}
			}
	}
	}



	@Override
	public String toString() {
		String cadena = "";
		cadena =  "Diagnostico [codigoDiagnostico=" + codigoDiagnostico + ", severidad=" + severidad + ", evaluaciones=";
		this.evaluacionParticular();
		return  cadena;
				 
	}



	 




	
	
	
	


	
}
