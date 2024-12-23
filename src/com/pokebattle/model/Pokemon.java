package src.com.pokebattle.model;

public class Pokemon {
	
	// Attributes
	protected String name;
	private String defendType;
	private String attackType;
	private int power;
	private double hp;
	
	// Constructor
	public Pokemon(String name, String defendType, String attackType,int power, double hp) {
		this.name = name;
		this.defendType = defendType;
		this.attackType = attackType;
		this.power = power;
		this.hp = hp;
		}
	
	// Getters
	public String getName() {
		return name;
	}

	public String getDefend() {
		return defendType;
	}

	public String getAttack() {
		return attackType;
	}

	public int getPower() {
		return power;
	}

	public double getHp() {
		return hp;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setDefend(String defendType) {
		this.defendType = defendType;
	}

	public void setAttack(String attackType) {
		this.attackType = attackType;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	// Methods
	public String battleCry() {
        return name + " roars!\n";
    }

	// To string Override
	@Override
	public String toString() {
		return name + "\n     Stats: [defend=" + defendType + ", attack=" + attackType + ", power=" + power + ", hp=" + hp + "]";
	}	
}