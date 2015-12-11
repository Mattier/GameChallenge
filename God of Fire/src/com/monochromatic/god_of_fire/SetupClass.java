package com.monochromatic.god_of_fire;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.monochromatic.god_of_fire.state.GameState;
import com.monochromatic.god_of_fire.state.MenuState;

public class SetupClass extends StateBasedGame{

	public static final String gameName = "God of Fire";
	public static final int menuState = 0;
	public static final int gameState = 1;
	
	public SetupClass() {
		
		//set title 
		super(gameName);
		
		
		//create all necessary states
		this.addState(new MenuState()); 
		this.addState(new GameState());
	}

	public void initStatesList(GameContainer container) throws SlickException {
		
		//init/enter menu state
		this.getState(menuState).init(container, this);
		this.enterState(menuState);
	}
	
	public static void main(String[] args){
		AppGameContainer appGC;
		
		try{
			//set up window 
			appGC = new AppGameContainer(new ScalableGame(new SetupClass(), 640, 480, false));
			
			appGC.setDisplayMode(640, 480, false);
			
			//TODO add icon to the window when we get one
			
			appGC.setAlwaysRender(true);
			appGC.setVSync(true);
			appGC.setShowFPS(false);
			
			appGC.setTargetFrameRate(60);
			
			appGC.start();
		}
		catch(SlickException e){
			e.printStackTrace();
		}
	}


}
