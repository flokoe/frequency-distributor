package frequenzverteilung;

import java.util.ArrayList;

public class Sender {

	// Declare attributes
	private String name;
	private int number;
	private double posX;
	private double posY;
	private double radius;
	private int overlap;
	private int freq = -1;
	private ArrayList<Integer> blockedFreq = new ArrayList<Integer>();
	private ArrayList<Integer> overlappingSenders = new ArrayList<Integer>();

	// Create constructor
	public Sender(String name, int number, double posX, double posY,
			double radius) {
		this.name = name;
		this.number = number;
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
		// this.overlap = count;
	}

	// Create getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setOverlap(int count) {
		this.overlap = count;
	}

	public int getOverlap() {
		return overlap;
	}

	public void setFreq(int i) {
		this.freq = i;
	}

	public int getFreq() {
		return freq;
	}

	public ArrayList<Integer> getBlockedFreq() {
		return blockedFreq;
	}

	public void setBlockedFreq(int blockedFreq) {
		this.blockedFreq.add(blockedFreq);
	}

	public ArrayList<Integer> getOverlappingSenders() {
		return overlappingSenders;
	}

	public void setOverlappingSenders(ArrayList<Integer> overlappingSenders) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		for (int h = 0; h < overlappingSenders.size(); h++) {
			test.add(overlappingSenders.get(h));
		}
		this.overlappingSenders = test;
	}

}
