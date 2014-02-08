package com.thecherno.rain.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16,0,0,SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0x003366);
	public static Sprite brickSprite = new Sprite(16,0,1,SpriteSheet.tiles);
	public static Sprite waterSprite = new Sprite(16,1,1,SpriteSheet.tiles);
	public static Sprite blueMineral = new Sprite(16,1,0,SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16,2,0,SpriteSheet.tiles);
	
	public static Sprite wall1 = new Sprite(16,0,1,SpriteSheet.spawnlvl);
	public static Sprite wall2 = new Sprite(16,0,2,SpriteSheet.spawnlvl);
	public static Sprite wall3 = new Sprite(16,2,1,SpriteSheet.spawnlvl);
	public static Sprite water2 = new Sprite(16,2,0,SpriteSheet.spawnlvl);
	public static Sprite lava = new Sprite(16,1,2,SpriteSheet.spawnlvl);
	public static Sprite grass2 = new Sprite(16,0,0,SpriteSheet.spawnlvl);
	public static Sprite hedge = new Sprite(16,1,0,SpriteSheet.spawnlvl);
	public static Sprite wood = new Sprite(16,1,1,SpriteSheet.spawnlvl);
	public static Sprite sand = new Sprite(16,2,2,SpriteSheet.spawnlvl);
	
	public static Sprite fire_forward = new Sprite(32,0,5,SpriteSheet.tiles);
	public static Sprite fire_forward2 = new Sprite(32,0,6,SpriteSheet.tiles);
	public static Sprite fire_backward = new Sprite(32,1,5,SpriteSheet.tiles);
	public static Sprite fire_backward2 = new Sprite(32,1,6,SpriteSheet.tiles);
	public static Sprite fire_left = new Sprite(32,2,5,SpriteSheet.tiles);
	public static Sprite fire_left2 = new Sprite(32,2,6,SpriteSheet.tiles);
	public static Sprite fire_right = new Sprite(32,3,5,SpriteSheet.tiles);
	public static Sprite fire_right2 = new Sprite(32,3,6,SpriteSheet.tiles);
	
	
	public static Sprite knight = new Sprite(48,0,0,SpriteSheet.knight);
	public static Sprite knight2 = new Sprite(48,0,1,SpriteSheet.knight);
	
	
	
	
	
	
	
	public static Sprite player_forward = new Sprite(32, 0, 1, SpriteSheet.tiles);
	public static Sprite player_backward = new Sprite(32, 2, 1, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32, 6, 1, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32, 4, 1, SpriteSheet.tiles);
	public static Sprite player_forward1 = new Sprite(32, 1, 1, SpriteSheet.tiles);
	public static Sprite player_backward1 = new Sprite(32, 3, 1, SpriteSheet.tiles);
	public static Sprite player_left1 = new Sprite(32, 7, 1, SpriteSheet.tiles);
	public static Sprite player_right1 = new Sprite(32, 5, 1, SpriteSheet.tiles);
	public static Sprite player_forward2 = new Sprite(32, 0, 2, SpriteSheet.tiles);
	public static Sprite player_backward2 = new Sprite(32, 2, 2, SpriteSheet.tiles);
	public static Sprite player_left2 = new Sprite(32, 6, 2, SpriteSheet.tiles);
	public static Sprite player_right2 = new Sprite(32, 4, 2, SpriteSheet.tiles);
	public static Sprite player_forward3 = new Sprite(32, 1, 2, SpriteSheet.tiles);
	public static Sprite player_backward3 = new Sprite(32, 3, 2, SpriteSheet.tiles);
	public static Sprite player_left3 = new Sprite(32, 7, 2, SpriteSheet.tiles);
	public static Sprite player_right3 = new Sprite(32, 5, 2, SpriteSheet.tiles);
	
	public Sprite(int size,int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x*size;
		this.y = y*size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for(int i = 0; i<SIZE*SIZE;i++){
			pixels[i] = color;
		}
		
	}

	private void load(){
		for(int y = 0;y<SIZE;y++){
			for(int x = 0;x<SIZE;x++){
				pixels[x+y*SIZE] = sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
			}
		}
	}
	public boolean soild(){
		return false;
	}
}