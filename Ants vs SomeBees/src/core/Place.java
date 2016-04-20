package core;

import java.util.ArrayList;

/**
 * Represents a location in the game
 *
 * @author Adam & Antonin
 */
public class Place {

	protected String name; // a name we can use for debugging
	protected Place exit; // where you leave this place to
	protected Place entrance; // where you enter this place from
	protected ArrayList<Bee> bees; // bees currently in the place
	protected Ant ant; // ant (singular) currently in the place

	/**
	 * Creates a new place with the given name and exit
	 *
	 * @param name
	 *            The place's name
	 * @param exit
	 *            The place's exit
	 */
	public Place (String name, Place exit) {
		this.name = name;
		this.exit = exit;
		entrance = null;
		bees = new ArrayList<Bee>();
		ant = null;
	}

	/**
	 * Creates a new place with the given name
	 *
	 * @param name
	 *            The place's name
	 */
	public Place (String name) {
		this(name, null);
	}

	/**
	 * Returns the place's ant
	 *
	 * @return the place's ant
	 */
	public Ant getAnt () {
		return ant;
	}

	/**
	 * Returns an array of the place's bees
	 *
	 * @return an array of the place's bees
	 */
	public Bee[] getBees () {
		return bees.toArray(new Bee[0]);
	}

	/**
	 * Returns a nearby bee, up to the maxDistance ahead. If multiple bees are the same distance, a random bee is chosen
	 *
	 * @param minDistance
	 *            The minimum distance away (in Places) a bee can be. A value of -1 means no min distance
	 * @param maxDistance
	 *            The maximum distance away (in Places) a Bee can be. A value of -1 means no max distance
	 * @return A random nearby bee.
	 */
	public Bee getClosestBee (int minDistance, int maxDistance) {
		Place p = this;
		for (int dist = 0; p != null && dist <= maxDistance; dist++) {
			if (dist >= minDistance && p.bees.size() > 0) {
				return p.bees.get((int) (Math.random() * p.bees.size())); // pick a random bee
			}
			p = p.entrance;
		}
		return null;
	}

	/**
	 * Returns the name of the place
	 *
	 * @return the name of the place
	 */
	public String getName () {
		return name;
	}

	/**
	 * Returns the exit of the place
	 *
	 * @return the exit of the place
	 */
	public Place getExit () {
		return exit;
	}

	/**
	 * Sets the entrance to the place
	 *
	 * @param entrance
	 *            The entrance to the place
	 */
	public void setEntrance (Place entrance) {
		this.entrance = entrance;
	}

	/**
	 * Returns the entrance to the place
	 *
	 * @return the entrance to the place
	 */
	public Place getEntrance () {
		return entrance;
	}

	/**
	 * Adds an ant to the place.
	 * If there is already an ant, many possibilities.
	 * For instance, "antInPlace" will be the ant already in place and "pAnt" will be the ant in parameter.
	 * If antInPlace is a containing one, this method tries to add pAnt inside antInPlace.
	 * If pAnt is a containing one, tries to add antInPlace inside pAnt.
	 * Else, this method has no effect.
	 *
	 * @param ant
	 *            The ant to add to the place.
	 * @author Adam & Antonin
	 */
	public boolean addInsect (Ant pAnt) {
		if (this.ant == null) {
				this.ant = pAnt;
				pAnt.setPlace(this);
				return true;
		}else{
			if (this.ant instanceof Containing){
				System.out.println("There is a containing ant in " + this);
				if (!((Containing)this.ant).addContainedAnt(pAnt)){
					System.out.println(this.ant +" can't contain " + pAnt + " :( ...");
					return false;
				}else{
					((Containing)this.ant).getContainedAnt().setPlace(this);
					return true;
				}
			}else
			if (pAnt instanceof Containing){
				if (!((Containing)pAnt).addContainedAnt(this.ant)){
					System.out.println(pAnt +" can't contain " + this.ant + " !");
					return false;
				}else{
					this.ant = pAnt;
					pAnt.setPlace(this);
					return true;
				}
			}else{
				System.out.println("Already an ant in " + this);
				return false;
			}
		}
	}

	/**
	 * Adds a bee to the place
	 *
	 * @param bee
	 *            The bee to add to the place.
	 */
	public void addInsect (Bee bee) {
		bees.add(bee);
		bee.setPlace(this);
	}

	/**
	 * Removes the ant from the place.
	 * If the ant in place contains an ant, let's call the containing one "containingAnt" and the one inside "insideAnt". "pAnt" will be the one in parameter.
	 * If pAnt is insideAnt, this method removes insideAnt from containingAnt.
	 * If pAnt is containingAnt, it removes containingAnt and replaces it with insideAnt.
	 * Else, this method has no effect
	 *
	 * @param pAnt
	 *            The ant to remove from the place.
	 * @author Adam & Antonin
	 */
	public void removeInsect (Ant pAnt) {
		
		if (this.ant == pAnt && this.ant.isRemovable()) {
			this.ant.setPlace(null);
		  if (this.ant instanceof Containing && ((Containing) this.ant).getContainedAnt() != null){
			  this.ant = ((Containing) this.ant).getContainedAnt();
		  }else{
			  this.ant = null;
		  }
		}else 
		if (this.ant instanceof Containing && ((Containing) this.ant).getContainedAnt() == pAnt && ((Containing) this.ant).getContainedAnt().isRemovable()){
			((Containing) this.ant).getContainedAnt().setPlace(null);
			((Containing) this.ant).removeContainedAnt(pAnt);
		}
	}

	/**
	 * Removes the bee from the place. If the given bee is not in this place, this method has no effect
	 *
	 * @param bee
	 *            The bee to remove from the place.
	 */
	public void removeInsect (Bee bee) {
		if (bees.contains(bee)) {
			bees.remove(bee);
			bee.setPlace(null);
		}
		else {
			System.out.println(bee + " is not in " + this);
		}
	}

	@Override
	public String toString () {
		return name;
	}
}
