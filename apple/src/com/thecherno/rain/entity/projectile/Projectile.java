package com.thecherno.rain.entity.projectile;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Projectile extends Entity{
    protected final int xOrigin,yOrigin;
    protected double angle;
    public static Sprite sprite;
    protected double nx,ny;
    protected double x,y;
    protected double distance;
    protected double speed,range,damage;
    
	public Projectile(int x, int y, double dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	public Sprite getSprite(){
		return sprite;
	}
	public int getSpriteSize(){
		return sprite.SIZE;
	}
	
	protected void move(){
		
	}

}
