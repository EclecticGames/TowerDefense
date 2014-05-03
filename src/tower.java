
public class tower {//super Klasse für die Tower

	private double damage;
	private double price;
	
	public tower(double damage, double price){
		this.setDamage(damage);
		this.setPrice(price);
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
	
	
	
}
