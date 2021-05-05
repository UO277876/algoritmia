// PROBLEMA 1: ASIGNACION n TRABAJADORES-n TAREAS
// RESUELTO POR RAMIFICA Y PODA

package algestudiante.p7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import algestudiante.p7.util.RamificaYPoda;

/**
 * Clase principal para el problema de Asignacion de agentes - tareas
 * Herada de RamificaYPoda 
 */
class MejorListaRP extends RamificaYPoda 
{	
	private static boolean traza= false;
	private static int tam = 0;
	private static CancionRP[] canciones;

	public static void main(String[] args) 
	{
		System.out.println("Problema de Agentes - tareas /// Ramificacion y poda");
		// EL NOMBRE DEL FICHERO DEBE IR SIN LA TERMINACIÓN .TXT
		//String nameFile = args[0];
		//tam = Integer.valueOf(args[1]);
		String nameFile = "Lista01";
		tam = 20;
		
		// Creamos una instancia para resolver el problema
		MejorListaRP problemaAsigna = new MejorListaRP(nameFile); 

		// Ejecutamos el m�todo que va recorriendo el espacio de soluciones con ramifica y poda
		problemaAsigna.ramificaYPoda(problemaAsigna.getNodoRaiz()); 
		
		// Soluci�n final
		System.out.println("Solucion optima del problema $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(problemaAsigna.mejorSolucion);

		if (traza)
			problemaAsigna.mostrarTrazaSolucion(); 
	}


	/**
	 * Constructor crea el estaod inicial para iniciar el problema
	 */
	public MejorListaRP(String nameFile) 
	{
		readDatosFromFile(nameFile);
		nodoRaiz = new EstadosRP(canciones,tam); //costes iniciales
	}
	
	/**
	 * Lee de fichero y transforma los datos en una lista de enteros
	 * 
	 * @param file, el fichero de texto
	 * @return Una lista de enteros
	 */
	public void readDatosFromFile(String file) {
		BufferedReader fich = null;
		String line;
		int pos = 0;
		int index = 0;
		String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/algestudiante/p6/datos/" + file
				+ ".txt";

		try {
			// abrimos el fichero
			fich = new BufferedReader(new FileReader(fileName));
			line = fich.readLine(); // Primer elemento del fichero
			while (line != null) {
				if (pos == 0) {
					int nCanciones = Integer.valueOf(line);
					canciones = new CancionRP[nCanciones];
					line = fich.readLine();
					pos++;
				} else {
					String[] parts = line.split("\t");
					introducirCancion(parts, index);
					index++;
					line = fich.readLine();
					pos++;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero: " + fileName);
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero: " + fileName);
		} finally {
			if (fich != null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error cerrando el fichero: " + fileName);
					e.printStackTrace();
				}
		}
	}

	/**
	 * Crea la nueva canción para la lista de canciones
	 * 
	 * @param parts, las partes de cada canción
	 * @param index, la fila donde va en el vector
	 */
	private void introducirCancion(String[] parts, int index) {
		String name = parts[0];
		int puntuacion = Integer.valueOf(parts[2]);

		String[] time = parts[1].split(":");
		int min = Integer.valueOf(time[0]);
		int seg = Integer.valueOf(time[1]);

		seg += min * 60;

		canciones[index] = new CancionRP(seg, name, puntuacion);
	}

}

