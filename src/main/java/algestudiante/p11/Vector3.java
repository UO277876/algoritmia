package algestudiante.p11;

public class Vector3 {
	
	static int []v;
	
	public static void main(String[] args) {
		long t1, t2;
		
		System.out.println("\ntt");
		for (int n = 1000000; n < 100000000; n+=1000000) {
			v = new int[n];

			Vector1.rellena(v);

			t1 = System.currentTimeMillis();

			// Queremos medir cuanto tarda esta operación
			Vector1.suma(v);

			t2 = System.currentTimeMillis();

			long tmedio = t2 - t1;
			System.out.println(n + "\t" + tmedio);
		}
	}

}
