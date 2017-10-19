package frequenzverteilung;

import java.util.ArrayList;

public class Frequenzverteilung {

	// Main method
	public static void main(String[] args) {

		//get sender array
		ArrayList<Sender> senderArr = Input.senderArr;
		
		// Read file and create sender
		Input input = new Input();
		input.create();

		// prepare sender
		PepareSender preparesender = new PepareSender();
		preparesender.calcOverlap();
		preparesender.overlappingSenders();

		DistributeFreq distributefreq = new DistributeFreq();

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
		Output outputstd = new Output();
		outputstd.stdout();

	}
}
