package algestudiante.p4;


public class TiemposColocacionSegmentos {
	
	static ColocacionSegmentos co;
	
	public static void main(String[] args) {
		long t1, t2;
		int nVeces = 10;
		
		for (int n = 100; n < 100000000; n*=2) {

			co = new ColocacionSegmentos(n);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				co.devorador3();
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
		}
		
	}
	

}
