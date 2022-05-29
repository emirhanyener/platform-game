package game;

import java.awt.Color;

public class Object{
	public Position position;
	public Dimension dimension;
	public Color color;
	
	public Object(Position position, Dimension dimension, Color color) {
		this.position = position;
		this.dimension = dimension;
		this.color = color;
	}
	public Object() {
		this.position = new Position();
		this.dimension = new Dimension();
		this.color = Setting.DEFAULT_COLOR;
	}

	public Dimension getDimension() {
		return dimension;
	}
	public Position getPosition() {
		return position;
	}
	public Color getColor() {
		return color;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
