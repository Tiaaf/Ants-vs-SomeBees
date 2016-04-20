package ants;

import core.AntColony;

/**
 * An ant who slows bees.
 *
 * @author Adam & Antonin
 */
public class SlowThrowerAnt extends ThrowerAnt {
	
	/**
	 * Creates a new Slow Thrower Ant.
	 * Armor: 1, Food: 4, Damage: 0
	 * 
	 * @author Adam & Antonin
	 */
	public SlowThrowerAnt() {
		super();
		setDamage(0);
	}
	
	public void action(AntColony colony){
		if (getTarget() != null){
			getTarget().setSlow(true);
		}
	}

}
