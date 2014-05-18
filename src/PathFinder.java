
import java.io.FileNotFoundException;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;


public class PathFinder {
	public TestMap testmap;
	public PathFinder(){
		
//		Map map = new Map(4, 8);
		testmap = new TestMap(4, 8);
		
		AStarPathFinder finder = new AStarPathFinder(testmap, 100, false);
		// hier wie rechts beschrieben eingeben zum testen
		//								 sx sy tx ty
		Path path = finder.findPath(null, 0, 0, 7, 0);
		//map ist so aufgebaut:
		// x0,y0  x1,y0  x2,y0  x3,y0
		// x0,y1  x1,y1  x2,y1  x3,y1
		// x0,y2  x1,y2  x2,y2  x3,y2
		// x0,y3  x1,y3  x2,y3  x3,y3
		
		int length = path.getLength();
        System.out.println("Found path of length: " + length + ".");

        int x,y;
        for(int i = 0; i < length; i++) {
        	x = path.getX(i);
        	y = path.getY(i);
        	testmap.map[y][x] = "2";
            System.out.println("Move to: x" + x + ", y" + y + ".");
        }
	}
	
}
