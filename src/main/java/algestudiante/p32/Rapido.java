package algestudiante.p32;

public class Rapido
{
	static int []v;

	public static void rapido (int[] v) 
	{
		rapirec (0,v.length-1);
	}

	private static void rapirec (int iz,int de) 
	{
		if (de>iz) 
		{
			int m= particion (iz,de);

			rapirec (iz,m-1);
			rapirec (m+1,de);
		}
	}

	private static int particion (int iz,int de) 
	{
		int i, pivote;
		intercambiar((iz+de)/2,iz); 		
		//el pivote es el de centro y se cambia con el primero
		pivote= v[iz]; 
		i=iz;
		for (int s=iz+1;s<=de;s++) 
			if (v[s]<=pivote) 
			{
				i++;
				intercambiar(i,s);
			}
		intercambiar (iz,i); 
		// se restituye el pivote donde debe estar
		return i;//retorna la posicion en que queda el pivote 
	}

	/** Intercambia 2 elementos
	 */
	private static void intercambiar(int i,int j)
	{
		int t;
		t=v[i];v[i]=v[j];v[j]=t;
	}
	
	public static void imprimirVector(String etiqueta, int[] v, int izq, int der)
	{
		System.out.print(etiqueta);

		for (int i=izq; i<der; i++) 
			System.out.print (v[i]+" ");
		System.out.println("\tizq= "+izq+" der="+der);
	}
} 
