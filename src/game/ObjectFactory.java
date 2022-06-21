package game;

import java.awt.Color;
import java.util.LinkedList;

import object.JumpBuffObject;
import object.SpeedBuffObject;
import util.Dimension;
import util.Factory;
import util.Object;
import util.Position;
import util.TriggerEvent;

public class ObjectFactory extends Factory{
	@Override
	public void createProducts() {
		GameObjects.getInstance().addObject(new Object("StaticObj1", new Position(0, 500), new Dimension(Setting.WINDOW_WIDTH * 3, Setting.WINDOW_HEIGHT), new Color(0, 255, 0)));
		GameObjects.getInstance().addObject(new Object("StaticObj2", new Position(300, 450), new Dimension(100, 50), new Color(100, 40, 0)));
		GameObjects.getInstance().addObject(new Object("StaticObj3", new Position(500, 390), new Dimension(100, 50), new Color(120, 35, 0)));
		GameObjects.getInstance().addObject(new Object("StaticObj4", new Position(0, 290), new Dimension(450, 10), new Color(140, 30, 0)));
		GameObjects.getInstance().addObject(new Object("StaticObj5", new Position(0, 190), new Dimension(50, 5), new Color(160, 25, 0)));
		GameObjects.getInstance().addObject(new Object("StaticObj6", new Position(0, 90), new Dimension(800, 5), new Color(180, 20, 0)));
		GameObjects.getInstance().addObject(new Object("StaticObj7", new Position(900, 300), new Dimension(50, 15), new Color(200, 15, 0)));

		Object object = new Object("TriggerObj1", new Position(700, 450), new Dimension(100, 50), new Color(0, 200, 10), true);
		object.SetTriggerEvent(new TriggerEvent() {
			@Override
			public void OnTriggered() {
				object.setColor(Color.ORANGE);
			}
		});
		
		GameObjects.getInstance().addObject(object);
		
		Object object2 = new Object("TriggerObj2", new Position(850, 450), new Dimension(50, 50), new Color(0, 200, 10), true);
		object2.SetTriggerEvent(new TriggerEvent() {
			@Override
			public void OnTriggered() {
				object2.setColor(Color.DARK_GRAY);
				GameObjects.getInstance().findPlayer("Player1").dimension.setHeight(200);
			}
		});
		
		GameObjects.getInstance().addObject(object2);
		
		GameObjects.getInstance().addObject(new JumpBuffObject(new Position(1000, 460), 2));
		GameObjects.getInstance().addObject(new SpeedBuffObject(new Position(1050, 460), 2));
	}
}