package algestudiante.p32;

import java.util.List;

public class Inversiones {
	
	private Integer[] array;

	/**
	 * Constructor con un parámetro de la clase Inversiones
	 * 
	 * @param ranking, la lista de elementos a analizar
	 */
	public Inversiones(List<Integer> ranking) {
		this.array = new Integer[ranking.size()];
		ranking.toArray(this.array);
	}

	/**
	 * Método externo para contar las inversiones que llama al método recursivo que lo hace
	 * 
	 * @return el número de inversiones
	 */
	public String start() {
		return String.valueOf(contInvRec(0,array.length-1));
	}
	
	/**
	 * Método recursivo para el divide y vencerás con a=2, b=2, k=1
	 por división
	  
	 * @param iz, la parte izquierda del vector
	 * @param de, la parte derecha del vector
	 * @return el número de inversiones total 
	 */
	private long contInvRec(int iz, int de) {
		if(iz==de) {
			return 0;
		} else {
			int m=(iz+de)/2;
			
			long x = contInvRec(iz,m);
			long y = contInvRec(m+1,de);
			long c = ordenarMezclarMitades(iz,m,m+1,de);
			return x + y + c;
		}
	}
	
	/**
	 * Ordena las dos particiones y las mezcla
	 */
	private long ordenarMezclarMitades(int iz, int med, int med1, int de) {
		// 1. Creamos los dos vectores sobre los que iteramos
		int tam1 =  (med-iz)+1;
		int tam2 = (de-med1)+1;
		int [] m1 = new int[tam1];
		int [] m2 = new int[tam2];
		for(int i=0; i < tam1; i++) m1[i] = array[iz+i];	
		for(int i=0; i < tam2; i++) m2[i] = array[med1+i];
		
		// 2. Los ordenamos	
		rapirec(0,tam1-1,m1);
		rapirec(0,tam2-1,m2);
		
		// 3. Mezcla de ambas partes (O(n))
		long c = 0;
		int aux1=0;
		int aux2=0;

		while(aux1 < tam1 && aux2 < tam2) {
			if(m1[aux1] > m2[aux2]) {
				c += tam1 - aux1; // c igual a los elementos que quedan sin procesar de la 1º mitad 
				aux2 += 1;
			} else {
				aux1 += 1;
			}			
		}
		
		return c; 
	}
	
	// QUICKSORT
	private static void rapirec (int iz,int de, int[] v) 
	{
		if (de > iz) 
		{
			int m= particion (iz,de,v);
			rapirec (iz,m-1,v);
			rapirec (m+1,de,v);
		}
	}

	private static int particion (int iz,int de, int[]v) 
	{
		int i, pivote;
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
	private static void intercambiar(int i,int j,int[] v)
	{
		int t;
		t=v[i];
		v[i]=v[j];
		v[j]=t;
	}

}
