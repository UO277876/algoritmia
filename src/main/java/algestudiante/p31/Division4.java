package algestudiante.p31;

/**
	Es un método recursivo POR DIVISION
	Los parámetros son: a=2; b=2; k=0
	Luego la complejidad temporal es lineal O(n)
	y la complejidad MPILA es O(log n), por lo que
	por mucho que crezca n no se desbordará
 */
public class Division4
{

	static long cont;

	public static boolean rec4 (int n)
	{
		if (n<=0) 
			cont++;
		else
		{ 	
			// k = 2
			for (int i=1;i<n;i++) {
				for (int j=1;j<i;j++) {
					cont++ ;     
				}
			}
			// a = 4
			// b = 3 (Por ejemplo para que a < b^k)
			rec4 (n/3);
			rec4 (n/3);
			rec4 (n/3);
			rec4 (n/3);
		}
		return true;   
	}
	
	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		int nVeces= Integer.parseInt (arg [0]);
		boolean b=true;

		for (int n=1;n<=10_000_000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec4 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);

		}  // for

	} // main
} //class