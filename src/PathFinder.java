import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;

public class PathFinder {

//map ist so aufgebaut:
// x0,y0  x1,y0  x2,y0  x3,y0
// x0,y1  x1,y1  x2,y1  x3,y1
// x0,y2  x1,y2  x2,y2  x3,y2
// x0,y3  x1,y3  x2,y3  x3,y3

	private Map map; //für den anfang noch public, würde ich später in private ändern
	private Path path;
	private int pathLength;
	private int maxPathLength;
	
	/**
	 * 
	 * @param map TileBasedMap in which the Path should be searched
	 * @param maxPathLength the max Length the path should have
	 */
	public PathFinder(Map map, int maxPathLength){
		this.map = map;
		this.maxPathLength = maxPathLength;
	}
	
	/**
	 * @return returns the length of the path
	 */
	public int getPathLength(){
		return pathLength;
	}
	
	/**
	 * Returns the searched path
	 * @return The path searched before
	 */
	public Path getPath(){
		return path;
	}
	
	/**
	 * 
	 * @param sx startX Coordinate
	 * @param sy startY Coordinate
	 * @param tx targetX Coordinate
	 * @param ty targetY Coordinate
	 * @return boolean whether path found or not
	 */
	public boolean findPath(int sx, int sy, int tx, int ty){
		AStarPathFinder finder = new AStarPathFinder(map, maxPathLength, false); //tilebasedMap, maxPathLength, allowDiagonal movement
		path = finder.findPath(null, sx, sy, tx, ty);
		
		if(path ==null){
			Game.log.warn(" no Path found!!");
			return false;
		}
		
		pathLength = path.getLength();
		return true;
	}
}
