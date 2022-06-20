package object;
import java.awt.Color;
import java.awt.Image;

import util.Dimension;
import util.Object;
import util.Position;
import util.Speed;
import util.Player;

public class SpeedBuffObject extends Object{
	private float multipler;

	public SpeedBuffObject(Position position, float speedMultipler) {
		this.position = position;
		this.dimension = new Dimension(30, 30);
		this.setAbstract(true);
		this.color = Color.RED;
		this.multipler = speedMultipler;
	}
	
	@Override
	public void Triggered(Object object) {
		((Player)object).moveSpeed = new Speed(((Player)object).moveSpeed.getSpeed() * multipler);
		this.Destroy();
	}
}
