
public class Mob {//super Klasse für die Mobs

	private double life;
	private double speed;
	
	public Mob(double life, double speed){
		this.life = life;
		this.speed = speed;
	}
	
	public double getLife() {
		return life;
	}
	public void setLife(double life) {
		this.life = life;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
