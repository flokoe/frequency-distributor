package frequenzverteilung;

// Import all needed packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Frequenzverteilung {

	// Public variable which holds the absolute path to the file
	// Maybe add read file from command arguments
	public static String filename = "/home/jupiter/workspace/Frequenzverteilung/SenderList";

	// method which returns the number of line of the file
	public static int getLineNumber() {

		int linenumber = 0;

		// Read file
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(
				filename))) {

			// For each line increase var linenumber
			while (lnr.readLine() != null) {
				linenumber++;
			}

		// cCtch exceptions
		} catch (IOException e) {
			e.printStackTrace();
		}

		return linenumber;

	}

	// Main method
	public static void main(String[] args) {

		// Initialize variables
		String senderName;
		int senderNumber = 1;
		String delimiter = " ";
		String currentLine = "";
		int lnr = getLineNumber();
		// Initialize two dimensional string array
		String[][] senderData = new String[lnr][3];

		// Create Buffer
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			int nr = 0;
			// If line found append data to array
			// get line by line
			while ((currentLine = br.readLine()) != null) {

				// Get current line split it to array
				// For length of currentLine array get each element and put it in sender Data array
				for (int h = 0; h < currentLine.split(delimiter).length; h++) {
					senderData[nr][h] = currentLine.split(delimiter)[h];
				}
				nr++;

			}

			// Just print array data
			for (int i = 0; i < senderData.length; i++) {
				for (int k = 0; k < senderData[i].length; k++) {
					System.out.println(" " + senderData[i][k]);
				}
				System.out.println("");
			}
			
		// catch exception
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
