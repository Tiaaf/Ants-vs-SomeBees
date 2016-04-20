
package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant that explodes before dying.
 * 
 * @author Adam & Antonin
 *
 */
public class FireAnt extends Ant {
	
	private int damage = 3;
	
	/**
	 *Creates a Fire Ant.
	 *Armor:1, Food:4, Damage:3.
	 *
	 *@author Adam & Antonin
	 */
	public FireAnt() {
		super(1,4);
	}
	
	/**
	 * Returns the victims of the explosion.
	 * 
	 * @return the bees which will take damage upon the death of this ant.
	 * @author Adam & Antonin
	 */
	public Bee[] getTargets(){
		return this.getPlace().getBees();
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
	public void leavePlace(){
		attackMany(getTargets());
		super.leavePlace();
	}
	
	/**
	 * @author Adam & Antonin
	 */
	public void action(AntColony colony) {
			
	}

}
