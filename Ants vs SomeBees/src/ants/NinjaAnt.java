package ants;

import core.AntColony;
import core.Bee;

/**
 * An ant who is a NINJA !
 * (Can't be attacked and doesn't block bees.)
 *
 * @author Adam & Antonin
 * 
 */
public class NinjaAnt extends ThrowerAnt {
	
	/**
	 * Creates a new Scuba Thrower Ant.
	 * Armor: 1, Food: 6, Damage: 1
	 * 
	 * @author Adam & Antonin
	 */
	public NinjaAnt() {
		super();
		setFoodCost(6);
		setBlockBees(false);
	}
	
	/**
	 * Returns the targets for this ant
	 *
	 * @return A bee to target
	 */
	public Bee[] getTargets(){
		return place.getBees();
	}
	
	/**
	 * Attack bees.
	 * 
	 * @param bees
	 * 			The attacked bees.
	 * @author Adam & Antonin
	 */
	public void attackMany(Bee[] bees){
		for (Bee bee : bees){
			bee.reduceArmor(damage);
		}
	}
	
	/**
	 * @author Adam & Antonin
	 */
	public void action (AntColony colony) {
		attackMany(getTargets());
	}

}
