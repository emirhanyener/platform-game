package game;

import java.util.LinkedList;

public class Physics {
	public Physics(LinkedList<Object> objects, Character character) {
		for(Object item : objects) {

			if(character.getPosition().getX() + character.velocity.getX() + character.dimension.getWidth() > item.getPosition().getX() && character.getPosition().getX() + character.velocity.getX() - item.dimension.getWidth() < item.getPosition().getX() && character.getPosition().getY() + character.velocity.getY() + character.dimension.getHeight() > item.getPosition().getY() && character.getPosition().getY() + character.velocity.getY() < item.getPosition().getY() + item.getDimension().getHeight())
			{	
				character.position.setY(item.position.getY() - character.dimension.getHeight());
				character.velocity.setY(0);
				if(character.jump) {
					character.velocity.setY(-character.jumpSpeed.getSpeed());
					character.jump = false;
				}
			}
			else {
				character.velocity.setY(character.velocity.getY() + Setting.GRAVITY);
				character.position.setY(character.position.getY() + character.velocity.getY());
			}
		}
		character.position.setX(character.position.getX() + character.velocity.getX());
	}
}
