package core;

import java.util.ArrayList;

import core.Bee;

/**
 * Represents the Queen's place and its current position.
 * 
 * @author Adam & Antonin
 */
public class QueenPlace extends Place {
	
	private Place currentQueenPlace;
	
	/**
	 * Creates a new Queen Place with the given name, exit and current queen's location.
	 * 
	 * @param name
	 * 			  The place's name.
	 * @param queenPlace
	 * 			  The queen place.
	 * @param currentQueenPlace
	 * 			  The current queen place.
	 * @author Adam & Antonin
	 */
	public QueenPlace(String name, Place queenPlace , Place currentQueenPlace) {
		super(name);
		this.bees = queenPlace.bees;
		this.currentQueenPlace = currentQueenPlace;
	}
	
	
	public Bee[] getBees(){
		ArrayList<Bee> beesInThroneRoom  = this.bees;
		ArrayList<Bee> beesOnQueen  = currentQueenPlace.bees;
		beesInThroneRoom.addAll(beesOnQueen);
		return beesInThroneRoom.toArray(new Bee[0]);
		
	}
	

}
