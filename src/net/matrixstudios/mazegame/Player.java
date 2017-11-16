package net.matrixstudios.mazegame;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity {
	public static final int SPEED = 4;
	private int blockx;
	private int blocky;
	
	public Player() {
		super(0, 0);
		blockx = 1;
		blocky = 2;
		x = MazeGame.BLOCK_SIZE * blockx;
		y = MazeGame.BLOCK_SIZE * blocky;
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fillOval(x + 10, y + 10, 20, 20);
	}

	public void addBlockX(int add) {
		blockx += add;
	}
	
	public void addBlockY(int add) {
		blocky += add;
	}
	
	public void resetBlock() {
		blockx = Math.round(x/MazeGame.BLOCK_SIZE);
		blocky = Math.round(y/MazeGame.BLOCK_SIZE);
	}
	
	public void reset() {
		blockx = 1;
		blocky = 2;
		x = MazeGame.BLOCK_SIZE * blockx;
		y = MazeGame.BLOCK_SIZE * blocky;
	}
	@Override
	public void update() {
		if(x < blockx * MazeGame.BLOCK_SIZE) {
			x += SPEED;
		} else if(x > blockx * MazeGame.BLOCK_SIZE) {
			x -= SPEED;
		} else if(y < blocky * MazeGame.BLOCK_SIZE) {
			y += SPEED;
		} else if(y > blocky * MazeGame.BLOCK_SIZE) {
			y -= SPEED;
		}
	}

	public int getBlockX() {
		return blockx;
	}
	
	public int getBlockY() {
		return blocky;
	}
	
	
	
}
