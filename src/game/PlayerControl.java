package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class PlayerControl implements KeyListener{
	private LinkedList<Player> players;
	
	public PlayerControl(LinkedList<Player> players) {
		this.players = players;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for(Player item : players)
				item.velocity.setX(item.moveSpeed.getSpeed());
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			for(Player item : players)
				item.velocity.setX(-item.moveSpeed.getSpeed());
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			for(Player item : players)
				item.jump = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for(Player item : players)
				item.velocity.setX(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			for(Player item : players)
				item.velocity.setX(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
