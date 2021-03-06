//This is a 'dictionary' of commonly repeated or needed texture assets.
//It might be better to serialize them in a data file or something

package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;


public class Sprites {

	
		Timer time = new Timer();
		public static final TextureRegion DUNGEON_FLOOR_PLAIN = Assets.floorTiles.get(0).getImg();
		public static final TextureRegion DUNGEON_FLOOR_EMPTY = Assets.wallTiles.get(0).getImg();
		
		//Player stand-still images.
		public static final TextureRegion P_UP = Assets.player_up;
		public static final TextureRegion P_LEFT = Assets.player_left;
		public static final TextureRegion P_DOWN = Assets.player_down;
		public static final TextureRegion P_RIGHT = Assets.player_right;
		
		//Player animations.
		private static float stateTime = 0f;
		
//		public static final void playerAniMove(int direction){
//			Animation action;
//			
//			
//			
//			stateTime += Gdx.graphics.getDeltaTime();
//			TextureRegion anim = action.getKeyFrame(stateTime, true);
//			MyGdxGame.batch.draw(anim, MyGdxGame.testPlayer.xPos, MyGdxGame.testPlayer.yPos, 0, 0, Tile.WIDTH, Tile.HEIGHT, 1, 1, 0);
//			stateTime = 0f;
//		}
		
		//This method SHOULD play an effect animation through once, maybe twice. ;)
		public static final void effectAnimate(Animation effect){
			for(int x = 0; x < 500; x++){
				stateTime += Gdx.graphics.getDeltaTime();
			if (effect == Assets.fireball){
				TextureRegion anim = effect.getKeyFrame(stateTime, false);
				MyGdxGame.batch.draw(anim, MyGdxGame.playerReticle.xPos, MyGdxGame.playerReticle.yPos, 0, 0, (Tile.WIDTH * 2), (Tile.HEIGHT * 2), 1, 1, 0, false);
				
			} else if (effect == Assets.iceball){
				TextureRegion anim = effect.getKeyFrame(stateTime, false);
				MyGdxGame.batch.draw(anim, MyGdxGame.playerReticle.xPos, MyGdxGame.playerReticle.yPos, 0, 0, Tile.WIDTH, Tile.HEIGHT, 1, 1, 0, false);
			} else {
				return;
			}
			stateTime = 0f;
			}
		}
//		
//		public static void animateSpell(int facing){
//			Animation anim = null;
//			switch(facing){
//			case (Player.UP): {
//				anim = Assets.spell_up;
//			} case(Player.LEFT): {
//				anim = Assets.spell_left;
//			} case(Player.DOWN): {
//				anim = Assets.spell_down;
//			} case(Player.RIGHT): {
//				anim = Assets.spell_right;
//			}
//			}
//			stateTime += Gdx.graphics.getDeltaTime();
//			
//			TextureRegion animation = anim.getKeyFrame(stateTime, true);
//			
//			MyGdxGame.testPlayer.img = animation;
//			//MyGdxGame.batch.draw(animation, MyGdxGame.testPlayer.xPos, MyGdxGame.testPlayer.yPos, 0, 0, Tile.WIDTH, Tile.HEIGHT, 1, 1, 0);
//			stateTime = 0f;
//		}
//
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Some example monster assets to play with. I think they should look okay for testing purposes.
		public static final TextureRegion IMP = Assets.creatureTiles.get(9).img;
		public static final TextureRegion APE_MAN = Assets.creatureTiles.get(5).img;
		public static final TextureRegion OGRE = Assets.creatureTiles.get(34).img;


	}
	



