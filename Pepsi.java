/*
 * 1.create the class skeleton
 * 2. identify all class attributes
 * 3. getters/setters
 * 4. default constructor
 * 5. other constructor
 * 6. display method
 * 7. any other code
 * 8. test in an application
 */
public class Pepsi {
	
	protected int x, y; // upper left, top position
	protected int height, width;
	protected String image;
	
	public Pepsi() {
		super();
	}
	
	public Pepsi (int x, int y, int height, int width,
			String image) {
		super();
		this.x = x; //Sprite.x = x
		this.y = y;
		this.height = height;
		this.width = width;
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
