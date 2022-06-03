package game;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	private LinkedList<Object> objects;
	private LinkedList<Player> players;
	private Camera camera;
	
	public Canvas(LinkedList<Object> objects, LinkedList<Player> players, Camera camera) {
		this.objects = objects;
		this.players = players;
		this.camera = camera;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Setting.BACKGROUND_COLOR);
		g.fillRect(0, 0, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		for(Player item : players) {
			g.setColor(item.getColor());
			g.fillOval((int)item.getPosition().getX() - (int)camera.getPosition().getX(), (int)item.getPosition().getY() - (int)camera.getPosition().getY(), item.getDimension().getWidth(), item.getDimension().getHeight());
		}
		for(Object item : objects) {
			g.setColor(item.getColor());
			g.fillRect((int)item.getPosition().getX() - (int)camera.getPosition().getX(), (int)item.getPosition().getY() - (int)camera.getPosition().getY(), item.getDimension().getWidth(), item.getDimension().getHeight());
		}
	}
}
