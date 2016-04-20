package core;

/**
 * Represents an insect (e.g., an Ant or a Bee) in the game
 *
 * @author Adam & Antonin
 */
public abstract class Insect {

	protected Place place; // insect's current location
	protected int armor; // insect's current armor 
	protected int damage; // insect's current damage

	/**
	 * Creates a new Insect with the given armor in the given location
	 *
	 * @param armor
	 *            The insect's armor
	 * @param place
	 *            The insect's location
	 */
	public Insect (int armor, Place place) {
		if (armor <= 0) {
			throw new IllegalArgumentException("Cannot create an insect with armor of 0");
		}
		setArmor(armor);
		this.place = place;
	}
	
	

	/**
	 * Creates an Insect with the given armor. The insect's location is null
	 *
	 * @param armor
	 *            The insect's armor
	 */
	public Insect (int armor) {
		this(armor, null);
	}
	
	/**
	 * Return's the insect's current location
	 *
	 * @return the insect's current location
	 */
	public Place getPlace () {
		return place;
	}

	/**
	 * Sets the insect's current location
	 *
	 * @param place
	 *            The insect's current location
	 */
	public void setPlace (Place place) {
		this.place = place;
	}

	/**
	 * Returns the insect's current armor
	 *
	 * @return the insect's current armor
	 */
	public int getArmor () {
		return armor;
	}
	
	/**
	 * Sets the insect's armor
	 * 
	 * @param armor
	 * 			the insect's armor
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	/**
	 * Returns the insect's current damage
	 *
	 * @return the insect's current damage
	 */
	public int getDamage(){
		return damage;
	}
	
	/**
	 * Sets the insect's damage
	 * 
	 * @param damage
	 * 			the insect's damage
	 */
	public void setDamage(int damage){
		this.damage = damage;
	}
	
	/**
	 * Reduces the insect's current armor (e.g., through damage)
	 *
	 * @param amount
	 *            The amount to decrease the armor by
	 */
	public void reduceArmor (int amount) {
		armor -= amount;
		if (armor <= 0) {
			System.out.println(this + " ran out of armor and expired");
			leavePlace();
		}
	}

	/**
	 * Has the insect move out of its current location. Abstract in case the insect takes action when it leaves
	 */
	public abstract void leavePlace ();

	/**
	 * The insect takes an action on its turn
	 *
	 * @param colony
	 *            The colony in which this action takes place (to support wide-spread effects)
	 */
	public abstract void action (AntColony colony);

	@Override
	public String toString () {
		return this.getClass().getName() + "[" + armor + ", " + place + "]"; // supports inheritance!
	}
}
