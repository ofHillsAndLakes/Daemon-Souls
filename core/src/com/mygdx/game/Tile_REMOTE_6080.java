package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

public class Tile extends Entity {
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	private Texture img;
	private boolean canCollide = false;
	
	public Tile(Texture img)
	{
		this.img = img;
	}
	
	public Texture getTexture()
	{
		return img;
	}

	public boolean isCanCollide() {
		return canCollide;
	}

	public void setCanCollide(boolean canCollide) {
		this.canCollide = canCollide;
	}
	
	
}
