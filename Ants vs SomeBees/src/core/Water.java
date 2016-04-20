package core;

/**
 * Represents a location flooded with water in the game.
 * 
 * @author Adam & Antonin
 */
public class Water extends Place {
	
	
	/**
	 * Creates a new moat(water place) with the given name and exit.
	 * 
	 * @param name
	 * 			  The moat's name.
	 * @param exit
	 * 			  The moat's exit.
	 * @author Adam & Antonin
	 */
	public Water(String name, Place exit) {
		super(name, exit);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a new moat(water place) with the given name.
	 *
	 * @param name
	 *            The moat's name
	 * @author Adam & Antonin
	 */
	public Water(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Adds an ant to the moat. If there is already an ant, this method has no effect
	 * The ant must be waterSafe.
	 * 
	 * @param ant
	 *            The ant to add to the place.
	 * @author Adam & Antonin
	 */
	public boolean addInsect (Ant ant) {
		if (this.ant == null && ant.isWaterSafe()) {
			this.ant = ant;
			ant.setPlace(this);
			return true;
		}
		else if (this.ant != null){
			System.out.println("Already an ant in " + this); // report error
			return false;
		}
		else{
			System.out.println("This ant cannot be on a moat !");
			return false;
		}
	}

}
