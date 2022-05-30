package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable{
	private LinkedList<Object> objects = new LinkedList<Object>();
	private Player player;
	Canvas canvas;
	
	public Game() {
		setTitle("Platform Game");
		setBounds(Setting.WINDOW_POSITION_X, Setting.WINDOW_POSITION_Y, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		player = new Player(new Position(50, 300), new Dimension(30, 30));
		player.setColor(new Color(0, 100, 200));
		player.moveSpeed.setSpeed(6);
		player.jumpSpeed.setSpeed(16f);
		objects.add(new Object(new Position(0, 500), new Dimension(Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT), new Color(0, 255, 0)));
		objects.add(new Object(new Position(300, 450), new Dimension(100, 50), new Color(100, 40, 0)));
		objects.add(new Object(new Position(500, 390), new Dimension(100, 50), new Color(120, 35, 0)));
		objects.add(new Object(new Position(0, 290), new Dimension(450, 10), new Color(140, 30, 0)));
		objects.add(new Object(new Position(0, 190), new Dimension(50, 5), new Color(160, 25, 0)));
		objects.add(new Object(new Position(0, 90), new Dimension(800, 5), new Color(180, 20, 0)));
		objects.add(new Object(new Position(900, 300), new Dimension(50, 15), new Color(200, 15, 0)));
		
		canvas = new Canvas(objects, player);
		add(canvas, BorderLayout.CENTER);
		
		addKeyListener(new PlayerControl(this.player));
		show();
		
		Thread th1 = new Thread(this);
		new Physics(this.objects, this.player);
		th1.start();
	}
	
	public void render() {
		canvas.repaint();
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
