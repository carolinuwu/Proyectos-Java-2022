package ar.edu.ort.tp1.examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.ort.tp1.examen.modeloClases.Centro;
import ar.edu.ort.tp1.examen.modeloClases.DiaEvaluacion;
import ar.edu.ort.tp1.examen.modeloClases.Diagnostico;
import ar.edu.ort.tp1.examen.modeloClases.Evaluacion;
import ar.edu.ort.tp1.examen.modeloClases.EvaluacionPorContinuidad;
import ar.edu.ort.tp1.examen.modeloClases.EvaluacionPorPedidoMedico;
import ar.edu.ort.tp1.examen.modeloClases.Guardia;
import ar.edu.ort.tp1.examen.modeloClases.Jornada;
import ar.edu.ort.tp1.examen.modeloClases.Paciente;
import ar.edu.ort.tp1.examen.modeloClases.Puntaje;
import ar.edu.ort.tp1.examen.modeloClases.PuntajeEvaluacion;
import ar.edu.ort.tp1.examen.modeloClases.Severidad;
import ar.edu.ort.tp1.examen.modeloClases.TurnoEvaluacion;

public class TestCentro {

	public static void main(String[] args) {

		 

		System.out.println("--- CREANDO CENTRO PSP ---");
		Centro centro = crearCentro(new ArrayList<Diagnostico>(), null);
		centro = crearCentro(new ArrayList<Diagnostico>(), "");

		List<Diagnostico> diagnosticosConDatos = generarDatosCentro();
		centro = crearCentro(diagnosticosConDatos, "FUNDACION ORT-PSP");

		testMostrarCentro(centro);
		 

	}

	private static Centro crearCentro(List<Diagnostico> diagnosticos, String nombre) {
		Centro retorno = null;
		try {
			retorno = new Centro(diagnosticos, nombre);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
		return retorno;
	}

	private static void testMostrarCentro(Centro c) {
		try {
			c.mostrar();
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private static List<Diagnostico> obtenerDiagnosticos() {
		Diagnostico d1 = new Diagnostico("PSP-D05", Severidad.ALTA);
		Diagnostico d2 = new Diagnostico("PSP-D04", Severidad.ALTA);
		Diagnostico d3 = new Diagnostico("PSP-D03", Severidad.BAJA);
		Diagnostico d4 = new Diagnostico("PSP-D02", Severidad.MEDIA);
		return new ArrayList<>(Arrays.asList(new Diagnostico[] { d1, d2, d3, d4 }));
	}

	private static List<Evaluacion> obtenerEvaluaciones() {
		EvaluacionPorPedidoMedico pm1 = new EvaluacionPorPedidoMedico(1, "02/05/2023", "MURIEL Z.", PuntajeEvaluacion.EN_EL_LIMITE, "DR. JUAN CARLOS Q.");
		EvaluacionPorPedidoMedico pm2 = new EvaluacionPorPedidoMedico(2, "03/05/2023", "MURIEL Z.", PuntajeEvaluacion.BAJO, "DR. LORENZO W.");
		EvaluacionPorPedidoMedico pm3 = new EvaluacionPorPedidoMedico(3, "08/05/2023", "MURIEL Z.", PuntajeEvaluacion.BAJO, "DR. LORENZO W.");
		EvaluacionPorPedidoMedico pm4 = new EvaluacionPorPedidoMedico(7, "10/05/2023", "MURIEL Z.", PuntajeEvaluacion.PROMEDIO_ALTO, "LIC. BEATRIZ L.");
		EvaluacionPorContinuidad pc1 = new EvaluacionPorContinuidad(4, "09/05/2023", "FERNANDA P.", PuntajeEvaluacion.PROMEDIO, "FALTA EVALUAR MOTRICIDAD");
		EvaluacionPorContinuidad pc2 = new EvaluacionPorContinuidad(5, "10/05/2023", "FERNANDA P.", PuntajeEvaluacion.PROMEDIO_ALTO, "MEJORAR CALCULO Y CONCENTRACION");
		EvaluacionPorContinuidad pc3 = new EvaluacionPorContinuidad(6, "17/05/2023", "VALERIA C.", PuntajeEvaluacion.MUY_ALTO, "PROFUNDIZAR LECTURA Y ORALIDAD");
		return new ArrayList<>(Arrays.asList(new Evaluacion[] { pm1, pm2, pm3, pm4, pc3, pc1, pc2 }));
	}

	private static List<Paciente> obtenerPacientes() {

		Paciente p1 = new Paciente(1, "JOAQUIN G.");
		int[] edad1 = { 11, 3 };
		p1.setEdadCronologica(edad1);
		Paciente p2 = new Paciente(2, "FLORENTINA F.");
		int[] edad2 = { 10, 9 };
		p2.setEdadCronologica(edad2);
		Paciente p3 = new Paciente(3, "LORENA B.");
		int[] edad3 = { 8, 7 };
		p3.setEdadCronologica(edad3);
		Paciente p4 = new Paciente(4, "ALEJANDRO F.");
		int[] edad4 = { 8, 7 };
		p4.setEdadCronologica(edad4);
		return new ArrayList<>(Arrays.asList(new Paciente[] { p1, p2, p3, p4 }));
	}

	private static void testMostrarEvaluacionesPorPaciente(Evaluacion eva) {
		eva.mostrar();
	}

	private static void testAgregarPacienteAEvaluacion(Evaluacion eva, Paciente p) {
		eva.evaluarPaciente(p);
	}

	private static void testAgregarEvaluacionADiagnostico(Diagnostico d, Evaluacion eva,  DiaEvaluacion t, TurnoEvaluacion g) {
		try {
			d.agregarEvaluacion(eva, g, t);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private static List<Diagnostico> generarDatosCentro() {
		List<Diagnostico> diagnosticos = obtenerDiagnosticos();
		List<Paciente> pacientes = obtenerPacientes();
		List<Evaluacion> evaluaciones = obtenerEvaluaciones();

		System.out.println("CARGANDO datos...");

		testAgregarPacienteAEvaluacion(evaluaciones.get(0), pacientes.get(0));
		testAgregarPacienteAEvaluacion(evaluaciones.get(1), pacientes.get(0));
		testAgregarPacienteAEvaluacion(evaluaciones.get(2), pacientes.get(1));
		testAgregarPacienteAEvaluacion(evaluaciones.get(3), pacientes.get(2));
		testAgregarPacienteAEvaluacion(evaluaciones.get(4), pacientes.get(2));
		testAgregarPacienteAEvaluacion(evaluaciones.get(5), pacientes.get(3));
		testAgregarPacienteAEvaluacion(evaluaciones.get(6), pacientes.get(3));

		testAgregarEvaluacionADiagnostico(diagnosticos.get(0), evaluaciones.get(0), DiaEvaluacion.LUNES, TurnoEvaluacion.MANIANA);
		testAgregarEvaluacionADiagnostico(diagnosticos.get(0), evaluaciones.get(1), DiaEvaluacion.MIERCOLES, TurnoEvaluacion.MANIANA);
		testAgregarEvaluacionADiagnostico(diagnosticos.get(1), evaluaciones.get(2), DiaEvaluacion.MARTES, TurnoEvaluacion.MANIANA);
		testAgregarEvaluacionADiagnostico(diagnosticos.get(2), evaluaciones.get(3), DiaEvaluacion.MARTES, TurnoEvaluacion.MEDIODIA);
		testAgregarEvaluacionADiagnostico(diagnosticos.get(2), evaluaciones.get(4), DiaEvaluacion.MARTES, TurnoEvaluacion.MEDIODIA);
		testAgregarEvaluacionADiagnostico(diagnosticos.get(3), evaluaciones.get(5), DiaEvaluacion.LUNES, TurnoEvaluacion.MANIANA);
		testAgregarEvaluacionADiagnostico(diagnosticos.get(3), evaluaciones.get(6), DiaEvaluacion.MIERCOLES, TurnoEvaluacion.TARDE);

		System.out.println("MOSTRANDO EVALUACIONES POR PACIENTE" + " ---" + "\n");
		for (int e = 0; e < evaluaciones.size(); e++) {
			testMostrarEvaluacionesPorPaciente(evaluaciones.get(e));
		}

		return diagnosticos;
	}

}