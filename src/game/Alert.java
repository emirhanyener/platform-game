package game;

public class Alert {
	private static Alert alert = null;
	private String[] list;
	private int index;
	
	private Alert() {
		this.list = new String[3];
		this.list[0] = "";
		this.list[1] = "";
		this.list[2] = "";
		
		this.index = 0;
	}
	
	public static Alert getInstance() {
		if(alert == null)
			alert = new Alert();
		return alert;
	}
	
	public void addAlert(String value) {
		if(this.index == 3)
			this.index = 0;
		list[index] = value;
		this.index++;
	}
	
	public String[] getAlerts() {
		return this.list;
	}
	
	public int getIndex() {
		return this.index;
	}
}