/**
 * 
 */
package ants;

import core.Ant;
import core.AntColony;
import core.Containing;

/**
 * Creates an ant who protects closely its allies.
 * 
 * @author Adam & Antonin
 */
public class BodyguardAnt extends Ant implements Containing {
	
	private Ant containedAnt;
	
	/**
	 * Creates a new Bodyguard Ant.
	 * Armor: 2, Food: 5.
	 * 
	 * @author Adam & Antonin
	 */
	public BodyguardAnt() {
		super(2,5);
		containedAnt = null;
	}

	/**
	 * Tries to add an ant inside this ant
	 * 
	 * @param pAnt
	 * 			  The ant to be added.
	 * @return whether the ant has been added.
	 * @author Adam & Antonin
	 */
	public boolean addContainedAnt(Ant pAnt) {
		if (containedAnt == null && !(pAnt instanceof BodyguardAnt)){
			containedAnt = pAnt;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Tries to remove the contained ant.
	 * 
	 * @param pAnt
	 * 			  The ant to be removed.
	 * @return whether the ant has been removed.
	 * @author Adam & Antonin
	 */
	public boolean removeContainedAnt(Ant pAnt) {
		if (containedAnt != null && containedAnt == pAnt){
			containedAnt = null;
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Returns the ant inside this ant.
	 * 
	 * @return the ant inside this ant.
	 * @author Adam & Antonin
	 */
	public Ant getContainedAnt() {
		return containedAnt;
	}

	/**
	 * @author Adam & Antonin
	 */
	public void action(AntColony colony) {
	}

}
