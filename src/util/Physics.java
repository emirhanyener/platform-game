package util;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import game.Setting;

public class Physics extends Thread implements Runnable{
	private LinkedList<Object> objects;
	private Character character;
	private boolean isMovable = true;
	
	public Physics(LinkedList<Object> objects, Character character) {
		this.objects = objects;
		this.character = character;
		this.start();
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
			for(Object item : objects) {
				if(character.position.getX() + character.dimension.getWidth() > item.position.getX() && character.position.getX() < item.position.getX() + item.dimension.getWidth() && character.position.getY() + character.velocity.getY() + character.dimension.getHeight() > item.position.getY() && character.position.getY() + character.velocity.getY() < item.position.getY() + item.dimension.getHeight())
				{	
					if(!item.isAbstract()) {
						if(character.position.getY() + character.velocity.getY() < item.position.getY() && !character.down) {
							character.position.setY(item.position.getY() - character.dimension.getHeight());
						}
						character.velocity.setY(0);
						if(character.jump) {
							character.velocity.setY(-character.jumpSpeed.getSpeed());
						}
					}
				}
				else {
					character.velocity.setY(character.velocity.getY() + Setting.GRAVITY);
					character.position.setY(character.position.getY() + character.velocity.getY() / 15);
				}
				
				if(character.position.getY() + character.dimension.getHeight() - 1 > item.position.getY())
					if(character.position.getY() < item.position.getY() + item.dimension.getHeight()) {
						if(Math.abs((character.position.getX() + character.dimension.getWidth() + character.velocity.getX()) - item.position.getX()) < character.moveSpeed.getSpeed()) {
							character.position.setX(item.position.getX() - character.dimension.getWidth());
						}
						if(Math.abs((character.position.getX() + character.velocity.getX() - (item.position.getX() + item.dimension.getWidth()))) < character.moveSpeed.getSpeed()) {
							character.position.setX(item.position.getX() + item.dimension.getWidth());
						}
						
						if(character.position.getX() + character.dimension.getWidth() + character.velocity.getX() > item.position.getX()) {
							if(character.position.getX() + character.velocity.getX() < item.position.getX() + item.dimension.getWidth()) {
								if(item.isAbstract()) {	
									item.Triggered(character);
									continue;
								}
								else
									isMovable = false;
							}
						}
					}
			}
			
			if(isMovable)
				character.position.setX(character.position.getX() + character.velocity.getX());
			isMovable = true;

			Alert.getInstance().setAlertRow(0, "Position: x = " + this.character.position.getX() + ", y = " + this.character.position.getY());
			Alert.getInstance().setAlertRow(1, "Velocity: x = " + this.character.velocity.getX() + ", y = " + this.character.velocity.getY());
		}
	}
}