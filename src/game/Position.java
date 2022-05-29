package game;

public class Position {
	private float X;
	private float Y;
	
	public Position() {
		this.X = 0;
		this.Y = 0;
	}
	
	public Position(int X, int Y) {
		this.X = X;
		this.Y = Y;
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
	public void setY(float Y) {
		this.Y = Y;
	}
}
