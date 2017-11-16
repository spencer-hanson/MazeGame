package net.matrixstudios.mazegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MazeGame {

	public static final String[] maze = { "XXXXXXXXXXXXXXXX",
			"XOOOXXOOOOOOOOOX", "XXXOXXXXXXOOOXOX", "XOOOOOOOXXOXOXOX",
			"XOXXXOXOXXOXOXOX", "XOOOOOXOOOOXOXOX", "XOXXXXXOXXXXOXOX",
			"XOXXOOOOOXXXXXOX", "XOXOOOXXXXOXXXOX", "XXXXOOOOOOOOXXOX",
			"XXXXXXXXXXXOXXOX", "XOOOOOOXOOOXXXOX", "XOXXOXOXOXOOXOOX",
			"XOWXOXOOOXOOOOXX", "XXXXXXXXXXXXXXXX"

	};

	private BufferedImage backbuffer;
	private Graphics2D g2d;

	private ArrayList<Entity> entities;
	private Player player;

	private boolean youwin;

	public static final int BLOCK_SIZE = 20;

	public MazeGame() {
		backbuffer = new BufferedImage(Window.WIDTH, Window.HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		g2d = backbuffer.createGraphics();
		entities = new ArrayList<Entity>(10);
		player = new Player();
		entities.add(player);
		youwin = false;
		initBlocks();
	}

	public void initBlocks() {
		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze[y].length(); x++) {
				if (maze[y].charAt(x) == 'X') {
					entities.add(new Block(x, y + 1));
				} else if (maze[y].charAt(x) == 'W') {
					entities.add(new Block(x, y + 1, true));
				}
			}
		}
	}

	public boolean isBlocked(int blockx, int blocky) {
		blocky -= 1; // offset
		if (maze[blocky].charAt(blockx) == 'X') {
			return true;
		} else {
			return false;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S
				|| e.getKeyCode() == KeyEvent.VK_A
				|| e.getKeyCode() == KeyEvent.VK_D) {

		}
	}

	public void keyPressed(KeyEvent e) {
		
		if (youwin) {
			youwin = false;
		} else {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				if (!isBlocked(player.getBlockX(), player.getBlockY() - 1)) {
					player.addBlockY(-1);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				if (!isBlocked(player.getBlockX(), player.getBlockY() + 1)) {
					player.addBlockY(1);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				if (!isBlocked(player.getBlockX() - 1, player.getBlockY())) {
					player.addBlockX(-1);
				}
			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				if (!isBlocked(player.getBlockX() + 1, player.getBlockY())) {
					player.addBlockX(1);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_T) {
			youwin = true;
		}
	}

	public void paint(Graphics g) {
		g.drawImage(backbuffer, 0, 0, null);
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);

		for (Entity entity : entities) {
			entity.paint(g2d);
		}
		if(youwin) {
			g2d.setColor(Color.black);
			g2d.fillRect(Window.WIDTH/2 - 28, Window.HEIGHT/2 - 18, 60, 25);
			g2d.setColor(Color.red);
			g2d.drawString("You Win!", Window.WIDTH/2 - 20, Window.HEIGHT/2 - 3);
		}
	}

	public void update() {
		if (player.getBlockX() == 2 && player.getBlockY() == 14) {
			youwin = true;
			player.reset();
		}
		for (Entity entity : entities) {
			entity.update();
		}
	}
}
