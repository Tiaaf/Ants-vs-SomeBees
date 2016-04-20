package ants;

import ants.ThrowerAnt;

/**
 * A thrower ant who can be on moat.
 *
 * @author Adam & Antonin
 * 
 */
public class ScubaThrowerAnt extends ThrowerAnt {
	
	/**
	 * Creates a new Scuba Thrower Ant.
	 * Armor: 1, Food: 5, Damage: 1, watersafe.
	 * 
	 * @author Adam & Antonin
	 */
	public ScubaThrowerAnt() {
		super();
		setFoodCost(5);
		setWaterSafe(true);
	}
	
	

}
