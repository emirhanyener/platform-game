package util;

public class Player extends Character {
	public Player(Position position, Dimension dimension) {
		this.moveSpeed = new Speed(1);
		this.jumpSpeed = new Speed(1);
		this.velocity = new Velocity(0, 0);
		this.position = position;
		this.dimension = dimension;
	}
}
