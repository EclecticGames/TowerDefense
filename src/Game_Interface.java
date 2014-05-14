 import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class Game_Interface {

    public Rectangle tower1;//man kann aus anderen klassen auf die x und y Koordinaten zugreifen    
    public Rectangle tower2;
    public Rectangle tower3;
    public Rectangle detailed_information;
    public Rectangle player_information;

    public Game_Interface() {
        tower1 = new Rectangle(220, 420, 100, 100);
        tower2 = new Rectangle(340, 420, 100, 100);
        tower3 = new Rectangle(460, 420, 100, 100);
        detailed_information = new Rectangle(815,50, 125, 350);
        player_information = new Rectangle(1, 420, 200, 100);
        
    }
    
    public void render_interface(Graphics g){
        g.setColor(Color.gray);
        g.draw(tower1);
        g.draw(tower2);
        g.draw(tower3);
        g.draw(detailed_information);
        g.draw(player_information);
        g.drawString("player.money", player_information.getCenterX()-70, player_information.getCenterY()-30);
        g.drawString("wave.number", player_information.getCenterX()-70, player_information.getCenterY()-15);
        g.drawString("wave.mob_number", player_information.getCenterX()-70, player_information.getCenterY());
    }

}

