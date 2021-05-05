package algestudiante.p7;

import algestudiante.p7.util.RamificaYPoda;

public class MejorListaRPTiempos extends RamificaYPoda {
	
	static MejorListaRP mj;
	
	public static void main(String[] args) {
		long t1, t2;
		int nVeces = 1;
		int index = 1;
		for (int n = 5; n < 31; n*=index) {
			mj = new MejorListaRP(n);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				mj.ramificaYPoda(mj.getNodoRaiz()); 
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
			index++;
		}
	}
}
