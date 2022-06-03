package game;

import java.awt.Color;

public class Object{
	public Position position;
	public Dimension dimension;
	public Color color;
	private boolean _isAbstract = false;
	private TriggerEvent triggerEvent = null;

	public Object(Position position, Dimension dimension, Color color) {
		this.position = position;
		this.dimension = dimension;
		this.color = color;
	}
	public Object(Position position, Dimension dimension, Color color, boolean isAbstract) {
		this.position = position;
		this.dimension = dimension;
		this.color = color;
		this._isAbstract = isAbstract;
	}
	public Object() {
		this.position = new Position();
		this.dimension = new Dimension();
		this.color = Setting.DEFAULT_COLOR;
	}

	public Dimension getDimension() {
		return dimension;
	}
	public Position getPosition() {
		return position;
	}
	public Color getColor() {
		return color;
	}
	public boolean isAbstract() {
		return this._isAbstract;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setAbstract(boolean value) {
		this._isAbstract = value;
	}

	public void Triggered() {
		this.triggerEvent.OnTriggered();
	}
	public void SetTriggerEvent(TriggerEvent trigger) {
		this.triggerEvent = trigger;
	}
}
