package com.thecherno.rain.entity.mob;

import com.thecherno.rain.Game;
import com.thecherno.rain.entity.projectile.Fire;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;

public class Player extends Mob{
	
	public static Keyboard input;
	private Sprite sprite;
	public static Sprite spriteFire;
	private int anim = 0;
	private boolean walking = false;
	//private static int xa = 0;
	//private int ya = 0;
	private static boolean mousePressed = false;
	private int fireRate = 0;
	Projectile p;
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_forward;
		
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = Fire.Fire_Rate;
	}
	
	public void update(){
		int xa = 0, ya = 0;
		if(fireRate>0)fireRate--;
		if(anim<7500)anim++;
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if(xa!=0 || ya!=0){
			move(xa,ya);
		}
		else{
			walking = false;
		}
		
		clear();
		updateShooting();
	}
	private void clear() {
		for(int i = 0;i<projectiles.size();i++){
			Projectile p = projectiles.get(i);
			if(p.isRemoved())projectiles.remove(i);
		}
		
	}

	private void updateShooting(){
		if(Mouse.getButton() == 1&& fireRate<=0){
			double dx = (Mouse.getX() - Game.getWindowWidth()/2);
			double dy = (Mouse.getY() - Game.getWindowHeight()/2);
			double dir = Math.atan2(dy, dx);
			shoot(x,y,dir);
			fireRate = Fire.Fire_Rate;
		}
		
	}
	
	public void render(Screen screen){
		//System.out.println(x);
		//System.out.println("y"+y);
		if(input.a){
			Knight.hp = 100;
		}
		int xx = x - 16;
		int yy = y - 16;
		if(dir == 0){
			sprite = Sprite.player_backward;
			if(anim%20>10){
				sprite = Sprite.player_backward1;
				sprite = Sprite.player_backward2;
			}else{
					sprite = Sprite.player_backward3;
				}
			}
		spriteFire = Sprite.fire_forward;
		spriteFire = Sprite.fire_forward2;
		if (walking==false){
			spriteFire = Sprite.fire_forward;
			spriteFire = Sprite.fire_forward2;
			}
	if(dir == 1){
		sprite = Sprite.player_right;
			if(anim%20>10){
				sprite = Sprite.player_right1;
				sprite = Sprite.player_right2;
				sprite = Sprite.player_right3;
				}
			}
		spriteFire = Sprite.fire_right;
		spriteFire = Sprite.fire_right2;
		if(walking==false){
			spriteFire = Sprite.fire_right;
			spriteFire = Sprite.fire_right2;
			}
	if(dir == 2){
		sprite = Sprite.player_forward;
			if(anim%20>10){
				sprite = Sprite.player_forward1;
				sprite = Sprite.player_forward2;
				sprite = Sprite.player_forward3;
				}
			}
		spriteFire = Sprite.fire_backward;
		spriteFire = Sprite.fire_backward2;
		if(walking==false){
			spriteFire = Sprite.fire_backward;
			spriteFire = Sprite.fire_backward2;
			}
	if(dir == 3){
		sprite = Sprite.player_left;
			if(anim%20>10){
				sprite = Sprite.player_left1;
				sprite = Sprite.player_left2;
				sprite = Sprite.player_left3;
				}
		spriteFire = Sprite.fire_left;
		spriteFire = Sprite.fire_left2;
		if(walking==false){
			spriteFire = Sprite.fire_left;
			spriteFire = Sprite.fire_left2;
			}
		}
	screen.renderPlayer(xx, yy, sprite);
	}
}