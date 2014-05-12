
import java.io.FileNotFoundException;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;


public class PathFinder {
	
	public PathFinder(){
		
//		Map map = new Map(4, 8);
		TestMap map = null;
		try {
			map = new TestMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AStarPathFinder finder = new AStarPathFinder(map, 100, false);
		Path path = finder.findPath(null, 0, 0, 4, 8);
		
		int length = path.getLength();
        System.out.println("Found path of length: " + length + ".");

        for(int i = 0; i < length; i++) {
            System.out.println("Move to: " + path.getX(i) + "," + path.getY(i) + ".");
        }
	}
}
