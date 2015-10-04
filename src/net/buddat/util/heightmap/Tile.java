package net.buddat.util.heightmap;

public class Tile {

	private int x, y;
	private float height;
	
	public Tile (int x, int y) {
		this(x, y, 0.0f);
	}
	
	public Tile(int x, int y, float height) {
		setX(x);
		setY(y);
		setHeight(height);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		if (newX < 0)
			newX = 0;
		if (newX >= HeightmapGen.MAP_SIZE)
			newX = HeightmapGen.MAP_SIZE;
		
		x = newX;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		if (newY < 0)
			newY = 0;
		if (newY >= HeightmapGen.MAP_SIZE)
			newY = HeightmapGen.MAP_SIZE;
		
		y = newY;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float newHeight) {
		if (newHeight == 0f) {
			height = newHeight;
			return;
		}
		
		float maxHeight = 1.0f - ((1.0f / (HeightmapGen.MAP_SIZE / 1.85f)) * getDist());
		if (newHeight > maxHeight)
			newHeight = maxHeight;
		if (newHeight < 0f)
			newHeight = 0f;
		
		height = newHeight;
	}
	
	private float getDist() {
		float midPoint = HeightmapGen.MAP_SIZE / 2f;
		
		return (float) Math.hypot(Math.abs(x - midPoint), Math.abs(y - midPoint));
	}
}
