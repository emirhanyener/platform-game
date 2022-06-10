package game;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Timer;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	private LinkedList<Object> objects;
	private LinkedList<Player> players;
	private Camera camera;
	private int FPSCounter;
	private int FPS;
	private int lastTime;
	
	public Canvas(LinkedList<Object> objects, LinkedList<Player> players, Camera camera) {
		this.objects = objects;
		this.players = players;
		this.camera = camera;
		this.FPS = 0;
		this.lastTime = 0;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Setting.BACKGROUND_COLOR);
		g.fillRect(0, 0, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		for(Player item : players) {
			g.setColor(item.getColor());
			g.fillOval((int)item.position.getX() - (int)camera.getPosition().getX(), (int)item.position.getY() - (int)camera.getPosition().getY(), item.dimension.getWidth(), item.dimension.getHeight());
		}
		for(Object item : objects) {
			g.setColor(item.getColor());
			g.fillRect((int)item.position.getX() - (int)camera.getPosition().getX(), (int)item.position.getY() - (int)camera.getPosition().getY(), item.dimension.getWidth(), item.dimension.getHeight());
		}
		int i = 0;
		for(String alert : Alert.getInstance().getAlerts()) {
			i++;
			g.setColor(Color.RED);
			g.drawString(alert, 10, i * 15);
		}
		if(Setting.IS_FPS_ACTIVE) {
			if(LocalDateTime.now().getSecond() != lastTime) {
				FPS = FPSCounter;
				FPSCounter = 0;
				lastTime = LocalDateTime.now().getSecond();
			}
			FPSCounter++;
			g.setColor(Color.BLACK);
			g.drawString("FPS: " + FPS, Setting.WINDOW_WIDTH - 55, 15);
		}
	}
}
