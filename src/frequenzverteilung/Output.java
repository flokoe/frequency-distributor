package frequenzverteilung;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Output {

	public void stdout() {
		ArrayList<Sender> senderArr = Input.senderArr;
		// create Format to display number with 3 digits after comma
		DecimalFormat myFormatter = new DecimalFormat("###.000");

		System.out.println("**");
		System.out.println(" " + "Senderpositionen (X,Y) und Senderadien:");

		// Print senders: Name, X ccord, Y coord, radius
		for (int i = 0; i < senderArr.size(); i++) {
			String space1 = " ";
			String space2 = " ";

			// format numbers
			String posX = myFormatter.format(senderArr.get(i).getPosX());
			String posY = myFormatter.format(senderArr.get(i).getPosY());
			String radius = myFormatter.format(senderArr.get(i).getRadius());

			// If number is not long enough add space to maintain grid
			if (String.valueOf(posX).length() == 6) {
				space1 = "  ";
			}
			if (String.valueOf(posY).length() == 6) {
				space2 = "  ";
			}

			System.out.println(" " + senderArr.get(i).getName() + ":" + space1
					+ posX + "," + space2 + posY + ", " + radius);
		}

		System.out.println("");
		System.out.println(" " + "Frequenzzuordnung:");

		// Print Sender Name and frequency
		for (int k = 0; k < senderArr.size(); k++) {
			System.out.println(" " + senderArr.get(k).getName() + "->"
					+ senderArr.get(k).getFreq());
		}

		System.out.println("");
		System.out.println(" " + "Anzahl benötigter Frequenzen: ");
		System.out.println(" " + "Frequenz | Sender");
		System.out
				.println(" "
						+ "====================================================================");

		String sender = "";
		int freq;

		// Display table with frequencies and the sender names belonging to them
		for (int f = 1; f < 5; f++) {
			sender = "";
			freq = f;

			for (int s = 0; s < senderArr.size(); s++) {
				if (senderArr.get(s).getFreq() == f) {
					sender += senderArr.get(s).getName() + "   ";
				}
			}

			System.out.println("    " + freq + "     |  " + sender);
		}

		System.out.println("\n");

	}

}
