package prob1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import prob2.*;

public class MartianManagerIO {

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static void writeMartians(String fileName, MartianManager mm) {
		File file = new File(fileName);
        try {
			writeMartiansFile(file, mm);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error writing file");
			e.printStackTrace();
		}
	}
	
	/**
	 *  YOU  WRITE THIS METHOD.
	 *  
	 *  Write the martians in the MartianManager to the file. The format is exactly the same
	 *  as specified in the homework document for reading valid data: G I V or R I V T.
	 */
	private static void writeMartiansFile(File file, MartianManager mm) throws FileNotFoundException {
		try {
			PrintWriter writer = new PrintWriter(file);
			for(int i = 0; i < mm.getNumMartians(); i++) {
				if(mm.getMartianAt(i) instanceof GreenMartian) {
					GreenMartian g = ((GreenMartian)mm.getMartianAt(i));
					String msg = String.format("G %d %d", g.getId(), g.getVolume());
					writer.println(msg);
				}
				else {
					RedMartian r = ((RedMartian)mm.getMartianAt(i));
					String msg = String.format("R %d %d %d", r.getId(), r.getVolume(), r.getTenacity());
					writer.println(msg);
				}
			}
			writer.close();
			System.out.println("File written.");
		}
		catch (IOException ioe) {
			System.out.println("Problem creating file or writing");
		}
	}

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static ReadReport readMartians(String fileName) {
		File file = new File(fileName);
		ReadReport report = null;
        try {
			report = readMartiansFile(file);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return report;
	}
	
	/**
	 * YOU WRITE THIS METHOD.
	 * 
	 * Reads a text file that contains Martian data and returns a ReadReport object. Details
	 * are in the homework document. 
	 * 
	 * @param file
	 * @return
	 * @throws RuntimeException
	 * @throws FileNotFoundException
	 */
	private static ReadReport readMartiansFile(File file) throws RuntimeException, FileNotFoundException {
		MartianManager mm = new MartianManager();
		String fileName = file.getName();
		int numLinesRead = 0;
		int numSuccessfullyAdded = 0;
		int numAlreadyExist = 0;
		int numIllInformed = 0;
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				numLinesRead++;
				String line = scan.nextLine();
				String[] tokens = line.split("\\s");
					if(tokens.length < 5) {
						if(tokens[0].equals("R") && tokens.length == 4) {
							String token1 = tokens[1];
							String token2 = tokens[2];
							String token3 = tokens[3];
							
							int id, volume, tenacity;
							
							if(isInteger(token1)) {
								id = Integer.parseInt(token1);
							}
							else {
								id = -1;	
							}
							if(isInteger(token2)) {
								volume = Integer.parseInt(token2);
							}
							else {
								volume = -1;
							}
							if(isInteger(token3)) {
								tenacity = Integer.parseInt(token3);
							}
							else {
								tenacity = -1;
							}
							if(id == -1 || volume == -1 || tenacity == -1) {
								numIllInformed++;
							}
							else {
								RedMartian rm = new RedMartian(id, volume, tenacity);
								boolean addedMartian = mm.addMartian(rm);
								if(addedMartian == true) {
									numSuccessfullyAdded++;
								}
								else {
									numAlreadyExist++;
								}
							}
						}
						else if(tokens[0].equals("G") && tokens.length == 3) {
							String token1 = tokens[1];
							String token2 = tokens[2];
							int id, volume;
							if(isInteger(token1)) {
								id = Integer.parseInt(token1);
							}
							else {
								id = -1;
							}
							if(isInteger(token2)) {
								volume = Integer.parseInt(token2);
							}
							else {
								volume = -1;
							}
							if(id == -1 || volume == -1) {
								numIllInformed++;
							}
							else {
								GreenMartian gm = new GreenMartian(id, volume);
								boolean added = mm.addMartian(gm);
								if(added == true) {
									numSuccessfullyAdded++;
								}
								else {
									numAlreadyExist++;
								}
							}
						}
						else {
							numIllInformed++;
						}
					}
					else {
						numIllInformed++;
					}
				}
			}
			catch(IOException ioe) {
				System.out.println(ioe);
			}
			ReadReport statistics = new ReadReport(mm, fileName, numLinesRead, numSuccessfullyAdded, numAlreadyExist, numIllInformed);
				return statistics;
		}
		public static boolean isInteger(String str) {
			try {
				int x = Integer.parseInt(str);
				return true;
			}
			catch(NumberFormatException nfe) {
				return false;
			}
		}
	}