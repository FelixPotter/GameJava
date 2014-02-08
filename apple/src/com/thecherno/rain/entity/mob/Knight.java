package com.thecherno.rain.entity.mob;

import java.util.Random;

import com.thecherno.rain.Game;
import com.thecherno.rain.entity.projectile.Fire;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;
import com.thecherno.rain.level.tile.Tile;

public class Knight extends Mob{
	private Keyboard input;
	private Sprite sprite;
	protected int anim = 0;
	private int dir = 5;
	private static int xa = 0;
	public static double hp = 100;
	private static int ya = 0;
	private static int speed = 0;
	private static int xx = 340;
	private static int yy = 496;
	long timer = 1;
	public static Sprite spriteFire;
	static boolean hit = false;
	private boolean walking = false;
	private boolean mousePressed = false;
	private static final Random random = new Random();
	private int fireRate = 0;
	Projectile p;
	public Knight(Sprite sprite) {
		super();
	}
	public Knight(int x, int y, Keyboard input){
		this.input = input;
		this.x = x;
		this.y = y;
		sprite = Sprite.player_forward;
	}
	public boolean sleep(){
		//System.out.println(timer);
		if(timer>=2000){
			timer = timer-timer;
			speed = random.nextInt(4);
			return true;
		}
		timer = timer + 10;
		//System.out.println(timer);
		
		speed = 5;
		return false;
	}
	public void update(){
		if(fireRate>0)fireRate--;
		if(anim<7500)anim++;
		else anim = 0;
		if (Player.input.up)dir = 1;
		if (Player.input.down)dir = 3;
		if (Player.input.left)dir = 2;
		if (Player.input.right)dir = 0;
		if(xa!=0 || ya!=0){
			walking = true;
		}
		if(hp<=0){
			xx = 0;
			yy = 0;
			remove();
		}
		if(!collision(xa,ya)){
			x += xa;
			y += ya;
		}
		else{
			walking = false;
			
		}
	}
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		if(level.getTile((x+xa*56)/56,(y+ya*16)/16).soild())solid = true;
		return solid;
	}
	public void chase(){
		xa = (Player.x - Knight.x);
		ya = (Player.y - Knight.y);
		if(dir == 1){
			sprite = Sprite.player_backward;
			if(anim%20>10){
				sprite = Sprite.player_backward1;
				sprite = Sprite.player_backward2;
			}else{
					sprite = Sprite.player_backward3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_forward;
			spriteFire = Sprite.fire_forward2;
			}
		if(dir == 0){
			sprite = Sprite.player_right;
			if(anim%20>10){
				sprite = Sprite.player_right1;
				sprite = Sprite.player_right2;
				sprite = Sprite.player_right3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_right;
			spriteFire = Sprite.fire_right2;
			}
		if(dir == 3){
			sprite = Sprite.player_forward;
			if(anim%20>10){
				sprite = Sprite.player_forward1;
				sprite = Sprite.player_forward2;
				sprite = Sprite.player_forward3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_backward;
			spriteFire = Sprite.fire_backward2;
			}
		if(dir == 2){
			sprite = Sprite.player_left;
			if(anim%20>10){
				sprite = Sprite.player_left1;
				sprite = Sprite.player_left2;
				sprite = Sprite.player_left3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_left;
			spriteFire = Sprite.fire_left2;
			}
		if(dir == 5){
			
			}
	}
	public void still(){
		sleep();
		if(speed == 1){
			sprite = Sprite.player_backward;
			if(anim%20>10){
				sprite = Sprite.player_backward1;
				sprite = Sprite.player_backward2;
			}else{
					sprite = Sprite.player_backward3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_forward;
			spriteFire = Sprite.fire_forward2;
			}
		if(speed == 0){
			sprite = Sprite.player_right;
			if(anim%20>10){
				sprite = Sprite.player_right1;
				sprite = Sprite.player_right2;
				sprite = Sprite.player_right3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_right;
			spriteFire = Sprite.fire_right2;
			}
		if(speed == 3){
			sprite = Sprite.player_forward;
			if(anim%20>10){
				sprite = Sprite.player_forward1;
				sprite = Sprite.player_forward2;
				sprite = Sprite.player_forward3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_backward;
			spriteFire = Sprite.fire_backward2;
			}
		if(speed == 2){
			sprite = Sprite.player_left;
			if(anim%20>10){
				sprite = Sprite.player_left1;
				sprite = Sprite.player_left2;
				sprite = Sprite.player_left3;
				}
			move(Knight.xa,Knight.ya);
			dir = 5;
			spriteFire = Sprite.fire_left;
			spriteFire = Sprite.fire_left2;
			}
		if(speed == 5){
			
		}
	}
	public void render(Screen screen){
		//int xx = 340;
		//int yy = 496;
		//System.out.println(hp);
		double a = ((Mouse.getX()/2)+16);
		double b = (Mouse.getY()+ (Game.getWindowHeight()/2)-56);
		//System.out.println("a"+a);
		//System.out.println("b"+b);
		//System.out.println(Mouse.getY()+ (Game.getWindowHeight()/2)-56);
		if(a>=(Knight.xx-40)&& a<=(Knight.xx+40)){
			//System.out.println("yes");
			if(b>=(Knight.yy-40)&& b<=(Knight.yy+40)){
				if(Mouse.mouseK == 1){
					hp = hp - 5;
					Mouse.mouseK = 0;
				}
			}
		}
		else{
			
		}
		//System.out.println("hit"+punch(x,y));
		if(Player.input.chase){
			xx = x - 56;
			yy = y - 16;
			chase();
			
		}
		//xx = 340;
		//yy = 496;
		if(Player.input.stop)still();
		screen.renderPlayer(xx,yy, sprite);
		}
	}