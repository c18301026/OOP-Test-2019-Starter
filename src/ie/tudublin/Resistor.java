package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Resistor {
	public int value, ones, tens, hundreds;

	public Resistor(int value) {
		this.value = value;
		this.hundreds = (value / 100);
		this.tens = (value - (hundreds * 100)) / 10;
		this.ones = value - ((hundreds * 100)  + (tens * 10));
	}

	public Resistor() {
		this(0);
	}

	public Resistor(TableRow tr) {
		this(tr.getInt(0));
	}

	public String toString() {
		return hundreds + "," + tens + "," + ones;
	}

	public String digit(int dig) {
		if(dig == 0) return " ";
		else return Integer.toString(dig);
	}

	public void render(PApplet pa, int id, int r1, int g1, int b1, int r2, int g2, int b2, int r3, int g3, int b3) {
		float yGap = pa.height * 0.15f;
		float lineLen = pa.width * 0.15f;
		float squareX = (pa.width / 2) - (lineLen / 2);
		float squareY = yGap + (id * yGap);

		pa.noFill();
		pa.stroke(0);
		pa.strokeWeight(1);
		pa.square(squareX, squareY, lineLen);
		pa.line(squareX - lineLen, squareY + (lineLen / 2), squareX, squareY + (lineLen / 2));
		pa.line(squareX + lineLen, squareY + (lineLen / 2), squareX + (2 * lineLen), squareY + (lineLen / 2));

		pa.stroke(r1, g1, b1);
		pa.strokeWeight(2);
		pa.line(squareX + (lineLen * 0.1f), squareY + 1, squareX + (lineLen * 0.1f), (squareY + lineLen) - 1);
		pa.stroke(r2, g2, b2);
		pa.line(squareX + (lineLen * 0.2f), squareY + 1, squareX + (lineLen * 0.2f), (squareY + lineLen) - 1);
		pa.stroke(r3, g3, b3);
		pa.line(squareX + (lineLen * 0.3f), squareY + 1, squareX + (lineLen * 0.3f), (squareY + lineLen) - 1);

		pa.fill(0);
		// pa.text(hundreds + " " + tens + " " + ones, squareX + (2.5f * lineLen), squareY + (lineLen / 2));
		pa.text(digit(hundreds) + " " + digit(tens) + " " + digit(ones), squareX + (2.5f * lineLen), squareY + (lineLen / 2));
	}
}