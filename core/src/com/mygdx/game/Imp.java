package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Imp extends Enemy {
	
	public Imp(Texture img) {
		super(img);
		this.setStrength(6);
		this.setAgility(4);
		this.setIntelligence(1);
		this.setVigor(7);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(5);
		
		this.setName("Imp");
		
		this.xPos = 15*Tile.WIDTH;
		this.yPos = 0;
	}
	
	public void cut(Creature target) {
		int damage = (int) (1*this.getStrength()); //base damage values for ability is calculated first
		damage = this.flagCheckOffense(damage); //call attack flag checker for extra modifiers.
		System.out.println(this.getName() + " slices at " + target.getName() + "!");
		target.getHit(damage);
	}

}