package algestudiante.p4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class ColocacionSegmentos {
	
	private double[] v;
	
	/**
	 * Constructor con un parámetro de la clase ColocacionSegmentos
	 */
	public ColocacionSegmentos(int n) {
		this.v = new double[n + 1];
		this.v[0] = n;
		
		for(int i=1; i < this.v.length; i++) {
			this.v[i] = Math.random();
		}
	}
	
	/**
	 * Constructor con un parámetro de la clase ColocacionSegmentos
	 */
	public ColocacionSegmentos(String file) {
		readJuegoFromFile(file);
	}
	
	/**
	 * Lee de fichero y transforma los datos en una lista de enteros
	 * 
	 * @param file, el fichero de texto
	 * @return Una lista de enteros
	 */
	public void readJuegoFromFile(String file)
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
	
	public void devorador1() {
		double maxSeg = v[0];
		
		// 1. Colocación de segmentos: inicialización
		double x = 0;
		double y = v[1];
		double m = (x+y)/2;
		//System.out.println("S0"+"("+x+","+y+") = "+m);
		int it = 1;
		
		//2. Inicialización del sumatorio
		double pufosa = m;
		
		int aux = 2;
		
		while(it <= maxSeg - 1){
			x = y;
			y += v[aux];
			m = (x+y)/2;
			pufosa += m;
			
			//System.out.println("S"+it+"("+x+","+y+"), punto medio = "+m);
			it++;
			aux++;
		}
		
		//System.out.println("Coste DEVORADOR1 = " + pufosa + " pufosos");
	}
	
	public void devorador2() {
		rapirec(1,v.length-1,this.v);
		
		double maxSeg = v[0];
		// 1. Colocación de segmentos: inicialización
		double x = 0;
		double y = v[v.length - 1];
		double m = (x+y)/2;
		//System.out.println("S0"+"("+x+","+y+"), punto medio = "+m);
		int it = 1;
		
		//2. Inicialización del sumatorio
		double pufosa = m;
	
		int aux = v.length - 2;
		
		while(it <= maxSeg - 1){
			x = y;
			y += v[aux];
			m = (x+y)/2;
			
			pufosa += m;
			//System.out.println("S"+it+"("+x+","+y+"), punto medio = "+m);
			it++;
			aux--;
		}
		
		//System.out.println("Coste DEVORADOR2 = " + pufosa + " pufosos");
	}
	
	public void devorador3() {
		rapirec(1,v.length-1,this.v);
		
		double maxSeg = v[0];
		// 1. Colocación de segmentos: inicialización
		double x = 0;
		double y = v[1];
		double m = (x+y)/2;
		//System.out.println("S0"+"("+x+","+y+"), punto medio = "+m);
		int it = 1;
		
		//2. Inicialización del sumatorio
		double pufosa = m;
		
		int aux = 2;
		
		while(it <= maxSeg - 1){
			x = y;
			y += v[aux];
			m = (x+y)/2;
			
			pufosa += m;
			//System.out.println("S"+it+"("+x+","+y+"), punto medio = "+m);
			it++;
			aux++;
		}
		
		//System.out.println("Coste DEVORADOR3 = " + pufosa + " pufosos");
	}
	
	// QUICKSORT
	
	private static void rapirec (int iz,int de, double[] v) 
	{
		if (de > iz) 
		{
			int m= particion (iz,de,v);
			rapirec (iz,m-1,v);
			rapirec (m+1,de,v);
		}
	}

	private static int particion (int iz,int de, double[] v) 
	{
		int i;
		double pivote;
		intercambiar((iz+de)/2,iz,v); 		
		//el pivote es el de centro y se cambia con el primero
		pivote= v[iz]; 
		i=iz;
		for (int s=iz+1;s<=de;s++) 
			if (v[s]<=pivote) 
			{
				i++;
				intercambiar(i,s,v);
			}
		intercambiar (iz,i,v); 
		// se restituye el pivote donde debe estar
		return i;//retorna la posicion en que queda el pivote 
	}

	/** Intercambia 2 elementos
	 */
	private static void intercambiar(int i,int j, double[] v)
	{
		double t;
		t=v[i];
		v[i]=v[j];
		v[j]=t;
	}


}
