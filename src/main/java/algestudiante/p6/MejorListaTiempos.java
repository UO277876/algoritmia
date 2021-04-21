package algestudiante.p6;

public class MejorListaTiempos {
	
	static MejorLista mj;
	
	public static void main(String[] args) {
		//MejorLista mj = new MejorLista("Lista01",100);
		//mj.backtracking(0);
		//mj.print();
		
		long t1, t2;
		int nVeces = 100;
		
		for (int n = 100; n < 100000000; n*=2) {
			mj = new MejorLista("Lista01",n);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				mj.backtracking(0);
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
		}
	}
}
