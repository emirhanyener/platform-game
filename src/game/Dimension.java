package game;

public class Dimension {
	private int width;
	private int height;
	
	public Dimension(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public Dimension() {
		this.width = 0;
		this.height = 0;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}
