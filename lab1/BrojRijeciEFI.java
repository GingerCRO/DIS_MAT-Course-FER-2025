package hr.unizg.fer.dismat1.lab01;

import java.util.Scanner;

public class BrojRijeciEFI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		
		int a, b, c, d, e, L; 
		a = sc.nextInt(); 
		b = sc.nextInt(); 
		c = sc.nextInt(); 
		d = sc.nextInt(); 
		e = sc.nextInt(); 
		L = sc.nextInt(); 
		
		sc.close(); 
		
		double[] aKoef = popuniKoef(a, L); 
		double[] bKoef = popuniKoef(b, L);
		double[] cKoef = popuniKoef(c, L); 
		double[] dKoef = popuniKoef(d, L); 
		double[] eKoef = popuniKoef(e, L); 
		
		double[] koeficijenti = new double[] {1.0}; 
		koeficijenti = pomnoziKoef(koeficijenti, aKoef, L); 
		koeficijenti = pomnoziKoef(koeficijenti, bKoef, L); 
		koeficijenti = pomnoziKoef(koeficijenti, cKoef, L); 
		koeficijenti = pomnoziKoef(koeficijenti, dKoef, L); 
		koeficijenti = pomnoziKoef(koeficijenti, eKoef, L); 
		
		double rezultat = fakt(L) * koeficijenti[L]; 
		System.out.println(Math.round(rezultat));
		
	}
	
	private static double fakt(int num) { 
		
		double f = 1.0;
		
		for (int i = 2; i <= num; ++i) { 
			f *= i; 
		} 
		
		return f;
		
	}
	
	private static double[] popuniKoef(int max, int L) { 
		
		double[] polje = new double[L + 1];
		
		for (int i = 0; i <= max && i <= L; ++i) { 
			polje[i] = 1.0 / fakt(i);
		} 
		
		return polje;
		
	}
	
	private static double[] pomnoziKoef(double[] koef1, double[] koef2, int L) { 
		
		int len1 = koef1.length, len2 = koef2.length; 
		double[] rez = new double[L + 1]; 
		
		for (int i = 0; i < len1; ++i) { 
			for (int j = 0; j < len2; ++j) { 
				int koef = i + j; 
				if (koef <= L) { 
					rez[koef] += koef1[i] * koef2[j]; 
				} 
			} 
		} 
		
		return rez; 
		
	}

}
