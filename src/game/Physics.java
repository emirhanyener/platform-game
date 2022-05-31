package game;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

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
				if(character.getPosition().getX() + character.dimension.getWidth() > item.getPosition().getX() && character.getPosition().getX() < item.getPosition().getX() + item.dimension.getWidth() && character.getPosition().getY() + character.velocity.getY() + character.dimension.getHeight() > item.getPosition().getY() && character.getPosition().getY() + character.velocity.getY() < item.getPosition().getY() + item.getDimension().getHeight())
				{	
					if(character.getPosition().getY() + character.velocity.getY() < item.getPosition().getY())
						character.position.setY(item.position.getY() - character.dimension.getHeight());
					character.velocity.setY(0);
					if(character.jump) {
						character.velocity.setY(-character.jumpSpeed.getSpeed());
						character.jump = false;
					}
				}
				else {
					character.velocity.setY(character.velocity.getY() + Setting.GRAVITY);
					character.position.setY(character.position.getY() + character.velocity.getY() / 11);
				}
				
				if(character.getPosition().getY() + character.dimension.getHeight() - 1 > item.position.getY())
					if(character.position.getY() < item.position.getY() + item.dimension.getHeight()) {
						if(Math.abs((character.position.getX() + character.dimension.getWidth() + character.velocity.getX()) - item.position.getX()) < character.moveSpeed.getSpeed())
							character.position.setX(character.position.getX() - ((character.position.getX() + character.dimension.getWidth() + character.velocity.getX()) - item.position.getX()));
						
						if(character.position.getX() + character.dimension.getWidth() + character.velocity.getX() > item.position.getX())
							if(character.position.getX() + character.velocity.getX() < item.position.getX() + item.dimension.getWidth())
								isMovable = false;
					}
			}
			if(isMovable)
				character.position.setX(character.position.getX() + character.velocity.getX());
			isMovable = true;
		}
	}
}
