package com.thecherno.rain.entity.projectile;


import com.thecherno.rain.entity.mob.Player;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Fire extends Projectile{
	public Fire(int x, int y, double dir) {
		super(x, y, dir);
		range = 20;
		damage = 10;
		speed  = 5;
		sprite = Player.spriteFire;
		
		nx = speed*Math.cos(angle);
	    ny = speed*Math.sin(angle);
	}
	public static final int Fire_Rate = 15;
	public void update(){
		move();
	}
	protected void move(){
		x += nx;
		y += ny;
		if(calculateDistance()>range)remove();;
	}
	private double calculateDistance() {
		
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin-x)*(xOrigin - x)+(yOrigin-y)*(yOrigin - y)));
		return dist;
	}

	public void render(Screen screen){
		screen.renderProjectile((int)x - 10, (int)y - 10, this);
		
	}

}
