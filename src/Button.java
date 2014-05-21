import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//muss wahrscheinlich später noch ein animatedButton gemacht werden, falls diese sich bewegen sollen
public class Button {

	/**
	 * The button is ACTIVE, when it is clicked.
	 */
	public final static int ACTIVE = 0;
	/**
	 * The button is INACTIVE, when nothing happens with it. For example when initiated.
	 */
	public final static int INACTIVE = 1;
	/**
	 * The button is DISABLED, when it can´t be clicked.
	 */
	public final static int DISABLED = 2;
	
	private int status;
	
	private Image[] buttonImages;
	private int x, y;
	private int width, height;
	
	/**
	 * 
	 * @param active The Image when the Button is active (pressed). The images should all be the same size.
	 * @param inactive The Image when the Button is inavtive (notPressed)
	 * @param disabled The Image when the button is disabled (notClickable) 
	 * @param x The x coordinate where the Button should be drawn
	 * @param y The y coordinate where the Button should be drawn
	 */
	public Button(Image active, Image inactive, Image disabled, int x, int y){
		buttonImages = new Image[3];
		buttonImages[ACTIVE] = active;
		buttonImages[INACTIVE] = inactive;
		buttonImages[DISABLED] = disabled;
		width = inactive.getWidth();
		height = inactive.getHeight();
		status = INACTIVE;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * can throw a SlickException if path is incorrect
	 * @param pathToActive
	 * @param pathToInactive
	 * @param pathToDisabled
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public Button(String pathToActive, String pathToInactive, String pathToDisabled, int x, int y) throws SlickException{
		this(new Image(pathToActive), new Image(pathToInactive), new Image(pathToDisabled), x, y);
	}
	
	public void draw(){
		buttonImages[status].draw(x, y);
	}
	
	public boolean isMouseOver(int mouseX, int mouseY){
		boolean isInX = (mouseX >= x) && (mouseX <= ( x + width ) );
		boolean isInY = (mouseY <= Main.screenHeight - y) && (mouseY >= ( (Main.screenHeight - y) - height ) );
		return isInX && isInY;
	}
	
//	/**
//	 * Set the button as disabled or not
//	 * @param DISABLED If true, the button is disabled, if false the button is inactive
//	 */
//	public void setDisabled(boolean isDisabled){
//		if(buttonImages[DISABLED] != null){
//			status = isDisabled ? DISABLED : INACTIVE;
//		}
//	}
	
	public void setState(int status){
		this.status = status;
	}
	
}
