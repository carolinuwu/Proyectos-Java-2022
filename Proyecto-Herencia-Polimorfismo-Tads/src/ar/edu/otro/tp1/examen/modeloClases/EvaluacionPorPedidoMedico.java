package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class EvaluacionPorPedidoMedico extends Evaluacion {
private String nombreMedicoSolicitante;
private Cola<Paciente> pacientes;
//LOS DATOS DE LOS PACIENTES VAN A ESTAR ENCOLADOS 
public EvaluacionPorPedidoMedico(int nroEvaluacion, String fechaAplicacion, String nombreExaminador,
		PuntajeEvaluacion enElLimite, String nombreMedicoSolicitante) {
	super(nroEvaluacion, fechaAplicacion, nombreExaminador, enElLimite);
	this.nombreMedicoSolicitante = nombreMedicoSolicitante;
	this.pacientes = new ColaNodos<>();
}
@Override
public void mostrarInfoMasDetallada() {
	while (!this.pacientes.isEmpty()) {
		pacientes.remove().mostrar();
	}
	
}
@Override
public void evaluarPaciente(Paciente p) {
	this.pacientes.add(p);
	
}
@Override
public void observacion() {
	System.out.println("SOLICITA : " + this.nombreMedicoSolicitante);
	
}

}
