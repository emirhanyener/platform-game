package game;

public class DynamicCamera extends Camera{
	private Position firstPosition;
	private Object target;
	private Position offset;

	public DynamicCamera(Object target, Position offset) {
		this.target = target;
		this.firstPosition = new Position(this.target.position.getX(), this.target.position.getY());
		this.offset = offset;
		
		Thread updatePos = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					position = Position.diff(target.position, firstPosition);
					position.addX(-Setting.WINDOW_WIDTH / 2 + target.dimension.getWidth());
					position.addX(offset.getX());
					position.addY(offset.getY());
				}
			}
		});
		
		updatePos.start();
	}
}