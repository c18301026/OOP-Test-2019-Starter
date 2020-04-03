package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet

{	
	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings()
	{
		size(320, 500); // originally 500, 800
		
		separate(381);
		separate(1);
		separate(92);
	}

	public void setup() 
	{
		loadColours();
		printColours();
		loadResistors();
		printResistors();
	}
	
	public void draw()
	{
		drawResistors();	
	}

	ArrayList<Colour> colours = new ArrayList<Colour>();
	ArrayList<Resistor> resistors = new ArrayList<Resistor>();

	public void loadColours() {
		Table t = loadTable("colours.csv", "header");

		for(TableRow tr : t.rows()) {
			Colour c = new Colour(tr);
			colours.add(c);
		}
	}

	public void printColours() {
		for(Colour c : colours) {
			System.out.println(c);
		}
	}

	public Colour findColour(int value) {
		for(Colour c : colours) {
			if(c.value == value) return c;
		}

		return colours.get(0);
	}

	public void loadResistors() {
		Table t = loadTable("resistors.csv");

		for(TableRow tr : t.rows()) {
			Resistor r = new Resistor(tr);
			resistors.add(r);
		}
	}

	public void printResistors() { 
		for(Resistor r : resistors) {
			System.out.println(r);
		}
	}

	public void drawResistors() {
		int id = 0;

		for(Resistor r : resistors) {
			Colour c1 = findColour(r.hundreds);
			Colour c2 = findColour(r.tens);
			Colour c3 = findColour(r.ones);

			int r1 = c1.r;
			int g1 = c1.g;
			int b1 = c1.b;
			int r2 = c2.r;
			int g2 = c2.g;
			int b2 = c2.b;
			int r3 = c3.r;
			int g3 = c3.g;
			int b3 = c3.b;

			r.render(this, id, r1, g1, b1, r2, g2, b2, r3, g3, b3);
			id++;
		}
	}
}