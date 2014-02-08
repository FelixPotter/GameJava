package com.thecherno.rain.entity.mob;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.projectile.Fire;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	private Keyboard key;
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean walking = false;
	protected boolean mousePressed = false;
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	protected List<Knight> ai = new ArrayList<Knight>();
	
	
	public void move(int xa,int ya){
		if (xa>0)dir = 1;
		if (xa<0)dir = 3;
		if (ya>0)dir = 2;
		if (ya<0)dir = 0;
		
		if(!collision(xa,ya)){
			x += xa;
			y += ya;
		}
		
	}
	public void update(){
		
	}
	
	protected void shoot(int x, int y,double dir){
		Projectile p = new Fire(x,y,dir);
		projectiles.add(p);
		level.add(p);
	}
	protected void dead(){
		Knight w = new Knight(345,476,key);
		ai.add(w);
	}
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		if(level.getTile((x+xa*16)/16,(y+ya*16)/16).soild())solid = true;
		return solid;
	}
	
	public void render(){}

}

