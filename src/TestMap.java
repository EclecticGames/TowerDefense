import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class TestMap implements TileBasedMap {

	Image gras;
	Image visited; //nur zum demonstrieren
	String [][] map;
	int width;
	int height;
	
	public TestMap(int mapsizeY, int mapsizeX){
		height = mapsizeY;
		width = mapsizeX;
		try {
			gras = new Image("ressources/images/gras.png");
			visited = new Image("ressources/images/visited.png");
			map = new String[width][height];
			FileReader file = new FileReader("ressources/maps/map.map");
			BufferedReader br = new BufferedReader(file);
			String line = br.readLine();
			int row = 0;
			while(line != null && row < height)
			{
				map[row] = line.split("\t");
				line = br.readLine();
				row++;
			}
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void drawmap(int blocksize){
		for (int i = 0; i < height; i++) {//durchläuft von oben links nach oben rechts, dann eine zeile tiefer
			for (int j = 0; j < width; j++) {
				if(map[i][j].equals("0")){
					gras.draw(j*blocksize,i*blocksize);
				}else if(map[i][j].equals("2")){
					visited.draw(j*blocksize,i*blocksize);
				}
			}
		}
		
	}
	
	public boolean blocked(PathFindingContext context, int x, int y) {
		boolean blocked = false;
		if(Integer.parseInt(map[y][x]) == 1){
			blocked = true;
		}
		return blocked;
	}

	@Override
	public float getCost(PathFindingContext context, int x, int y) {
		return 1;
	}

	@Override
	public int getHeightInTiles() {
		return height;
	}

	@Override
	public int getWidthInTiles() {
		return width;
	}

	@Override
	public void pathFinderVisited(int x, int y) {
//		ist zum debuggen
		//Game.log.info("pathfinder visited tile x:"+x+" , y:"+y);
	}

}
