import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class Map implements TileBasedMap {
	
	private PathFinder finder;
	private Path path;
	
	Image visited;//nur vorrübergehend
	Image gras;
	private String [][] map;
	private int width;
	private int height;
	private final int blocksize;
	private final int maxPathLength = 100;
	
	public Map(int mapsizeY, int mapsizeX, int blocksize){
		finder = new PathFinder(this, maxPathLength);
		
		this.blocksize = blocksize;
		this.height = mapsizeY;
		this.width = mapsizeX;
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
	
	
	public void drawmap(){
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
//	//#########################################################################################################
	/**
	 * trägt die koordinaten des pfades ein, ist nur zum demonstrieren am anfang, soll später raus
	 * die Methoder ersetzt einfach Bilder durch andere, da wo der Pfad langgeht
	 */
	public void paintPath(Path path){
        for(int i = 0; i < path.getLength(); i++) {
        	int x = path.getX(i);
        	int y = path.getY(i);
        	map[y][x] = "2";
            Game.log.info("Move to: x" + x + ", y" + y + ".");
        }
	}
//	//#########################################################################################################
	
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

	/**
	 * 
	 * @param sx startX Coordinate
	 * @param sy startY Coordinate
	 * @param tx targetX Coordinate
	 * @param ty targetY Coordinate
	 * @return the Path that was found. If there is no Path an exception is thrown
	 * @throws Exception can throw exceptino if no path is found
	 */
	public Path findPath(int sx, int sy, int tx, int ty) throws Exception{ 
		if(finder.findPath(sx, sy, tx, ty)){ //wenn ein pfad gefunden wurde
			path = finder.getPath();
		}
		if(path == null){
			throw new Exception("No path was found.");
		}
		return path;
	}
	
	/**
	 * 
	 * @return Returns the path of the Pathfinder
	 */
	public Path getPath(){
		return path;
	}
}
