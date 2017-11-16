package net.matrixstudios.mazegame;

import java.awt.Graphics2D;

public abstract class Entity {
	 protected int x;
	 protected int y;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public abstract void paint(Graphics2D g2d);
	public abstract void update();
}
