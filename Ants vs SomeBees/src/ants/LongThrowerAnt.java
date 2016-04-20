package ants;

import core.AntColony;
import core.Bee;

/**
 * An ants who throws leaves at bees from a long range.
 * 
 * @author Adam & Antonin
 */
public class LongThrowerAnt extends ThrowerAnt {
	
	/**
	 * Creates a new Long Thrower Ant
	 * Armor : 1, Food : 3 , Damage : 1.
	 * 
	 * @author Adam & Antonin
	 */
	public LongThrowerAnt() {
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
		return place.getClosestBee(4, AntColony.MAX_TUNNEL_LENGTH);
	}

}
