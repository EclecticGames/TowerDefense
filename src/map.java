import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class map implements TileBasedMap {

	Image gras;
	private String [][] map;
	int x;
	int y;
	
	public map(int mapsizeY, int mapsizeX){
		x = mapsizeY;
		y = mapsizeX;
		try {
			gras = new Image("ressources/images/gras.png");
			map = new String[x][y];
			FileReader file = new FileReader("ressources/maps/map.map");
			BufferedReader br = new BufferedReader(file);
			String line = br.readLine();
			int row = 0;
			while(line != null && row < x)
			{
				map[row] = line.split("\t");
				line = br.readLine();
				row++;
				System.out.println(row);
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
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(map[i][j].equals("0")){
					gras.draw(j*blocksize,i*blocksize);
				}
			}
		}
		
	}
	
	@Override
	public boolean blocked(PathFindingContext arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getCost(PathFindingContext arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeightInTiles() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidthInTiles() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}

}
