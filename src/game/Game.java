package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	private LinkedList<Object> objects = new LinkedList<Object>();
	private Player player;
	
	public Game() {
		setTitle("Platform Game");
		setBounds(Setting.WINDOW_POSITION_X, Setting.WINDOW_POSITION_Y, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		player = new Player(new Position(50, 300), new Dimension(30, 30));
		player.setColor(new Color(0, 100, 200));
		player.moveSpeed.setSpeed(6);
		player.jumpSpeed.setSpeed(4.5f);
		objects.add(new Object(new Position(0, 500), new Dimension(Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT), new Color(0, 255, 0)));
		objects.add(new Object(new Position(300, 450), new Dimension(100, 50), new Color(100, 40, 0)));
		addKeyListener(new PlayerControl(this.player));
		show();
		
		Thread th1 = new Thread(this);
		Physics p1 = new Physics(this.objects, this.player);
		th1.start();
	}
	
	public void render() {
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		g.setColor(Setting.BACKGROUND_COLOR);
		g.fillRect(0, 0, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		g.setColor(player.getColor());
		g.fillOval((int)player.getPosition().getX(), (int)player.getPosition().getY(), player.getDimension().getWidth(), player.getDimension().getHeight());
		for(Object item : objects) {
			g.setColor(item.getColor());
			g.fillRect((int)item.getPosition().getX(), (int)item.getPosition().getY(), item.getDimension().getWidth(), item.getDimension().getHeight());
		}
	}

	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void run() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(Setting.REFRESH_RATE);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}
}
