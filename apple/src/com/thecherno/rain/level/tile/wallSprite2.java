package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class wallSprite2 extends Tile{

	public wallSprite2(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y,Screen screen){
		screen.renderTile(x<<4, y<<4, this);
	}
	
	public boolean soild(){
		return false;
	}

}