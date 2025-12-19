package hr.unizg.fer.dismat1.lab02;

import java.io.File;
import java.util.Scanner;

public class BrojPodgrafovaCiklusa {

	public static void main(String[] args) {
				
		Scanner fileNameScanner = new Scanner(System.in);
		String fileName = fileNameScanner.nextLine();
		fileNameScanner.close();
		
		String filePath = System.getProperty("user.dir")  + "\\" + fileName;
		
		int n = 0;
		int[][] matrica = null;
		
		try (Scanner sc = new Scanner(new File(filePath))) {

			n = sc.nextInt();
			sc.nextLine();											// preskoci \n
			matrica = new int[n][n];
			
			for (int i = 0; i < n; ++i) {
				String red = sc.nextLine();
				for (int j = 0; j < n; ++j) {
					matrica[i][j] = red.charAt(j) - '0';
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(-1);
		}
		
		int brojPodgrafova = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; ++j) {
				for (int k = j + 1; k < n; ++k) {
					if (matrica[i][j] == 1 && matrica[j][k] == 1 && matrica[k][i] == 1) {
						++brojPodgrafova;
					}
				}
			}
		}
		
		System.out.println("Rjesenje: " + brojPodgrafova);
		
	}

}
