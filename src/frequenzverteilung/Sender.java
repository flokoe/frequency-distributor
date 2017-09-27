package frequenzverteilung;

public class Sender {
	
	// Declare attributes
	private String name;
	private int number;
	private int posX;
	private int posY;
	private int radius;

	// Create constructor
	public Sender(String name, int number, int posX, int posY, int radius) {
		this.name = name;
		this.number = number;
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
