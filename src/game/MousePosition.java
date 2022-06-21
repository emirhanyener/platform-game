package game;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import util.Alert;
import util.Camera;
import util.Dimension;
import util.Position;
import util.Object;;

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
		//---teleport---
		//GameObjects.getInstance().getPlayers().get(0).position = new Position(this.position.getX(), this.position.getY());
		//---dynamic create object---
		GameObjects.getInstance().addObject(new Object("Block",new Position(this.position.getX(), this.position.getY()), new Dimension(50,50), Color.ORANGE));
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