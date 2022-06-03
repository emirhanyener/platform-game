package game;

public class Position {
	private float X;
	private float Y;
	
	public Position() {
		resetPosition();
	}
	
	public Position(float X, float Y) {
		this.X = X;
		this.Y = Y;
	}

	public static Position add(Position pos1, Position pos2) {
		return new Position(pos1.getX() + pos2.getX(), pos1.getY() + pos2.getY());
	}
	
	public static Position diff(Position pos1, Position pos2) {
		return new Position(pos1.getX() - pos2.getX(), pos1.getY() - pos2.getY());
	}
	
	public float getX() {
		return this.X;
	}
	public float getY() {
		return this.Y;
	}
	
	public void setX(float X) {
		this.X = X;
	}
	public void addX(float X) {
		this.X += X;
	}
	public void setY(float Y) {
		this.Y = Y;
	}
	public void addY(float Y) {
		this.Y += Y;
	}
	
	public void resetPosition() {
		this.X = 0;
		this.Y = 0;
	}
}
