package algestudiante.p7;

import algestudiante.p7.util.RamificaYPoda;

public class MejorListaRPTiempos extends RamificaYPoda {
	
	static MejorListaRP mj;
	
	public static void main(String[] args) {
		long t1, t2;
		int nVeces = 1000000;
		for (int n = 100; n < 100000000; n*=2) {
			mj = new MejorListaRP(n);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				mj.ramificaYPoda(mj.getNodoRaiz()); 
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
		}
	}
}
