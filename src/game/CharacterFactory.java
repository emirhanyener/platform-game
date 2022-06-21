package game;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import util.Dimension;
import util.Factory;
import util.Player;
import util.Position;

public class CharacterFactory extends Factory{

	@Override
	public void createProducts() {
		Player player1 = new Player("Player1", new Position(50, 300), new Dimension(30, 30));
		player1.setColor(new Color(0, 100, 200));
		player1.moveSpeed.setSpeed(6);
		player1.jumpSpeed.setSpeed(13f);
		
		try {
			player1.setImage(ImageIO.read(new File("src/img/image.png")));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		GameObjects.getInstance().addPlayer(player1);
	}
	
}