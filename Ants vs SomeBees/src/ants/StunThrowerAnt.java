package ants;

import core.AntColony;

/**
 * An ant who stun bees.
 * 
 * @author Adam & Antonin
 */
public class StunThrowerAnt extends ThrowerAnt {
	
	/**
	 * Creates a Stun Thrower Ant.
	 * Armor: 1, Food: 6, Damage: 1
	 */
	public StunThrowerAnt(){
		super();
		setFoodCost(6);
	}
	
	public void action (AntColony colony){
		if (getTarget() != null) {
			getTarget().setStun(true);
		}
	}
}
