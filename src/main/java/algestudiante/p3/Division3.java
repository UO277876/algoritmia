package algestudiante.p3;

/**
	Es un método recursivo POR DIVISION
	Los parámetros son: a=2; b=2; k=0
	Luego la complejidad temporal es lineal O(n)
	y la complejidad MPILA es O(log n), por lo que
	por mucho que crezca n no se desbordará
 */
public class Division3
{

	static long cont;

	public static boolean rec3 (int n)
	{
		if (n<=0) 
			cont++;
		else
		{ 
			cont++ ; // O(1)    
			rec3 (n/2);
			rec3 (n/2);
		}
		return true;   
	}
	
	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		int nVeces= 1000000;
		boolean b=true;

		for (int n=1;n<=10_000_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec3 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (n+ " "+(t2-t1));

		}  // for

	} // main
} //class