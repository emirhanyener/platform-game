package util;

import java.awt.Color;
import java.awt.Image;

import game.GameObjects;
import game.Setting;

public class Object{
	public Position position;
	public Dimension dimension;
	public Color color;
	private boolean _isAbstract = false;
	private TriggerEvent triggerEvent = null;
	private Image image = null;

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
	
	public Color getColor() {
		return color;
	}
	public Image getImage() {
		return image;
	}
	public boolean isAbstract() {
		return this._isAbstract;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public void setAbstract(boolean value) {
		this._isAbstract = value;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	public void Triggered(Object object) {
		this.triggerEvent.OnTriggered();
	}
	public void SetTriggerEvent(TriggerEvent trigger) {
		this.triggerEvent = trigger;
	}
	
	public void Destroy() {
		GameObjects.getInstance().removeObject(this);
	}
}
