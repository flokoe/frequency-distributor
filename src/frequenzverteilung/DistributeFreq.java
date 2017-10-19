package frequenzverteilung;

import java.util.ArrayList;
import java.util.Collections;

public class DistributeFreq {

	public static boolean go = true;

	// Create poiter to sender Array
	ArrayList<Sender> senderArr = Input.senderArr;

	// Method to distribute frequency one
	public void freq1() {
		int minOverlap = 0;
		int currentOverlap;
		int nBest = 0;

		// Iterate trough sender Array
		for (int i = 0; i < senderArr.size(); i++) {
			if (senderArr.get(i).getFreq() != 1
					&& senderArr.get(i).getBlockedFreq().isEmpty()) {
				// Get number of overlaps of current obj
				currentOverlap = senderArr.get(i).getOverlap();
				if (currentOverlap > minOverlap) {
					// set current overlap as minOverlap
					minOverlap = currentOverlap;
					// Set current obj as best
					nBest = i;

					// if obj have the same overlap count check x position to
					// distinguish
				} else if (currentOverlap == minOverlap) {
					double nBestPosX = senderArr.get(nBest).getPosX();
					double currentPosX = senderArr.get(i).getPosX();

					if (currentPosX < nBestPosX) {
						nBest = i;

						// if same x coordinate test fro y coord
					} else if (currentPosX == nBestPosX) {
						double nBestPosY = senderArr.get(nBest).getPosY();
						double currentPosY = senderArr.get(i).getPosY();

						if (currentPosY < nBestPosY) {
							nBest = i;

						} else if (currentPosY == nBestPosY) {
							System.out.println("blub");
						}
					}
				}
			}
		}

		// System.out.println("Best: " + senderArr.get(nBest).getName());
		// Set freq 1 bc of best choice
		senderArr.get(nBest).setFreq(1);

		// block this frequency to all overlapping senders
		ArrayList<Integer> overlappingSenders = senderArr.get(nBest)
				.getOverlappingSenders();

		// for(int a = 0; a < overlappingSenders.size(); a++) {
		// System.out.println(overlappingSenders.get(a));
		// }

		for (int o = 0; o < overlappingSenders.size(); o++) {
			int overlappingSender = overlappingSenders.get(o);
			if (!senderArr.get(overlappingSender).getBlockedFreq().contains(1)) {
				senderArr.get(overlappingSender).setBlockedFreq(1);
			}
		}
	}

	// Distribute all other frequencies
	public void otherFrequencies() {
		int minFreqCount = -1;
		int currentFreqCount;
		int nBest2 = 0;

		// get the best (best is who has the most blocked freq, has smallest x
		// and y coord)
		for (int i = 0; i < senderArr.size(); i++) {
			// Ignore alle senders which already have a frequency
			if (senderArr.get(i).getFreq() == -1) {
				currentFreqCount = senderArr.get(i).getBlockedFreq().size();

				if (currentFreqCount > minFreqCount) {
					minFreqCount = currentFreqCount;
					nBest2 = i;
				} else if (currentFreqCount == minFreqCount) {
					double nBest2PosX = senderArr.get(nBest2).getPosX();
					double currentPosX = senderArr.get(i).getPosX();

					if (currentPosX < nBest2PosX) {
						nBest2 = i;
					} else if (currentFreqCount == nBest2PosX) {
						double nBest2PosY = senderArr.get(nBest2).getPosY();
						double currentPosY = senderArr.get(i).getPosY();

						if (currentPosY < nBest2PosY) {
							nBest2 = i;
						} else if (currentPosY == nBest2PosY) {
							System.out.println("blub2");
						}
					}
				}
			}
		}

		// Mby add ignore last 2 runs

		// set freq
		ArrayList<Integer> bf = senderArr.get(nBest2).getBlockedFreq();
		int lowestFreq = Collections.min(bf);
		int freq = -1;

		// Decide what frequency to use
		if (lowestFreq == 1) {
			if (bf.contains(2)) {
				if (bf.contains(3)) {
					freq = 4;
				} else {
					freq = 3;
				}
			} else {
				freq = 2;
			}
		} else if (lowestFreq == 2) {
			if (bf.contains(1)) {
				System.out.println("low is 2");
			} else {
				freq = 1;
			}
		} else if (lowestFreq == 3) {
			if (bf.contains(1)) {
				if (bf.contains(2)) {
					freq = 4;
				} else {
					freq = 2;
				}
			} else {
				freq = 1;
			}
		} else {
			System.out.println("Daaiiiim");
		}

		// Set frequency
		senderArr.get(nBest2).setFreq(freq);

		// get all overlapping senders
		ArrayList<Integer> overlappingSenders = senderArr.get(nBest2)
				.getOverlappingSenders();

		// blocke the chosen frequency and block it by all overlapping senders
		for (int k = 0; k < overlappingSenders.size(); k++) {
			int overlappingSender = overlappingSenders.get(k);

			// prevent that the frequencies exit twice in array
			if (!senderArr.get(overlappingSender).getBlockedFreq()
					.contains(freq)) {
				senderArr.get(overlappingSender).setBlockedFreq(freq);
			}
		}

	}

}
