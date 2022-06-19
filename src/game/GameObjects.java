package game;

import java.util.LinkedList;

public class GameObjects {
	private static volatile GameObjects instance;
	private LinkedList<Object> objects = null;
	private LinkedList<Player> players = null;
	private static final java.lang.Object object = new java.lang.Object();
	
	private GameObjects() {
		objects = new LinkedList<Object>();
		players = new LinkedList<Player>();
	}
	
	public static GameObjects getInstance() {
		if(instance == null) {
			synchronized (object) {
				if(instance == null) {
					instance = new GameObjects();
				}
			}
		}
		return instance;
	}

	public void addObject(Object item) {
		objects.add(item);
	}
	public void removeObject(Object item) {
		objects.remove(item);
	}
	public LinkedList<Object> getObjects(){
		return objects;
	}
	
	public void addPlayer(Player item) {
		players.add(item);
	}
	public void removePlayer(Player item) {
		players.remove(item);
	}
	public LinkedList<Player> getPlayers(){
		return players;
	}
}
