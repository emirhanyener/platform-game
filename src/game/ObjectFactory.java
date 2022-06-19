package game;

import java.awt.Color;
import java.util.LinkedList;

public class ObjectFactory extends Factory{
	@Override
	public void createProducts() {
		GameObjects.getInstance().addObject(new Object(new Position(0, 500), new Dimension(Setting.WINDOW_WIDTH, Setting.WINDOW_HEIGHT), new Color(0, 255, 0)));
		GameObjects.getInstance().addObject(new Object(new Position(300, 450), new Dimension(100, 50), new Color(100, 40, 0)));
		GameObjects.getInstance().addObject(new Object(new Position(500, 390), new Dimension(100, 50), new Color(120, 35, 0)));
		GameObjects.getInstance().addObject(new Object(new Position(0, 290), new Dimension(450, 10), new Color(140, 30, 0)));
		GameObjects.getInstance().addObject(new Object(new Position(0, 190), new Dimension(50, 5), new Color(160, 25, 0)));
		GameObjects.getInstance().addObject(new Object(new Position(0, 90), new Dimension(800, 5), new Color(180, 20, 0)));
		GameObjects.getInstance().addObject(new Object(new Position(900, 300), new Dimension(50, 15), new Color(200, 15, 0)));
		Object object = new Object(new Position(700, 450), new Dimension(100, 50), new Color(0, 200, 10), true);
		object.SetTriggerEvent(new TriggerEvent() {
			@Override
			public void OnTriggered() {
				object.setColor(Color.ORANGE);
			}
		});
		GameObjects.getInstance().addObject(object);
	}
}