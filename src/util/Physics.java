package util;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import game.GameObjects;
import game.Setting;

public class Physics{
	private LinkedList<Character> characters;
	private boolean isMovable = true;
	private boolean isGravityControlled = false;
	
	public Physics() {
		characters = new LinkedList<Character>();
	}
	
	public void addCharacter(Character item) {
		characters.add(item);
	}

	public void calculate() {
		for(int p = 0; p < GameObjects.getInstance().getPlayers().size(); p++) {
			Character character = GameObjects.getInstance().getPlayers().get(p);
			for(int o = 0; o < GameObjects.getInstance().getObjects().size(); o++) {
				Object item = GameObjects.getInstance().getObjects().get(o);
				
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
					isGravityControlled = true;
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
			
			if(isMovable) {
				character.position.setX(character.position.getX() + character.velocity.getX());
			}
			if(isGravityControlled) {
				character.velocity.setY(character.velocity.getY() + Setting.GRAVITY * 6);
				character.position.setY(character.position.getY() + character.velocity.getY());
			}
			isMovable = true;
			isGravityControlled = false;
		}
	}
}
