import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.*;

public class Game extends BasicGameState {

	private int x, y;
	int c;
	private Map map;
	private Game_Interface game_interface;
	PathFinder finder;

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		map = new Map(4, 8);
		game_interface = new Game_Interface();
		finder = new PathFinder(); //auskommentieren wenn nicht benutzt wird, genau wie deklaration
		//wenn jemand anderen pfad testen will, muss er im konstruktor die start und end parameter austauschen
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString("x Koordinate: " + x, 10, 20);
		g.drawString("y Koordinate: " + y, 10, 30);
//		map.drawmap(100);
		finder.testmap.drawmap(100); //zum testen des pathfinders, für weiterentwicklung einfach kommentar tauschen
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
