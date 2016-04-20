package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * A ant which eats his enemies.
 *
 *@author Adam & Antonin
 */
public class HungryAnt extends Ant {
	
	/**
	 * If above 0, this ant is digesting.
	 */
	private int digestion = 0;
	
	/**
	 * Creates a new Hungry Ant.
	 * Armor:1, Food: 4.
	 * 
	 * @author Adam & Antonin
	 */
	public HungryAnt() {
		super(1,4);
	}
	
	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 * @author Adam & Antonin
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 0);
	}
	
	/**
	 * Kills a bee then rests 3 turns.
	 * 
	 * @param bee
	 * 			The eaten bee.
	 */
	public void eat(Bee bee){
		
		if (digestion == 0 && bee != null) {
			bee.reduceArmor(bee.getArmor());
			digestion = 3;
			
		}else if (digestion >0) {
			digestion -= 1;
		};
	}

	/**
	 * @author Adam & Antonin
	 */
	public void action(AntColony colony) {
		eat(getTarget());
	}

}
