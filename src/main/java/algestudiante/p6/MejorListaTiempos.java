package algestudiante.p6;

public class MejorListaTiempos {
	
	static MejorLista mj;
	
	public static void main(String[] args) {
		//MejorLista mj = new MejorLista("Lista01",100);
		//mj.backtracking(0);
		//mj.print();
		
		long t1, t2;
		int nVeces = 100;
		int index = 2;
		for (int n = 5; n < 31; n*=index) {
			mj = new MejorLista(n);

			t1 = System.currentTimeMillis();
			
			for(int rep = 0; rep < nVeces; rep++) {
				mj.backtracking(0);
			}

			t2 = System.currentTimeMillis();

			long tMedio = t2 - t1;
			System.out.println(n + "\t" + tMedio);
			index++;
		}
	}
}
