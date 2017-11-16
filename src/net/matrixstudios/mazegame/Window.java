package net.matrixstudios.mazegame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener {
	
	public static final int WIDTH = 20*17;
	public static final int HEIGHT = 20*17;
	
	private MazeGame game;
	
	public void initComponents() {
		
	}
	
	public void init() {
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setTitle("Maze Game by Spencer Hanson");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		initComponents();
		setVisible(true);
		new Runner().start();
	}
	
	public void paint(Graphics g) {
		game.paint(g);
	}
	
	public Window() {
		game = new MazeGame();
		init();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) { 
		game.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	class Runner extends Thread {
		private boolean stop;
		public Runner() {
			this.stop = false;
		}
		
		@Override
		public void run() {
			while(!stop) {
				try {
					Thread.sleep(20);
					game.update();
					repaint();
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	public void end() {
		this.stop = true;
	}
	}
}
