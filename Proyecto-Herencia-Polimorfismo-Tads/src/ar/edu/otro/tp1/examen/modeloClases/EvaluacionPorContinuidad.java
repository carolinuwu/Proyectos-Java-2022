package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class EvaluacionPorContinuidad extends Evaluacion {
	private String motivoContinuidad;
	private Pila<Paciente> pacientes;
	
public EvaluacionPorContinuidad(int nroEvaluacion, String fechaAplicacion, String nombreExaminador,
			PuntajeEvaluacion ptaje,String motivoContinuidad) {
		super(nroEvaluacion, fechaAplicacion, nombreExaminador, ptaje);
		this.motivoContinuidad = motivoContinuidad;
		this.pacientes = new PilaNodos<>();
	}

@Override
public void mostrarInfoMasDetallada() {
	while (!this.pacientes.isEmpty()) {
		this.pacientes.pop().mostrar();
	}
	
}

@Override
public void evaluarPaciente(Paciente p) {
	this.pacientes.push(p);
	
}

@Override
public void observacion() {
	System.out.println(this.motivoContinuidad.toUpperCase());
	
}

 



 

 

}
