import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class Main extends StateBasedGame {

	public static AppGameContainer appgc;

	public static int screenWidth = 960;
	public static int screenHeight = 540;
	
	public static final int FPS     = 30;
	public static final double VERSION = 0.1;
	
    public static final int SPLASHSCREEN = 0;
    public static final int MAINMENU     = 1;
    public static final int GAME         = 2;


	public Main(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
        this.addState(new SplashScreen());
        this.addState(new MainMenu());
        this.addState(new Game());

	}

	
	public static void main(String[] args) throws SlickException {
		try {
			// window wich hold game
			appgc = new AppGameContainer(new Main("Tower Defense -v "+VERSION));
			appgc.setTargetFrameRate(FPS);
			appgc.setDisplayMode(screenWidth, screenHeight, false);
			Display.setInitialBackground(255, 255, 255);
			appgc.start();
		} catch (SlickException e) {
			Log.error(e.toString());
		}

	}

}
