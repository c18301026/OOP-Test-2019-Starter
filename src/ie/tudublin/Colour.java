package ie.tudublin;

import processing.data.TableRow;

public class Colour {
	private String colour;
	public int r, g, b, value;

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Colour(String colour, int r, int g, int b, int value) {
		this.colour = colour;
		this.r = r;
		this.g = g;
		this.b = b;
		this.value = value;
	}

	public Colour() {
		this("black", 0, 0, 0, 0);
	}

	public Colour(TableRow tr) {
		this(
			tr.getString("colour"),
			tr.getInt("r"),
			tr.getInt("g"),
			tr.getInt("b"),
			tr.getInt("value")
		);
	}

	public String toString() {
		return colour + "\t" + r + "\t" + g + "\t" + b + "\t" + value;
	}
}