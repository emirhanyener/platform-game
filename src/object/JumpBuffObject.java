package object;
import java.awt.Color;

import util.Dimension;
import util.Object;
import util.Position;
import util.Speed;
import util.Player;

public class JumpBuffObject extends Object{
	private float multipler;

	public JumpBuffObject(Position position, float jumpMultipler) {
		this.position = position;
		this.dimension = new Dimension(30, 30);
		this.color = Color.BLUE;
		this._isAbstract = true;
		this.multipler = jumpMultipler;
	}
	
	@Override
	public void Triggered(Object object) {
		((Player)object).jumpSpeed = new Speed(((Player)object).jumpSpeed.getSpeed() * multipler);
		this.Destroy();
	}
}
