package game;

public class DynamicCamera extends Camera{
	private Position firstPosition;
	private Object target;
	private Position offset;
	private float diffX = 0;
	private float diffY = 0;

	public DynamicCamera(Object target, Position offset) {
		super();
		this.target = target;
		this.firstPosition = new Position(this.target.position.getX(), this.target.position.getY());
		this.offset = offset;
	}
	
	@Override
	public Position getPosition() {
		diffX = (target.position.getX() - position.getX());
		diffY = (target.position.getY() - position.getY());
		position = new Position(position.getX() + diffX, position.getY() + diffY);

		position.addX(-Setting.WINDOW_WIDTH / 2 + target.dimension.getWidth());
		position.addY(-Setting.WINDOW_HEIGHT / 2 + target.dimension.getHeight());
		position.addX(offset.getX());
		position.addY(offset.getY());
		
		return this.position;
	}
	
	@Override
	public Position getRawPosition() {
		diffX = (target.position.getX() - position.getX());
		diffY = (target.position.getY() - position.getY());
		position = new Position(position.getX() + diffX, position.getY() + diffY);

		position.addX(-Setting.WINDOW_WIDTH / 2 + target.dimension.getWidth());
		position.addY(-Setting.WINDOW_HEIGHT / 2);
		position.addX(offset.getX());
		position.addY(offset.getY());
		
		return this.position;
	}
}