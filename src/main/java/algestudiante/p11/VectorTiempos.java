package algestudiante.p11;

public class VectorTiempos {

	static int []v;
	static int []m;
	
	public static void main(String[] args) {
		long t1, t2;
		int nVeces = 1000;
		
		int sumatorio = 0;
		
		for (int n = 10; n < 100000000; n*=3) {

			v = new int[n];
			m = new int[n];

			Vector1.rellena(v);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				// Queremos medir cuanto tarda esta operación
				Vector1.suma(v);
				//Vector1.maximo(v, m);
				sumatorio = Vector1.suma(v);
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio + "\t" + sumatorio);
		}
	}
}
