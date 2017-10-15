package frequenzverteilung;

import java.util.ArrayList;

public class DistributeFreq {

	// Create poiter to sender Array
	ArrayList<Sender> senderArr = Frequenzverteilung.senderArr;

	// Method to distribute frequency one
	public void freq1() {
		int minOverlap = 0;
		int currentOverlap;
		int nBest = 0;
		int i;

		// Iterate trough sender Array
		for (i = 0; i < senderArr.size(); i++) {
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

		for (int o = 0; o < overlappingSenders.size(); o++) {
			int overlappingSender = overlappingSenders.get(o);
			if (!senderArr.get(overlappingSender).getBlockedFreq().contains(1)) {
				senderArr.get(overlappingSender).setBlockedFreq(1);
			}
		}
	}

}
