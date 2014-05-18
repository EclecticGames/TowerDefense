import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.DefaultLogSystem;
import org.newdawn.slick.util.pathfinding.Path;

public class Game extends BasicGameState {

	public static final DefaultLogSystem log = new DefaultLogSystem();
	
	private int x, y;
	int c;
	private Map map;
	private Game_Interface game_interface;
	private PathFinder finder;
	private Path path;

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		map = new Map(4, 8);
		game_interface = new Game_Interface();
		finder = new PathFinder(map, 100);
		if(finder.findPath(0, 0, 7, 2)){ //wenn ein pfad gefunden wurde
			path = finder.getPath();
			map.paintPath(path);//später unrelevante methode
		}
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString("x Koordinate: " + x, 10, 20);
		g.drawString("y Koordinate: " + y, 10, 30);
		map.drawmap(100);
		game_interface.render_interface(g);
		g.setBackground(Color.white);
	}

	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		x = Mouse.getX();
		y = Mouse.getY();
	}

	public int getID() {
		return 1;
	}

}
