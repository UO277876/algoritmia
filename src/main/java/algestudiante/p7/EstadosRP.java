package algestudiante.p7;

import java.util.ArrayList;
import java.util.Arrays;

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
	private static boolean traza= true;	// permite activar o desactivar traza

	// Estado
	private int[] solParcial;				// solParcial[i]=k es al trabajador i se le asigna la tarea k 
	private boolean[] tareaConTrabajador;	// Marca las tareas ya asignadas
	
	private int duracionActual;
	private int puntuacionActual;
	
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
		solParcial = new int[canciones.length];
		for (int i=0;i<solParcial.length;i++)
			solParcial[i] = -1;//sin asignaciones inicialmente
		
		tareaConTrabajador=new boolean[solParcial.length];
		for (int i= 0; i<canciones.length; i++)
			tareaConTrabajador[i]= false;
		
	}

	/**
	 * Constructor para crear un estado a partir del padre
	 */
	public EstadosRP(EstadosRP padre,int j) {
		super();
		// copiamos toda la informaci�n del padre		
		solParcial= Arrays.copyOf(padre.solParcial,canciones.length);
		tareaConTrabajador= Arrays.copyOf(padre.tareaConTrabajador,canciones.length);
		profundidad= padre.profundidad;
		idPadre= padre.getId();
		
		// a�ade lo correspondiente a este hijo
		solParcial[profundidad] =j;		// profundidad se corresponde con el primer agente sin asignar
		tareaConTrabajador[j]= true;	// marcamos la tarea como asignada
		profundidad++;
		calcularValorHeuristico();
		
		// UNIFICA LOS DOS �LTIMOS NIVELES DEL �RBOL DE ESTADOS
		if (profundidad==canciones.length-1)
		{
			int tareaPorAsignar= -1;
			// Busca �ltima tarea por asignar
			for (int k= 0; k<canciones.length; k++)
				if (!tareaConTrabajador[k])
					tareaPorAsignar= k;
			
			solParcial[profundidad] =tareaPorAsignar;		// profundidad se corresponde con el primer agente sin asignar
			tareaConTrabajador[tareaPorAsignar]= true;	// marcamos la tarea como asignada
			profundidad++;							
			calcularValorHeuristico();
		}

	}

	/**
	 * Calcula el valor del heur�stico y lo guarda
	 */
	@Override
	public void calcularValorHeuristico() {
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
					Estado estadoHijo1 = new EstadosRP(this, i);
					listaHijos.add(estadoHijo1);
				}

				if (i == 2) {
					Estado estadoHijo2 = new EstadosRP(this, i);
					listaHijos.add(estadoHijo2);
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
		for (int i=0; i<solParcial.length; i++) 
		{
			if (solParcial[i] != -1)
				sb.append("AL TRABAJADOR "+i+" SE LE ASIGNA LA TAREA "+solParcial[i]+"\n");
			else
				sb.append("LA TAREA "+i+" NO HA SIGO ASIGNADA TODAVIA\n");
		}
		sb.append("Valor heuristico = " + valorHeuristico + "\n");
		sb.append("===============\n");
		return sb.toString();
	}

}
