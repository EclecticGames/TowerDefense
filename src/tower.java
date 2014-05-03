
public class tower {//super Klasse für die Tower

	private double damage;
	private double price;
	private double costs;
	private double range;//Angriffsreichweite
	private double speed; //Angriffsgeschwindigkeit
	
	public tower(double damage, double costs, double range, double speed){
		this.setDamage(damage);
		this.setCosts(costs);
		this.setPrice((costs/2));
		this.setRange(range);
		this.setSpeed(speed);
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getCosts() {
		return costs;
	}

	public void setCosts(double costs) {
		this.costs = costs;
	}
	
	
	
}
