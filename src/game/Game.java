package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import util.DynamicCamera;
import util.Object;
import util.Physics;
import util.Position;

public class Game extends JFrame implements Runnable{
	private Canvas canvas;
	Physics physics;
	
	public Game() {
		ObjectFactory objectFactory = new ObjectFactory();
		CharacterFactory characterFactory = new CharacterFactory();
		
		setTitle("Platform Game");
		setBounds(Setting.WINDOW_POSITION_X, Setting.WINDOW_POSITION_Y, Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		addMouseListener(MousePosition.getInstance());
		addKeyListener(new PlayerControl(GameObjects.getInstance().getPlayers()));

		LinkedList<Object> objects = new LinkedList<Object>();
		objects.addAll(GameObjects.getInstance().getObjects());
		objects.addAll(GameObjects.getInstance().getPlayers());
		
		physics = new Physics();
		physics.addCharacter(GameObjects.getInstance().getPlayers().get(0));
		
		canvas = new Canvas(objects, new DynamicCamera(GameObjects.getInstance().getPlayers().get(0), new Position(0, -100)));
		add(canvas, BorderLayout.CENTER);
		
		show();
		run();
	}
	
	public void render() {
		LinkedList<Object> objects = new LinkedList<Object>();
		objects.addAll(GameObjects.getInstance().getObjects());
		objects.addAll(GameObjects.getInstance().getPlayers());
		canvas.setObjects(objects);
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
			physics.calculate();
			render();
		}
	}
}