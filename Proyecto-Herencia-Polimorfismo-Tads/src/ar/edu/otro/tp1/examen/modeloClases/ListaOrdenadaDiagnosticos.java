package ar.edu.ort.tp1.examen.modeloClases;

import java.util.List;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaDiagnosticos extends ListaOrdenadaNodos<Severidad, Diagnostico> {

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
