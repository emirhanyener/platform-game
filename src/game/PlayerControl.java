package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener{
	public Player player;
	
	public PlayerControl(Player player) {
		this.player = player;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.player.velocity.setX(player.moveSpeed.getSpeed());
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.player.velocity.setX(-player.moveSpeed.getSpeed());
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.player.jump = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.player.velocity.setX(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.player.velocity.setX(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
