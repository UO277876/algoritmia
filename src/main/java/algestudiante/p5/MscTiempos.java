package algestudiante.p5;

public class MscTiempos {
	
	static String mode = "progdin"; //"DV";   
	static int nTimes = 1000;
	
	public static void main(String args[]) {
		long t1 = 0;
		long t2 = 0;
		//float total = 10;
		
		System.out.println("MODO: " + mode);
		
		if (mode.equals("progdin")) {
			MSC msc;	
			for (int n=100; n < 100000000; n*=2) { 
				msc = new MSC(n);
				msc.iniTabla();
			    msc.rellenaTabla();
			    
				t1 = System.currentTimeMillis();  
				
			    //msc.encontarMSC(false);
				for(int rep = 0; rep < nTimes; rep++) {
					msc.encontarMSC(false);
				}
				
			    t2 = System.currentTimeMillis();
			    
			    //total= (float) (t2 - t1);
			    long tMedio = t2 - t1;
				System.out.println(n + "\t" + tMedio);
			    //System.out.println("Tiempo [ms]= " + total/nTimes + ", n=" + n);
			}
		}
		else {            
			MSCRec lcs_rec;
			String str1, str2;
			for (int n=2; n < 100000000; n+=2) { 
				lcs_rec = new MSCRec();
				str1 = lcs_rec.genSecuenciaAleatoria(n);
				str2 = lcs_rec.genSecuenciaAleatoria(n);
				
				t1 = System.currentTimeMillis();
				
				for(int rep = 0; rep < nTimes; rep++) {
					lcs_rec.encontrarMSC(str1, str2);
				}
				
				//lcs_rec.encontrarMSC(str1, str2);
			    t2 = System.currentTimeMillis();
			    //total= (float) (t2 - t1);

			    long tMedio = t2 - t1;
			    //System.out.println("Tiempo [ms]= " + total/nTimes + ", n=" + n);
			    System.out.println(n + "\t" + tMedio);
			}
		}
		
	}

}
