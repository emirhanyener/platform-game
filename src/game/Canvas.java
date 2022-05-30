package game;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	private LinkedList<Object> objects;
	private Player player;
	
	public Canvas(LinkedList<Object> objects, Player player) {
		this.objects = objects;
		this.player = player;
	}
	
	@Override
	public void paint(Graphics g) {				
		g.setColor(Setting.BACKGROUND_COLOR);
		g.fillRect(0, 0, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		g.setColor(player.getColor());
		g.fillOval((int)player.getPosition().getX(), (int)player.getPosition().getY(), player.getDimension().getWidth(), player.getDimension().getHeight());
		for(Object item : objects) {
			g.setColor(item.getColor());
			g.fillRect((int)item.getPosition().getX(), (int)item.getPosition().getY(), item.getDimension().getWidth(), item.getDimension().getHeight());
		}
	}
}
