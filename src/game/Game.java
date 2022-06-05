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
	private LinkedList<Player> players = new LinkedList<Player>();
	private Canvas canvas;
	
	public Game() {
		setTitle("Platform Game");
		setBounds(Setting.WINDOW_POSITION_X, Setting.WINDOW_POSITION_Y, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		addMouseListener(MousePosition.getInstance());

		Player player1 = new Player(new Position(50, 300), new Dimension(30, 30));
		player1.setColor(new Color(0, 100, 200));
		player1.moveSpeed.setSpeed(6);
		player1.jumpSpeed.setSpeed(16f);
		players.add(player1);

		objects.add(new Object(new Position(0, 500), new Dimension(Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT), new Color(0, 255, 0)));
		objects.add(new Object(new Position(300, 450), new Dimension(100, 50), new Color(100, 40, 0)));
		objects.add(new Object(new Position(500, 390), new Dimension(100, 50), new Color(120, 35, 0)));
		objects.add(new Object(new Position(0, 290), new Dimension(450, 10), new Color(140, 30, 0)));
		objects.add(new Object(new Position(0, 190), new Dimension(50, 5), new Color(160, 25, 0)));
		objects.add(new Object(new Position(0, 90), new Dimension(800, 5), new Color(180, 20, 0)));
		objects.add(new Object(new Position(900, 300), new Dimension(50, 15), new Color(200, 15, 0)));
		Object object = new Object(new Position(700, 450), new Dimension(100, 50), new Color(0, 200, 10), true);
		object.SetTriggerEvent(new TriggerEvent() {
			@Override
			public void OnTriggered() {
				object.setColor(Color.ORANGE);
			}
		});
		objects.add(object);
		
		canvas = new Canvas(objects, players, new DynamicCamera(player1, new Position(0, -100)));
		add(canvas, BorderLayout.CENTER);
		
		addKeyListener(new PlayerControl(players));
		show();
		
		Thread th1 = new Thread(this);
		new Physics(this.objects, player1);
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
