package algestudiante.p6;


public class TiemposMejorLista {
	
	//static ColocacionSegmentos co;
	
	public static void main(String[] args) {
		long t1, t2;
		int nVeces = 10;
		
		for (int n = 100; n < 100000000; n*=2) {

			// INTRODUCIR INICIALIZACIÓN

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				// INTRODUCIR MÉTODO
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
		}
		
	}
	

}
