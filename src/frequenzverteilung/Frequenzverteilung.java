package frequenzverteilung;

import java.util.ArrayList;

public class Frequenzverteilung {

	// Main method
	public static void main(String[] args) {

		// Version:
		String version = "0.2";

		// get sender array
		ArrayList<Sender> senderArr = Input.senderArr;

		// create classes
		Input input = new Input();
		PrepareSender preparesender = new PrepareSender();
		DistributeFreq distributefreq = new DistributeFreq();
		Output outputstd = new Output();

		// Init variables for double dash check
		boolean doubleDashes = false;
		int firstDoubleDash = 0;

		// check if doubleDashes exist in arguments array
		for (int k = 0; k < args.length; k++) {
			char firstChar = args[k].charAt(0);
			char secondChar = args[k].charAt(1);

			// Ensure to check first two digits to ignore dashes in commands
			if (firstChar == '-' && secondChar == '-') {
				doubleDashes = true;
				// Get index of fist found double dash
				firstDoubleDash = k;
				// If found exit for loop
				k = args.length;
			}
		}

		// Handel arguments
		// If no arguments exec default behavior
		if (args.length == 0) {
			// Read file and create sender
			input.create();

			// prepare sender
			preparesender.calcOverlap();
			preparesender.overlappingSenders();

			// distribute freq1
			for (int g = 0; g < senderArr.size(); g++) {
				if (senderArr.get(g).getFreq() != 1
						&& senderArr.get(g).getBlockedFreq().isEmpty()) {
					distributefreq.freq1();
				}
			}

			// distribute other frequencies
			for (int h = 0; h < senderArr.size(); h++) {
				distributefreq.otherFrequencies();
			}

			// print stdout
			outputstd.stdout();

			// If double dashes found check them
		} else if (doubleDashes) {
			// Check only first double dash
			switch (args[firstDoubleDash]) {
			case "--help":
				System.out.println("Usage: frequenzverteilung.jar [OPTION]...");
				System.out
						.println("Reads sender file (from current directory by default),");
				System.out
						.println("distributes frequencies to senders while using as few as possible");
				System.out.println("and print is to standard output.");
				System.out.println("");
				System.out.println("Available options:");
				System.out.println("  " + "-i            does not work yet");
				System.out.println("  " + "-f            does not work yet");
				System.out.println("  " + "-o            does not work yet");
				System.out.println("  " + "-s            does not work yet");
				System.out.println("  "
						+ "--help        display this help and exit");
				System.out
						.println("  " + "--version     show version and exit");

				break;

			case "--version":
				System.out.println("frequenzverteilung: " + version);
				System.out.println("License: MIT <https://mit-license.org/>.");
				System.out.println("");
				System.out.println("Written by Florian Köhler.");

				break;

			default:
				System.out.println("Invalid option: '" + args[firstDoubleDash]
						+ "'");
				System.out
						.println("Try 'frequenzverteilung.jar --help' for more information.");

				break;
			}

			// If arguments exist but no double dash check normal options
		} else {
			// If args exist:

			// For each argument
			char firstChar;
			for (int i = 0; i < args.length; i++) {
				firstChar = args[i].charAt(0);

				// only check options and ignore arguments for options
				if (firstChar == '-') {
					switch (args[i]) {
					case "-i":

						break;

					case "-f":

						break;

					case "-o":

						break;

					case "-s":

						break;

					default:
						System.out.println("Invalid option: '" + args[i] + "'");
						System.out
								.println("Try 'frequenzverteilung.jar --help' for more information.");

						break;
					}

					// not sure if necessary
				} else if (args[0].charAt(0) != '-') {
					System.out.println("Invalid option: '" + args[i] + "'");
					System.out
							.println("Try 'frequenzverteilung.jar --help' for more information.");

					// If non option argument found check if it's argument for
					// option
				} else if (args[(i - 1)].charAt(0) != '-') {
					System.out.println("Invalid option: '" + args[i] + "'");
					System.out
							.println("Try 'frequenzverteilung.jar --help' for more information.");
				}
			}
		}

	}
}
