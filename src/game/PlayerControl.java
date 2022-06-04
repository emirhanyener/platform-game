package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class PlayerControl implements KeyListener{
	private LinkedList<Player> players;
	private boolean right = false;
	private boolean left = false;
	private boolean jump = false;
	
	public PlayerControl(LinkedList<Player> players) {
		this.players = players;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.jump = true;
		}

		if(this.right) {
			for(Player item : players)
				item.velocity.setX(item.moveSpeed.getSpeed());
		}
		if(this.left) {
			for(Player item : players)
				item.velocity.setX(-item.moveSpeed.getSpeed());
		}
		if(this.jump) {
			for(Player item : players) {
				item.jump = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for(Player item : players)
				item.velocity.setX(0);
			this.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			for(Player item : players)
				item.velocity.setX(0);
			this.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			for(Player item : players)
				item.jump = false;
			this.jump = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
