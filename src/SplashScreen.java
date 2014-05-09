import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;


public class SplashScreen extends BasicGameState {

	int time = 0;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawString("Eclectic Games", 440, 240);
		g.drawString(""+time/1000,490,280);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
//		if(time < 6 * 1000) { //multiply by 1000 to get milliseconds
//	        time += delta;
//	    }else{
	    	sbg.enterState(main.MAINMENU);
	    //}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
