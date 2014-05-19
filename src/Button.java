import org.newdawn.slick.Image;

//muss wahrscheinlich später noch ein animatedButton gemacht werden, falls diese sich bewegen sollen
public class Button {

	private final int active = 0;
	private final int inactive = 1;
	private final int disabled = 2;
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
		buttonImages[this.active] = active;
		buttonImages[this.inactive] = inactive;
		buttonImages[this.disabled] = disabled;
		width = inactive.getWidth();
		height = inactive.getHeight();
		status = this.inactive;
		this.x = x;
		this.y = y;
	}
	
	public void draw(){
		buttonImages[status].draw(x, y);
	}
	
//	public boolean 
	
	/**
	 * Set the button as disabled or not
	 * @param disabled If true, the button is disabled, if false the button is inactive
	 */
	public void setDisabled(boolean isDisabled){
		if(isDisabled){
			status = disabled;
		}else{
			status = inactive;
		}
	}
	
}
