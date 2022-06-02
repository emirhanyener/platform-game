package game;

public class Camera {
	protected Position position;
	
	public Camera(Position position) {
		this.position = position;
	}
	public Camera() {
		this.position = new Position();
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
}