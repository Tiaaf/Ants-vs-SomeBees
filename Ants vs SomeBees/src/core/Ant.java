package core;

/**
 * A class representing a basic Ant
 *
 * @author Adam & Antonin
 */
public abstract class Ant extends Insect {

	protected int foodCost; // the amount of food needed to make this ant
	protected boolean waterSafe; //specifies if the ant can be on a water tile.
	protected boolean blockBees; //specifies if the ant can block bees.
	protected boolean removable; //specifies if the ant can be removed.
	
	/**
	 * Creates a new Ant.
	 * 
	 * @param armor
	 * 			The armor of the ant.
	 * @param foodCost
	 * 			The food cost of the ant.
	 * @author Adam & Antonin
	 * 	
	 */
	public Ant (int armor, int foodCost) {
		super(armor, null);
		this.foodCost = foodCost;
		waterSafe = false;
		blockBees = true;
		removable = true;
	}

	/**
	 * Returns the ant's food cost
	 *
	 * @return the ant's good cost
	 */
	public int getFoodCost () {
		return foodCost;
	}
	
	/**
	 * Sets the ant's food cost.
	 * 
	 * @param foodCost
	 * 			The ant's food cost.
	 * @author Adam & Antonin
	 */
	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}
	
	/**
	 * Return if the ant is safe on water.
	 * 
	 * @return whether the ant is safe on water.	
	 * @author Adam & Antonin
	 */
	public boolean isWaterSafe() {
		return waterSafe;
	}
	

	/**
	 * Sets the ant's waterSafe field.
	 * 
	 * @param waterSafe
	 * 					whether the ant is safe on water.
	 * @author Adam & Antonin	   
	 */
	public void setWaterSafe(boolean waterSafe) {
		this.waterSafe = waterSafe;
	}
	
	/**
	 * Return if the ant blocks bees.
	 * 
	 * @return whether the ant blocks bees.	
	 * @author Adam & Antonin
	 */
	public boolean isBlockBees() {
		return blockBees;
	}
	
	
	/**
	 * Sets the ant's blockBees field.
	 * 
	 * @param blockBees
	 * 					whether the ant blocks bees.
	 * @author Adam & Antonin	   
	 */
	public void setBlockBees(boolean blockBees) {
		this.blockBees = blockBees;
	}
	
	/**
	 * Return if the ant can be removed.
	 * 
	 * @return whether the ant can be removed.	
	 * @author Adam & Antonin
	 */
	public boolean isRemovable() {
		return removable;
	}
	
	/**
	 * Sets the ant's removable field.
	 * 
	 * @param removable
	 * 					whether the ant can be removed.
	 * @author Adam & Antonin	   
	 */
	public void setRemovable(boolean removable) {
		this.removable = removable;
	}


	/**
	 * Removes the ant from its current place
	 */
	@Override
	public void leavePlace () {
		place.removeInsect(this);
	}

}
