package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public abstract class Evaluacion implements Mostrable{

	 
	private int nroEvaluacion;
	private String fechaAplicacion;
	private String nombreExaminador;
	private PuntajeEvaluacion ptaje;
	private DiaEvaluacion dia;
	private TurnoEvaluacion turno;
	
	public Evaluacion(int nroEvaluacion, String fechaAplicacion, String nombreExaminador, PuntajeEvaluacion ptaje) {
		super();
		this.nroEvaluacion = nroEvaluacion;
		this.fechaAplicacion = fechaAplicacion;
		this.nombreExaminador = nombreExaminador;
		this.ptaje = ptaje;
	}
	
	public void guardarDia(DiaEvaluacion dia) {
		this.dia = dia;
	}
	public void guardarTurno(TurnoEvaluacion turno) {
		this.turno = turno;
	}
	
	
	@Override
	public void mostrar() {
		System.out.println("EVALUACION NRO : " + this.nroEvaluacion + "---" + this.getClass().getSimpleName().toUpperCase());
		  this.mostrarInfoMasDetallada();
	}
	
	
	public abstract void mostrarInfoMasDetallada();

	public abstract void evaluarPaciente(Paciente p);
	
	public  void mostrarOtraInfo() {
		System.out.println("EVALUACION NRO : " + nroEvaluacion
				+ " REALIZADA EL : " + fechaAplicacion + " POR : " + nombreExaminador + " PUNTAJE : " +ptaje  
				);  this.observacion();
	}
	public abstract void observacion();

	
}
