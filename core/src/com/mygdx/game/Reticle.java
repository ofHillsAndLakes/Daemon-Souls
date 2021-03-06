package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Reticle extends Entity {
	float mapX = 0;
	float mapY = 0;
	
	public Reticle(TextureRegion img) {
		this.img  = img;
		mapX = MyGdxGame.testPlayer.mapX;
		mapY = MyGdxGame.testPlayer.mapY;
	}
	
	public void drawOne(SpriteBatch bat) {

		bat.draw(this.img, (this.xPos - Tile.WIDTH), this.yPos, Tile.WIDTH, Tile.HEIGHT);
	}
	
	public void drawFour(SpriteBatch bat) {
		//bat.draw(this.img, this.xPos, this.yPos, Tile.WIDTH, Tile.HEIGHT); //this was causing wierd double-draw
		bat.draw(this.img, this.xPos, this.yPos, 0, 0, (Tile.WIDTH * 2), (Tile.HEIGHT * 2), 1, 1, 0, false);
	}
	
	//public void drawOne(SpriteBatch bat) {
	//	bat.draw(this.img, this.xPos, this.yPos, 0, 0, Tile.WIDTH, Tile.HEIGHT, 1, 1, 0, false);
	//}
	
	public void move(float x, float y) {
		
		int x2 = xPos;
		int y2 = yPos;	
		int newX = x2 += Tile.WIDTH * x;
		int newY = y2 += Tile.HEIGHT * y;
		int xDis = Math.abs(newX - MyGdxGame.testPlayer.xPos);
		int yDis = Math.abs(newY - MyGdxGame.testPlayer.yPos);
		
		if ((xDis/Tile.WIDTH) <= 5 & (yDis/Tile.HEIGHT) <= 5) {
			mapX +=x;
			mapY +=y;
			xPos += Tile.WIDTH * x;
			yPos += Tile.HEIGHT * y;
		}
	}

}
