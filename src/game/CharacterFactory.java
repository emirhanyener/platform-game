package game;

import java.awt.Color;
import java.util.LinkedList;

public class CharacterFactory extends Factory{
	public LinkedList<Player> characters;

	@Override
	public void createProducts() {
		characters = new LinkedList<Player>();
		Player player1 = new Player(new Position(50, 300), new Dimension(30, 30));
		player1.setColor(new Color(0, 100, 200));
		player1.moveSpeed.setSpeed(6);
		player1.jumpSpeed.setSpeed(18f);
		characters.add(player1);
	}
	
	public LinkedList<Player> getProducts() {
		return this.characters;
	}
}