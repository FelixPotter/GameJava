package com.thecherno.rain.level.tile;

import com.thecherno.rain.entity.mob.Knight;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Tile {
	
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile brick = new BrickTile(Sprite.brickSprite);
	public static Tile water = new WaterTile(Sprite.waterSprite);
	public static Tile blueMineral = new blueMineralTile(Sprite.blueMineral);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile grass2 = new GrassTile(Sprite.grass2);
	public static Tile wall1 = new wallSprite2(Sprite.wall1);
	public static Tile wall2 = new wallSprite(Sprite.wall2);
	public static Tile wall3 = new wallSprite(Sprite.wall3);
	public static Tile water2 = new waterSprite(Sprite.water2);
	public static Tile lava = new lavaSprite(Sprite.lava);
	public static Tile hedge = new hedgeSprite(Sprite.hedge);
	public static Tile wood = new woodSprite(Sprite.wood);
	public static Tile sand = new sandSprite(Sprite.sand);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y,Screen screen){
	}
	public boolean soild(){
		return false;
	}

}
