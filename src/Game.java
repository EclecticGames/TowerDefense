import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
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
	private String [][] map = new String[20][20];
	int c;
	Image gras;

	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		gras = new Image("ressources/images/gras.bmp");
		try {
			FileReader file = new FileReader("ressources/maps/map.map");
			BufferedReader br = new BufferedReader(file);
			String line = br.readLine();
			int row = 0;
			while(line != null)
			{
				map[row] = line.split("\t");
				line = br.readLine();
				row++;
			}
		


			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.drawString("x Koordinate: " + x, 10, 20);
		g.drawString("y Koordinate: " + y, 10, 30);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.println("i: "+i+"/ j: "+j);
				if(map[i][j].equals("0")){
					gras.draw(i*5,j*5);
					System.out.println("test");
				}
			}
		}
		
		
	}

	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		Input input = gc.getInput();
		x = Mouse.getX();
		y = Mouse.getY();
		if (input.isMousePressed(0)) {

		}
	}

	public int getID() {
		return 1;
	}

}
