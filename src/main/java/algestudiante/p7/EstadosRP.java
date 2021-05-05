package algestudiante.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algestudiante.p7.util.Estado;

/**
 * Estado Asignaci�n Agentes - Tareas
 * Hereda de la clase Estado
 */
public class EstadosRP extends Estado 
{
	// Datos comunes a todos los estados, por eso los declaramos "static"
	private static int tmax;				// Tiempo máximo
	private static CancionRP[] canciones;		// Lista de canciones
	private static boolean traza= false;	// permite activar o desactivar traza

	// Estado
	private int[] solParcial;				
	private boolean[] cancionMarcada;	
	
	private int duracionActual;
	private int puntuacionActual;
	
	private List<CancionRP> bloqueA;
	private List<CancionRP> bloqueB;
	
	/**
	 * Constructor para crear el estado inicial,
	 * Establecemos los datos y condiciones iniciales del problema
	 */
	public EstadosRP(CancionRP[] listaCanciones, int t) {
		super();
		
		// Guardamos el tiempo máximo y la lista de canciones
		tmax = t*60;
		canciones = listaCanciones;
		
		// Inicializamos la canción y duración actuales
		this.duracionActual = 0;
		this.puntuacionActual = 0;

		// Inicializa variables de cada estado
		bloqueA = new ArrayList<CancionRP>();
		bloqueB = new ArrayList<CancionRP>();
		
		cancionMarcada=new boolean[canciones.length];
		for (int i= 0; i<canciones.length; i++)
			cancionMarcada[i]= false;
		
	}

	/**
	 * Constructor para crear un estado a partir del padre
	 */
	public EstadosRP(EstadosRP padre,int j) {
		super();
		// copiamos toda la informaci�n del padre		
		this.bloqueA = padre.bloqueA;
		this.bloqueB = padre.bloqueB;
		this.puntuacionActual = padre.puntuacionActual;
		this.duracionActual = padre.duracionActual;
		cancionMarcada= Arrays.copyOf(padre.cancionMarcada,canciones.length);
		profundidad= padre.profundidad;
		idPadre= padre.getId();
		
		// a�ade lo correspondiente a este hijo
		cancionMarcada[j]= true;	// marcamos la tarea como asignada
		profundidad++;
		calcularValorHeuristico();
		
		// UNIFICA LOS DOS �LTIMOS NIVELES DEL �RBOL DE ESTADOS
		if (profundidad==canciones.length-1)
		{
			int cancionPorAsignar= -1;
			for (int k= 0; k<canciones.length; k++)
				if (!cancionMarcada[k])
					cancionPorAsignar= k;
			
			solParcial[profundidad] = cancionPorAsignar;		// profundidad se corresponde con el primer agente sin asignar
			cancionMarcada[cancionPorAsignar]= true;	// marcamos la tarea como asignada
			profundidad++;							
			calcularValorHeuristico();
		}

	}

	/**
	 * Calcula el valor del heur�stico y lo guarda
	 */
	@Override
	public void calcularValorHeuristico() {
		valorHeuristico = 0;
		if(solucion()) {
			valorHeuristico = puntuacionActual;
		} else {
			double mejor = (canciones[profundidad+1].getPuntuacion()/canciones[profundidad+1].getSegundos())+0.5;
			duracionActual += canciones[profundidad+1].getSegundos();
			puntuacionActual += canciones[profundidad+1].getPuntuacion();
			valorHeuristico = (int) (canciones[profundidad].getPuntuacion()+(duracionActual - canciones[profundidad].getSegundos())*mejor);
		}
		
	}

	@Override
	public ArrayList<Estado> expandir() {
		ArrayList<Estado> listaHijos = new ArrayList<Estado>();

		// Recorre todas las tareas
		for (int i = 0; i <= 2; i++)
			if (duracionActual <= tmax) {
				if (i == 1) {
					Estado estadoHijo = new EstadosRP(this, i);
					listaHijos.add(estadoHijo);
					
					bloqueA.add(canciones[profundidad]);
				}

				if (i == 2) {
					Estado estadoHijo = new EstadosRP(this, i);
					listaHijos.add(estadoHijo);
					
					bloqueB.add(canciones[profundidad]);
				}
				
				if (traza)  // imprimimos estado hijo generado
				{
					System.out.println("Nivel: "+profundidad+" - Hijo: "+ i);
				}
			}

		return listaHijos;
	}

	@Override
	public boolean solucion() {
		if (profundidad == canciones.length)
			return true;
		else
			return false;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer("===============\n");
		
		sb.append("Bloque A:\n");
		for(CancionRP ca : bloqueA) {
			sb.append(ca.getPuntuacion() + "\n");
		}

		sb.append("Bloque B:\n");
		for(CancionRP ca : bloqueB) {
			sb.append(ca.getPuntuacion() + "\n");
		}
		
		sb.append("Valor heuristico = " + valorHeuristico + "\n");
		sb.append("===============\n");
		return sb.toString();
	}

}
