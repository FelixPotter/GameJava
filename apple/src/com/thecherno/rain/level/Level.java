package com.thecherno.rain.level;


import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	public static Level spawn = new Level("/textures/levels/level.png");
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Level(int width,int height){
		this.width = width;
		this.height = height;
		tilesInt = new int [width*height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}
	
	protected void loadLevel(String path){
	}
	
	
	
	public void update(){
		for(int i = 0;i < entities.size();i++){
			entities.get(i).update();
		}
	}
	
	private void time(){
	}
	
	public void render(int xScroll,int yScroll,Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width+16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height+16) >> 4;
		
		for(int y = y0;y < y1;y++){
			for(int x = x0;x < x1;x++){
				getTile(x,y).render(x, y, screen);
				
			}
		}
		for(int i = 0;i < entities.size();i++){
			entities.get(i).render(screen);
		}
	}
	public void add(Entity e){
		entities.add(e);
	}
	public Tile getTile(int d, int e){
		if(d<0||e<0||d>=width||e>=height)return Tile.voidTile;
		if(tiles[(d+e*width)]==0xff00ff00)return Tile.grass;
		if(tiles[(int) (d+e*width)]==0xff7f7f00)return Tile.blueMineral;
		if(tiles[(int) (d+e*width)]==0xffffff00)return Tile.flower;
		if(tiles[(int) (d+e*width)]==0xff9B5E08)return Tile.brick;
		if(tiles[(int) (d+e*width)]==0xff3D4E57)return Tile.wall1;
		if(tiles[(int) (d+e*width)]==0xffA87724)return Tile.wall2;
		if(tiles[(int) (d+e*width)]==0xffF1E8CD)return Tile.wall3;
		if(tiles[(int) (d+e*width)]==0xff95ADF0)return Tile.water2;
		if(tiles[(int) (d+e*width)]==0xffC65800)return Tile.lava;
		if(tiles[(int) (d+e*width)]==0xff2C4900)return Tile.grass2;
		if(tiles[(int) (d+e*width)]==0xff447601)return Tile.hedge;
		if(tiles[(int) (d+e*width)]==0xff683500)return Tile.wood;
		if(tiles[(int) (d+e*width)]==0xffE0D6CA)return Tile.sand;
		if(tiles[(int) (d+e*width)]==0xffFFFFFF)return Tile.grass;
		
		return Tile.voidTile;
	}

}
