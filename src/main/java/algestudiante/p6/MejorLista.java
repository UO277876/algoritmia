package algestudiante.p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MejorLista {
	
	private int nCanciones;
	private int t;
	private int cont;
	
	private int sumaPuntuaciones;
	
	private Cancion[] canciones;
	private List<Cancion> bloqueA;
	private List<Cancion> bloqueB;
	
	private int mejorPunt;
	private List<Cancion> mejorBloqueA;
	private List<Cancion> mejorBloqueB;
	
	/**
	 * Constructor con dos parámetros de la clase MejorLista
	 */
	public MejorLista(int n) {
		this.t = t * 60;
		this.cont = 0;
		
		this.bloqueA = new ArrayList<Cancion>();
		this.bloqueB = new ArrayList<Cancion>();
		this.mejorBloqueA = new ArrayList<Cancion>();
		this.mejorBloqueB = new ArrayList<Cancion>();
		
		this.nCanciones = n;
		this.canciones = new Cancion[n];
		
		int sum = 0;
		int tiempo = 0;
		for(int i = 0; i < n; i++) {
			tiempo = (int) (Math.random()*((300 + 1) - 120) + 120);
			sum += tiempo;

			int puntuacion =  (int) (Math.random()*((5000 + 1) - 2000) + 2000);
			canciones[i] = new Cancion(tiempo,"1234",puntuacion);
		}
		
		this.t = sum/2;
	}
	
	/**
	 * Constructor con dos parámetros de la clase MejorLista
	 */
	public MejorLista(String file, int t) {
		this.t = t * 60;
		this.cont = 0;
		
		this.bloqueA = new ArrayList<Cancion>();
		this.bloqueB = new ArrayList<Cancion>();
		this.mejorBloqueA = new ArrayList<Cancion>();
		this.mejorBloqueB = new ArrayList<Cancion>();
		
		readDatosFromFile(file);
	}
	
	/**
	 * Lee de fichero y transforma los datos en una lista de enteros
	 * 
	 * @param file, el fichero de texto
	 * @return Una lista de enteros
	 */
	public void readDatosFromFile(String file)
	{
		BufferedReader fich = null;
		String line;
		int pos = 0;
		int index = 0;
		String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/algestudiante/p6/datos/"+ file +".txt";

		try {
			// abrimos el fichero
			fich = new BufferedReader(new FileReader(fileName));
			line = fich.readLine(); // Primer elemento del fichero
			while (line != null) {
				if(pos == 0) {
					this.nCanciones = Integer.valueOf(line);
					this.canciones = new Cancion[nCanciones];
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
			System.out.println("No existe el fichero: "+fileName);
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero: "+fileName);
		} finally {
			if (fich!=null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error cerrando el fichero: "+fileName);
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
		
		seg += min*60;
		
		canciones[index] = new Cancion(seg,name,puntuacion);
	}
	
	/**
	 * Comprueba la duración del bloque A
	 */
	private boolean comprobarBloqueA() {
		int sum = 0;
		for(Cancion ca : bloqueA) {
			sum += ca.getSegundos();
		}
		
		if(sum < t) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Comprueba la duración del bloque B
	 */
	private boolean comprobarBloqueB() {
		int sum = 0;
		for(Cancion ca : bloqueB) {
			sum += ca.getSegundos();
		}
		
		if(sum < t) {
			return true;
		}
		
		return false;
	}
	
	public void backtracking(int n) {
		if (n == nCanciones) {
			this.cont++;
			if(sumaPuntuaciones > mejorPunt) {
				mejorBloqueA.clear();
				mejorBloqueB.clear();
				
				for(Cancion ca : bloqueA) {
					mejorBloqueA.add(ca);
				}
				
				for(Cancion ca : bloqueB) {
					mejorBloqueB.add(ca);
				}
				
				mejorPunt = sumaPuntuaciones;
			}
			
		} else {
			for (int i = 0; i <= 2; i++) {
				
				// Añadimos a bloques
				if (i == 1) {
					bloqueA.add(canciones[n]);
					sumaPuntuaciones += canciones[n].getPuntuacion();
				} 
				
				if(i == 2) {
					bloqueB.add(canciones[n]);
					sumaPuntuaciones += canciones[n].getPuntuacion();
				}
				
				// Poda
				if(comprobarBloqueA() && comprobarBloqueB()) {
					backtracking(n + 1);
				}
				 
				// Deshacemos
				if (i == 1) {
					bloqueA.remove(canciones[n]);

					sumaPuntuaciones -= canciones[n].getPuntuacion();
				}

				if (i == 2) {
					bloqueB.remove(canciones[n]);

					sumaPuntuaciones -= canciones[n].getPuntuacion();
				}

			}
		}
	}
	
	public void print() {
		System.out.println("Número de canciones: " + nCanciones);
		System.out.println("");
		System.out.println("Lista de canciones: ");
		
		for(Cancion ca : canciones) {
			System.out.println("id: " + ca.getName() + " segundos: " + ca.getSegundos()/60 + ":" + ca.getSegundos()%60 + " puntuacion: " + ca.getPuntuacion());
		}
		
		System.out.println("Tamaño de los bloques: " + t/60 + ":" + t%60);
		System.out.println("Total puntuación: " + mejorPunt);
		System.out.println("");
		
		System.out.println("Mejor Bloque A:");
		for(Cancion ca : mejorBloqueA) {
			System.out.println("id: " + ca.getName() + " segundos: " + ca.getSegundos()/60 + ":" + ca.getSegundos()%60 + " puntuacion: " + ca.getPuntuacion());
		}
		
		System.out.println("Mejor Bloque B:");
		for(Cancion ca : mejorBloqueB) {
			System.out.println("id: " + ca.getName() + " segundos: " + ca.getSegundos()/60 + ":" + ca.getSegundos()%60 + " puntuacion: " + ca.getPuntuacion());
		}
		
		System.out.println("");
		System.out.println("Nodos hijo: " + this.cont);
	}
	

}
