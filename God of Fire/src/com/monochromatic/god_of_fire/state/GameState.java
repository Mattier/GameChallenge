package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.SetupClass;
import com.monochromatic.god_of_fire.entity.EntityController;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.graphics.Camera;

public class GameState extends BasicGameState{
	//declare variables here
	EntityController EC;
	TiledMap testMap;
	Player player;
	
	private final int gameWidth=640;
	private final int gameHeight=480;
	
	Camera playersPerspective;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 //All variables defined here
		testMap=new TiledMap("resources/Map.tmx");//TODO Replace with real map
		player=new Player(this, 150, 150, 10, 10, 10, 5);
		//REGISTER PLAYER WITH EC
		//EC.register(player);
		playersPerspective=new Camera(this, 0,0);
		
		//Test this 
		//EntityHazard hazard = new EntityHazard(this, 100, 100, Direction.DOWN, 1);
		//hazard.setImage("someImage");
		//EC.register(hazard);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		testMap.render(0 - (int)playersPerspective.getxOffset(), 
				0- (int)playersPerspective.getyOffset());
		player.render();
		//EC.render();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		player.update(gc);
		//EC.update(gc);
	}

	public int getID() {	//returns ID for SetupClass
		return SetupClass.gameState;
	}
	

	public int getGameWidth() {
		return gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}
	
	public Camera getCamera(){
		return playersPerspective;
	}

	public TiledMap getMap() {
		return testMap;
	}

	public void setMap(TiledMap testMap) {
		this.testMap = testMap;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}