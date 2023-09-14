package ar.edu.ort.tp1.examen.modeloClases;

import java.util.List;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaDiagnosticos extends ListaOrdenadaNodos<Severidad, Diagnostico> {
 	/*
	 * Se podria prescindir de esta clase(lo solicitado por la institucion academica es utilizarla) 
         * guardando los diagnosticos en un arrayList
	 * e invocando al metodo sort como 
	 * listaDiagnosticos.sort((Diagnostico diagnostico1, Diagnostico diagnostico2)-> diagnostico1.getSeveridad().ordinal-diagnostico2.getSeveridad().ordinal);
	 * Si la coleccion de diagnosticos fuese mayor incluso quizas seria mas eficiente utilizar un stream
	 * como sigue :
	 *  List<Diagnostico> diagnosticos;
		List<Diagnostico> diagnosticosOrdenadosPorSeveridad= diagnosticos.stream()
		 .sorted((Diagnostico diagnostico1, Diagnostico diagnostico2)-> diagnostico1.getSeveridad().ordinal()-diagnostico2.getSeveridad().ordinal())
		 .toList();
	 */
	ListaOrdenadaDiagnosticos() {
	}
	@Override
	public int compare(Diagnostico dato1, Diagnostico dato2) {
		// TODO Auto-generated method stub
		return dato2.getSeveridad().ordinal()-dato1.getSeveridad().ordinal();
	}

	 @Override
	    public int compareByKey(Severidad clave, Diagnostico elemento) {
	        return clave.ordinal() - elemento.getSeveridad().ordinal();
	    }
	 public void agregarTodo(List<Diagnostico> diagnosticos) {
		 for (int i = 0; i < diagnosticos.size(); i++) {
			this.add(diagnosticos.get(i));
		}
	}
	 

}
