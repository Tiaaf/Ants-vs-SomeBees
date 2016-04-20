package ants;

import core.Bee;

/**
 * An ants who throws leaves at bees from a close range.
 * 
 * @author Adam & Antonin
 */
public class ShortThrowerAnt extends ThrowerAnt {
	
	/**
	 * Creates a new Short Thrower Ant
	 * Armor : 1, Food : 3 , Damage : 1.
	 * 
	 * @author Adam & Antonin
	 */
	public ShortThrowerAnt() {
		super();
		setFoodCost(3);
	}
	
	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 * @author Adam & Antonin
	 */
	public Bee getTarget() {
		return place.getClosestBee(0, 2);
	}

}
