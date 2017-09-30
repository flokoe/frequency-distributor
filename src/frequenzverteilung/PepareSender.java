package frequenzverteilung;

// Import needed libs 
import java.util.ArrayList;

public class PepareSender {

	public void calcOverlap() {
		
		ArrayList<Sender> senderArr = Frequenzverteilung.senderArr;

		// init freq array and count
		int[] frequenzen = { 1, 2, 3, 4};
		int count = 0;

		// For each element in senderArr
		for (int i = 0; i < senderArr.size(); i++) {
			// Get radius
			Double r = senderArr.get(i).getRadius();
			// reset counter
			count = 0;

			// For each  element in senderArr
			for (int k = 0; k < senderArr.size(); k++) {
				// Do not add yourself
				if (k != i) {
					// Get radius of second sender
					Double r2 = senderArr.get(k).getRadius();
					Double minDistance = r + r2;
					
					// Calculate distance between center of the circles
					Double realDistance = Math.sqrt(Math.pow(((senderArr.get(i)
							.getPosX()) - (senderArr.get(k).getPosX())), 2)
							+ Math.pow(
									((senderArr.get(i).getPosY()) - (senderArr
											.get(k).getPosY())), 2));

					// Increase counter if real distance is lesser than minDistance (they overlap)
					if (realDistance < minDistance) {
						count++;
					}
				}
			}

			// add overlap count to sender object
			senderArr.get(i).setOverlap(count);

		}

	}

}
