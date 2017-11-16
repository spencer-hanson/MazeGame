package net.matrixstudios.mazegame;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Entity {
	private boolean winspot;
	public Block(int blockx, int blocky) {
		super(MazeGame.BLOCK_SIZE * blockx, MazeGame.BLOCK_SIZE * blocky);
	}
	
	public Block(int blockx, int blocky, boolean winspot) {
		super(MazeGame.BLOCK_SIZE * blockx, MazeGame.BLOCK_SIZE * blocky);
		this.winspot = winspot;
	}

	@Override
	public void paint(Graphics2D g2d) {
		if(winspot) {
			g2d.setColor(Color.red);
			g2d.fillRect(x + 10, y + 10, MazeGame.BLOCK_SIZE, MazeGame.BLOCK_SIZE);
		}
		g2d.setColor(Color.black);
		g2d.drawRect(x + 10, y + 10, MazeGame.BLOCK_SIZE, MazeGame.BLOCK_SIZE);
	}

	@Override
	public void update() { }

}
