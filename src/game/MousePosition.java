package game;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePosition implements MouseListener{
	private static Position position = null;
	private static MousePosition mousePosition = null;
	private static Camera camera = null;
	
	private MousePosition() {
		this.position = new Position();
	}
	
	public static MousePosition getInstance() {
		if(mousePosition == null) {
			synchronized (MousePosition.class) {
				if(mousePosition == null) {
					mousePosition = new MousePosition();
				}
			}
		}
		
		return mousePosition;
	}
	
	public void setCamera(Camera _camera) {
		camera = _camera;
	}
	
	public Position getPosition() {
		return position;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.position.setX(camera.getRawPosition().getX() + e.getX());
		this.position.setY(camera.getRawPosition().getY() + e.getY());
		Alert.getInstance().setAlertRow(2, "Mouse Position: x = " + this.position.getX() + ", y = " + this.position.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}