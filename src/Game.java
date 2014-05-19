import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.DefaultLogSystem;

public class Game extends BasicGameState {

	public static final DefaultLogSystem log = new DefaultLogSystem();
	
	private int x, y;
	int c;
	private Map map;
	private Game_Interface game_interface;

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		map = new Map(4, 8, 100);
		game_interface = new Game_Interface();
		try {
			map.findPath(0, 0, 7, 2);
			map.paintPath(map.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		map.drawmap();
		game_interface.render_interface(g);
		g.setBackground(Color.white);
		g.drawString("x Koordinate: " + x, 805, 10);
		g.drawString("y Koordinate: " + y, 805, 20);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)	throws SlickException {
		Input input = container.getInput();
		x = Mouse.getX();
		y = Mouse.getY();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
	}

	public int getID() {
		return 1;
	}

}
