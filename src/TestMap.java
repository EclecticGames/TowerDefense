import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class TestMap implements TileBasedMap{

	public TestMap() throws FileNotFoundException, SlickException{
		TiledMap tiledmap = new TiledMap(new FileInputStream("ressources/maps/map.map"));
		
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
		return 4;
	}

	@Override
	public int getWidthInTiles() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
