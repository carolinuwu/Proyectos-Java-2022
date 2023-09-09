package ar.edu.ort.tp1.examen.modeloClases;

import java.util.List;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public class Centro implements Mostrable {
    private static final String NOMBRE_INVALIDO = "El nombre del Centro no puede estar vacio ni ser nulo";
	private String nombre;
	private ListaOrdenadaDiagnosticos diagnosticosPorSeveridad;
	

	public Centro(List<Diagnostico> diagnosticos, String nombre) {
		 this.diagnosticosPorSeveridad = new ListaOrdenadaDiagnosticos();
		 this.agregarTodo(diagnosticos);
		this.setNombre(nombre);
	}

	private void setNombre(String nombre) {
		if (nombre==null||nombre.isEmpty()) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}
	private void agregarTodo(List<Diagnostico> diagnosticos) {
        for (int i = 0; i < diagnosticos.size(); i++) {
        	this.diagnosticosPorSeveridad.add(diagnosticos.get(i));
		}
		 
		 
	}

	@Override
	public void mostrar() {
		System.out.println("--------------------------------");
		System.out.println("MOSTRANDO DIAGNOSTICOS ");
		for (Diagnostico diagnostico : diagnosticosPorSeveridad) {
			System.out.println("SEVERIDAD : " + diagnostico.getSeveridad());
			System.out.println(diagnostico);
		}
		
	}
	private void mostrarEvaluaciones() {
		this.diagnosticosPorSeveridad.forEach(diagnostico->diagnostico.mostrarEvaluaciones());
	}
	

	//TODO completar aquí estructuras/variables necesarias
	
	
	//TODO desarrollar constructor
	
	
	//TODO agregar diagnósticos a la estructura correspondiente;
	
	
	//TODO controlar nombre vacío o nulo;
	
	
	//TODO implementar método mostrar;
}
	
	
	
	
	

