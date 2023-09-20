package ar.edu.ort.tp1.examen.modeloClases;

import java.util.List;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaDiagnosticos extends ListaOrdenadaNodos<Severidad, Diagnostico> {
 	/*
	 * Se podria prescindir de esta clase(lo solicitado por la institucion academica es utilizarla) 
         * guardando los diagnosticos en alguna implementacion de List
	 * e invocando al metodo sort como 
        *diagnosticosSinOrdenar.sort((diagnostico1,diagnostico2)->diagnostico2.getSeveridad().ordinal()-diagnostico1.getSeveridad().ordinal());
	*inciso: siempre que no hubiesen sido cargados con List.of() u otro metodo que retornase una coleccion inmutable 
       *     Si la coleccion de diagnosticos fuese mayor incluso quizas seria mas eficiente utilizar un stream
	 * como sigue :
	 *  	Map<Severidad,List<Diagnostico>> diagnosticosOrdenados = diagnosticosSinOrdenar.stream()
			  .collect(groupingBy(Diagnostico::getSeveridad));
     Si despues tuviese que mostrarlos :
		diagnosticosOrdenados.forEach((Diagnostico,Severidad)->{
			System.out.println("Severidad : " + Diagnostico);
			System.out.println("Diagnostico : " + Severidad);
		});
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
