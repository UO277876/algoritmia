package algestudiante.p4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ColocacionSegmentos {
	
	private Integer[] v;
	
	/**
	 * Constructor con un parámetro de la clase ColocacionSegmentos
	 */
	public ColocacionSegmentos(String file) {
		List<Integer> list = readRankingFromFile(file);
		
		this.v = new Integer[list.size()];
		list.toArray(this.v);
	}
	
	/**
	 * Lee de fichero y transforma los datos en una lista de enteros
	 * 
	 * @param file, el fichero de texto
	 * @return Una lista de enteros
	 */
	public static List<Integer> readRankingFromFile(String file)
	{
		BufferedReader fich = null;
		String line;
		List<Integer> elements = new ArrayList<Integer>();

		try {
			// abrimos el fichero
			fich = new BufferedReader(new FileReader(file));
			line = fich.readLine(); // Primer elemento del fichero
			while (line != null) {
				elements.add(Integer.parseInt(line));
				line = fich.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero: "+file);
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero: "+file);
		} finally {
			if (fich!=null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error cerrando el fichero: "+file);
					e.printStackTrace();
				}
		}

		return elements;
	}
	
	public void devorador1() {
		// 1. Colocación de segmentos: inicialización
		int x = 0;
		int y = v.length - 1;
		int m = (x+y)/2;
		
		//2. Inicialización del sumatorio
		int pufosa = 0;
		
		while(v.length != 0 && pufosa < v.length){
			
		}
	}

}
