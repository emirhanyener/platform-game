package game;

import java.util.LinkedList;

import util.Object;
import util.Player;

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
	public Object findObject(String name) {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).getName() == name)
				return objects.get(i);
		}
		return null;
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
	public Player findPlayer(String name) {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getName() == name)
				return players.get(i);
		}
		return null;
	}
	public LinkedList<Player> getPlayers(){
		return players;
	}
}
