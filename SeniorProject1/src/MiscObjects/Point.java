package MiscObjects;
public class Point {
	public int X;
	public int Y;

	public Point(int x, int y) {
		X = x;
		Y = y;
	}

	public void setX(int d) {
		this.X = d;
	}

	public void setY(int y) {
		this.Y = y;
	}
	
	public double getX() {
		return this.X;
	}

	public double getY() {
		return this.Y;
	}

}
