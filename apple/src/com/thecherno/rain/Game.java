package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.thecherno.rain.entity.mob.Knight;
import com.thecherno.rain.entity.mob.Player;
import com.thecherno.rain.entity.mob.SpawnKnight;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;
import com.thecherno.rain.level.Level;
import com.thecherno.rain.level.RandomLevel;
import com.thecherno.rain.level.SpawnLevel;
import com.thecherno.rain.level.TileCoordinate;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Rain";
	
	private Screen screen;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Keyboard key;
	private Level level;
	private Player player;
	private Knight knight;
	//private SpawnKnight knight1;
	private int d = 3;
	public static int f = 0;
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private SpawnKnight[] enemy;
	
	
	public Game(){
		Dimension size = new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		enemy = new SpawnKnight[d];
		screen = new Screen(width,height);
		frame = new JFrame();
		key = new Keyboard();
		level = new SpawnLevel("/textures/levels/level2.png");
		TileCoordinate playerSpawn = new TileCoordinate(19,32);
		player = new Player(playerSpawn.x()+146,playerSpawn.y()-166,key);
		knight = new Knight(playerSpawn.x()-f,playerSpawn.y()-f, key);
		player.init(level);
		if(Knight.hp<=0){
			
		}
		else{
			knight.init(level);
			for(int z = 0;z<d;z++){
				f = f+30;
				enemy[z] = new SpawnKnight(playerSpawn.x()-f,playerSpawn.y()-f);
				enemy[z].init(level);
			}
		}
		addKeyListener(key);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static int getWindowWidth(){
		return width * scale;
	}
	public static int getWindowHeight(){
		return height * scale;
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0/60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		boolean shouldRender = true;
		requestFocus();
		while(running){
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime = now;
			shouldRender = true;
			
			while(delta>=1){
				update();
				updates++;
				delta--;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(shouldRender){
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer>1000){
				timer+=1000;
				frame.setTitle(title+" | "+ updates+"ups,"+frames+"fps");
				updates =0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update(){
		key.update();
		if(Knight.hp<=0){
			
		}
		else{
			for(int z = 0;z<d;z++){
				enemy[z].update();
			}
		}
		knight.update();
		player.update();
		level.update();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll,yScroll, screen);
		player.render(screen);
		knight.render(screen);
		if(Knight.hp<=0){
			
		}
		else{
			for(int z = 0;z<d;z++){
				enemy[z].render(screen);
			}
			
		}
		
		for(int i = 0; i <pixels.length;i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
		
	}
}

