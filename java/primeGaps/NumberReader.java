/**
* NumberReader.java
*/

import java.io.*;
import java.util.Scanner;

public class NumberReader{
	
	public static void main(String[] argvs){


		Scanner scan0;
		Scanner scan1;
		int a = 0;
		int b = 0;
		int c = 0;

		try{

			File file = new File("primes.txt");
			File outFile = new File("output.txt");
			File outFile2 = new File("detailed.txt");

			if (!outFile.exists()){
				outFile.createNewFile();
			}

			if (!outFile2.exists()){
				outFile2.createNewFile();
			}

			FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
			FileWriter fw2 = new FileWriter(outFile2.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			StringBuilder str = new StringBuilder();
			StringBuilder str2 = new StringBuilder();

			scan0 = new Scanner(file);
			scan1 = new Scanner(scan0.nextLine());
			a = scan1.nextInt();
			b = scan1.nextInt();
			c = b - a;
			str.append(c + "\n");
			str2.append(b + " - " + a + " = " + c + "\n");

			while (scan0.hasNextLine()){

				while(scan1.hasNextInt()){
					a = b;
					b = scan1.nextInt();
					c = b - a;
					str.append(c + "\n");
					str2.append(b + " - " + a + " = " + c + "\n");
				}

				scan1 = new Scanner(scan0.nextLine());
			}

			//-------------------------------------
			//write the entire string of numbers 
			//into the output file
			//--------------------------------------
			bw.write("" + str);
			bw2.write("" + str2);
			System.out.println("" + str);

			scan0.close();
			scan1.close();
			bw.close();
			bw2.close();

		} catch (IOException e){
			e.printStackTrace();
		} 
	}
}