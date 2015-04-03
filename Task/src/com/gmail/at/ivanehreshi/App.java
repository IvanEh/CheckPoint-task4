package com.gmail.at.ivanehreshi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Scanner;

public class App {
	private static String outputFilePath = "output.txt"; 
	private static String inputFilePath = null;
	
	
	// TODO: break down into methods
	public static void main(String[] args) {
		int mode = -1; 
		Scanner scanner =  new Scanner(System.in);
		
		if(args.length >= 1)
			mode = Integer.parseInt(args[0]);
		
		if(args.length >= 2)
			inputFilePath = args[1];
		
		if(args.length >= 3)
			outputFilePath = args[2];
			
		if(mode == -1){
			System.out.println("Select mode (1 - console, 2 - file)");
			System.out.println("Or restart with command line arguments(app <mode> <input> <output>)");
			mode = scanner.nextInt();
			if(mode < 1 || mode > 2)
				mode = 2;
		}
		
		PrintStream writer = null;
		Scanner reader = null;
		
		if(mode == 1){
			writer = new PrintStream(System.out);
			reader = new Scanner(System.in);
			
			writer.println("Use ctrl + Z(in eclipse, windows) or ctrl + D(linux) to terminate input");
		}else{
			if(inputFilePath == null
					|| Files.notExists(FileSystems.getDefault().getPath(inputFilePath))){
				System.out.print("Input file: ");
				inputFilePath = scanner.next(); 
				System.out.println("Output file: " + outputFilePath);
				
				try {
					writer = new PrintStream(outputFilePath);
					reader = new Scanner(new FileReader(inputFilePath));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		while(reader.hasNext()){
			String phone = reader.nextLine();
			writer.print(phone + " ");
			if(PhoneNumber.checkValidity(phone)){
				writer.println("is valid");
			}else{
				writer.println("is not valid");
			}
		}
		
		
		scanner.close();
	}
}
