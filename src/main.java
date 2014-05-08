
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;


public class main extends StateBasedGame{
	
	public static AppGameContainer appgc;

	public static int screenWidth = 960;
	public static int screenHeight = 540;
	
	public main(String name) {
		super(name);
		try{
			//window wich hold game
			appgc = new AppGameContainer(new main("test"));
			appgc.setDisplayMode(screenWidth, screenHeight, false);
			appgc.start();
		}catch(SlickException e){
			Log.error(e.toString());
		}
	}


	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
