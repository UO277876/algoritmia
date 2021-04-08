package algestudiante.p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class MejorLista {
	
	private int nCanciones;
	
	
	/**
	 * Constructor con un parámetro de la clase Streaming
	 */
	public MejorLista(String file) {
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
		String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/algestudiante/p4/datos/"+ file +".txt";

		try {
			// abrimos el fichero
			fich = new BufferedReader(new FileReader(fileName));
			line = fich.readLine(); // Primer elemento del fichero
			while (line != null) {
				if(pos == 0) {
					this.v = new double[Integer.valueOf(line) + 1];
					this.v[0] = Integer.valueOf(line);
					line = fich.readLine();
					pos++;
				} else {
					this.v[pos] = Integer.valueOf(line);
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
	

}
