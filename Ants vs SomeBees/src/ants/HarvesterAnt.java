package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food.
 * It cannot attack.
 *
 * @author Adam & Antonin
 */
public class HarvesterAnt extends Ant {

	/**
	 * Creates a new Harvester Ant.
	 * Armor: 1, Food: 2.
	 * 
	 * @author Adam & Antonin
	 */
	public HarvesterAnt () {
		super(1,2);
	}

	/**
	 * @author Adam & Antonin
	 */
	public void action (AntColony colony) {
		colony.increaseFood(1);
	}
}
