package algestudiante.p11;

public class Vector2 {
	
	static int []v;
	
	public static void main(String[] args) {
		long t1,t2;
		int n= 10000000;
		v = new int[n];
		
		Vector1.rellena(v);
		
		t1 = System.currentTimeMillis();
		
		// Queremos medir cuanto tarda esta operación
		Vector1.suma(v);
		
		t2 = System.currentTimeMillis();
		
		long tmedio = t2-t1;
		System.out.println("Tiempo suma elementos: " + tmedio);
	}

}
