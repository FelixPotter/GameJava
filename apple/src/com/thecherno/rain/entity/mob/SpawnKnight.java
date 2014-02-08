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

public class SpawnKnight extends Mob{
	private int KnightSpeed = 0;
	private Sprite sprite;
	private int anim = 0;
	private static int xa = 1;
	private static double hp = 100;
	private static int ya = 1;
	private static int speed = 0;
	private static int xx = 340;
	private static int yy = 496;
	private int time =0;
	private int x;
	private int y;
	private long timer = 1;
	public static Sprite spriteFire;
	static boolean hit = false;
	private boolean walking = false;
	private boolean mousePressed = false;
	private static final Random random = new Random();
	private int fireRate = 0;
	Projectile p;
	private SpawnKnight(Sprite sprite) {
		super();
	}
	public SpawnKnight(int x, int y){
		this.x = x;
		this.y = y;
		sprite = Sprite.player_forward;
	}
	private boolean sleep(){
		//System.out.println(timer);
		if(timer>=2000){
			timer = timer-timer;
			speed = random.nextInt(4);
			//KnightSpeed = random.nextInt(20);
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
		time++;
		System.out.println(time % 60);
		if(time % 60 == 0){
			//xa  = -xa;
			xa  = (random.nextInt(3) - 1);
			//if(random.nextInt(3)==0){
				//ya = 0;
				//xa = 0;
			//}
		}
		
		if(xa!=0 || ya!=0){
			walking = true;
		}
		
		else{
			walking = false;
			
		}
	}
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		if(level.getTile((x+xa*56)/56,(y+ya*16)/16).soild())solid = false;
		return solid;
	}
	
	public void still(Screen screen){
		//sleep();
		if(ya == -1){
			//ya--;
			sprite = Sprite.player_backward;
			if(anim%20>10){
				sprite = Sprite.player_backward1;
				sprite = Sprite.player_backward2;
			}else{
					sprite = Sprite.player_backward3;
				}
			//move(SpawnKnight.xa,SpawnKnight.ya);
			//dir = 5;
			spriteFire = Sprite.fire_forward;
			spriteFire = Sprite.fire_forward2;
			}
		if(xa == 1){
			//xa++;
			sprite = Sprite.player_right;
			if(anim%20>10){
				sprite = Sprite.player_right1;
				sprite = Sprite.player_right2;
				sprite = Sprite.player_right3;
				}
			//move(SpawnKnight.xa,SpawnKnight.ya);
			//dir = 5;
			spriteFire = Sprite.fire_right;
			spriteFire = Sprite.fire_right2;
			}
		if(ya == 1){
			//ya++;
			sprite = Sprite.player_forward;
			if(anim%20>10){
				sprite = Sprite.player_forward1;
				sprite = Sprite.player_forward2;
				sprite = Sprite.player_forward3;
				}
			//move(SpawnKnight.xa,SpawnKnight.ya);
			//dir = 5;
			spriteFire = Sprite.fire_backward;
			spriteFire = Sprite.fire_backward2;
			}
		if(xa == -1 ){
			xa  = -xa;
			sprite = Sprite.player_left;
			if(anim%20>10){
				sprite = Sprite.player_left1;
				sprite = Sprite.player_left2;
				sprite = Sprite.player_left3;
				}
			//move(SpawnKnight.xa,SpawnKnight.ya);
			//dir = 5;
			spriteFire = Sprite.fire_left;
			spriteFire = Sprite.fire_left2;
			}
		if(speed == 5){
			
		}
		screen.renderPlayer(xx,yy, sprite);
	}
	public void render(Screen screen){
		still(screen);
		xx = x  - 58;
		yy = y - 46;
		//screen.renderPlayer(xx,yy, sprite);
		
		}
	}
