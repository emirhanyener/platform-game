package util;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import game.GameObjects;
import game.Setting;

public class Object{
	protected String name;
	public Position position;
	public Dimension dimension;
	public Color color;
	private boolean _isAbstract = false;
	private TriggerEvent triggerEvent = null;
	private Image image = null;

	public Object(String name, Position position, Dimension dimension, Color color) {
		this.name = name;
		this.position = position;
		this.dimension = dimension;
		this.color = color;
	}
	public Object(String name, Position position, Dimension dimension, Color color, boolean isAbstract) {
		this.name = name;
		this.position = position;
		this.dimension = dimension;
		this.color = color;
		this._isAbstract = isAbstract;
	}

	public Object(String name) {
		this.name = name;
		this.position = new Position(0, 0);
		this.dimension = new Dimension(50, 50);
		this.color = Setting.DEFAULT_COLOR;
	}
	
	public Object() {
		Random rand = new Random();
		String randName = "";
		for(int i = 0; i < 10; i++) {
			randName += (char)(65 + (int)(Math.random()*25));
		}
		//System.out.println("no name object: " + randName);
		this.position = new Position(0, 0);
		this.dimension = new Dimension(50, 50);
		this.color = Setting.DEFAULT_COLOR;
	}
	
	public String getName() {
		return name;
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
