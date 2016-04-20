package core;

/**
 * 
 *Interface for containing ants ie which can contain ants.
 * 
 *@author Adam & Antonin
 */
public interface Containing {
	
	/**
	 * Tries to add an ant in the containing ant.
	 * 
	 * @param the ant to be added.
	 * @return if the ant has been added.
	 * @author Adam & Antonin
	 */
	public boolean addContainedAnt(Ant ant);
	
	/**
	 * Tries to remove the ant from the containing ant.
	 * 
	 * @param the ant to be removed.
	 * @return if the ant has been removed.
	 * @author Adam & Antonin
	 */
	public boolean removeContainedAnt(Ant ant);
	
	/**
	 * Return the ant in the containing ant.
	 * 
	 * @return the ant in the containing ant.
	 * @author Adam & Antonin
	 */
	public Ant getContainedAnt();
}
