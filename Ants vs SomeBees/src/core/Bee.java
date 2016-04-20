package core;

/**
 * Represents a Bee
 *
 * @author YOUR NAME HERE
 */
public class Bee extends Insect {

	private static final int DAMAGE = 1;
	private boolean stun;//specifies if a bee is stun;
	private boolean slow;//specifies if a bee is slowed;
	private int slowTimer;//specifies how much turns left before this bee is no more slowed.
	private int slowLoop;//this field assures that slowed bee does nothing 2 turns on 3
	
	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor
	 *            The bee's armor
	 */
	public Bee (int armor) {
		super(armor);
		stun = false;
		slow = false;
		slowTimer = 0;
		slowLoop = 0;
	}
	
	/**
	 * Sets the stun field.
	 * 
	 * @param stun
	 * 					if the bee is stun or not.
	 * @author Adam & Antonin
	 */
	public void setStun(boolean stun){
		this.stun = stun;
	}
	
	/**
	 * Sets the slow field.
	 * 
	 * @param slow
	 * 				if the bee is slow or not.
	 * @author Adam & Antonin
	 */
	public void setSlow(boolean slow){
		this.slow = slow;
		if (slow) slowTimer += 3;
	}
	
	/**
	 * Manages the slow effect.
	 * 
	 * @author Adam & Antonin
	 */
	public void increaseSlowLoop(){
		slowLoop++;
		slowLoop%=3;
		slowTimer--;
		if (slowTimer ==0) slow = false;
	}
	
	/**
	 * Deals damage to the given ant
	 *
	 * @param ant
	 *            The ant to sting
	 */
	public void sting (Ant ant) {
		ant.reduceArmor(DAMAGE);
	}

	/**
	 * Moves to the given place
	 *
	 * @param place
	 *            The place to move to
	 */
	public void moveTo (Place place) {
		this.place.removeInsect(this);
		place.addInsect(this);
	}

	@Override
	public void leavePlace () {
		place.removeInsect(this);
	}

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 *
	 * @return if the bee can advance
	 * @author Adam & Antonin
	 */
	public boolean isBlocked () {
		return (place != null) && (place.getAnt() != null && place.getAnt().isBlockBees());
	}

	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	@Override
	public void action (AntColony colony) {
		if (!stun && (!slow || slowLoop%3==0)){
			if (isBlocked()) {
				sting(place.getAnt());
			}
			else if (armor > 0) {
				moveTo(place.getExit());
			}
			if (slow) increaseSlowLoop();
		}else
			if (stun){
				stun = false;
			}
			if (slow){
				increaseSlowLoop();
			}
				
	}
}
