package ar.edu.ort.tp1.examen.modeloClases;

import java.util.List;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;
/*
	 *  No es lo solicitado, pero quizas seria mas conveniente que en esta y otras clases
  se utilizen modificadores final para minimizar la mutabilidad
 
	 */
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

		 /*
		  * Algunos autores apuntan a que las iteraciones internas son preferibles a las internas, asique sino podria utilizar esto como
    	System.out.println("--------------------------------");
		System.out.println("MOSTRANDO DIAGNOSTICOS ");
		this.diagnosticosPorSeveridad.forEach(diagnostico -> {
		    System.out.println("SEVERIDAD " + diagnostico.getSeveridad());
		    System.out.println(diagnostico);
		});
		 System.out.println("-------------------");
		
	}
		  * 
		  */
	}
	private void mostrarEvaluaciones() {
		
		this.diagnosticosPorSeveridad.forEach(diagnostico->diagnostico.mostrarEvaluaciones());
	}
/* La utilizacion de la clase ListaOrdenadaNodos fue a pedido de la institucion academica pero quizas para una coleccion  mayor seria mas performante
utilizar un stream 
private List<Diagnostico> generarListaOrdenadaDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticosPorSeveridad= diagnosticos.stream()
				.sorted((diagnostico1, diagnostico2)->diagnostico2.getSeveridad().ordinal()-diagnostico1.getSeveridad().ordinal())
				.toList();
		return diagnosticosPorSeveridad;
  o sino sortearla directamente si se pretende prescindir de la clase ListaOrdenadaDiagnosticos
  private void ordenarDiagnosticos(List<Diagnostico> diagnosticos) {
diagnosticos.sort((diagnostico1,diagnostico2)->diagnostico2.getSeveridad().ordinal()-diagnostico1.getSeveridad().ordinal())
	 ;
 	 
	}
	}
 
 * 
 */
 
}
	
	
	
	
	

