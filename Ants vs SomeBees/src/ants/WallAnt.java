package ants;

import core.Ant;
import core.AntColony;

/**
 * A ant that just defends.
 * 
 * @author Adam & Antonin
 *
 */
public class WallAnt extends Ant {
	
	/**
	 * Creates a new Wall Ant.
	 * Armor :4, Food:4.
	 * 
	 * @author Adam & Antonin
	 */
	public WallAnt() {
		super(4,4);
	}

	/**
	 * @author Adam & Antonin
	 */
	public void action(AntColony colony) {
	}

}
