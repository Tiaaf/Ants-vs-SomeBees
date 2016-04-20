package ants;

import java.util.ArrayList;


import core.Ant;
import core.AntColony;
import core.Containing;
import core.Place;
import core.QueenPlace;


/**
 * The royal ant who double its allies'damage.
 * 
 * @author Adam & Antonin
 */
public class QueenAnt extends ScubaThrowerAnt {
	

	private ArrayList<Ant> buffedAnts;	
	private boolean isOriginalQueen;
	public static int queenNumber = -1; // When the game starts, an instance of each type of ant is created. So we need to start at -1.
	/**
	 * Creates a new Queen Ant.
	 * Armor : 1, Food : 6, Damage : 1, watersafe.
	 * @param armor
	 * @param foodCost
	 * @author Adam & Antonin
	 */
	public QueenAnt() {
		super();
		setFoodCost(6);
		buffedAnts = new ArrayList<Ant>();
		queenNumber += 1;
		if (queenNumber == 1) {
			isOriginalQueen = true;
			setRemovable(false);
		}else{
			isOriginalQueen = false;
		}
	}

	/**
	 * Double the damage of nearby ants.
	 * 
	 * @author Adam & Antonin
	 */
	private void doubleDamageAura(){
		Place entrance = this.getPlace().getEntrance();
		Place exit = this.getPlace().getExit();
		if (entrance != null && entrance.getAnt()!= null){
			Ant buffedAnt = entrance.getAnt();
			if (buffedAnt instanceof Containing && ((Containing) buffedAnt).getContainedAnt() != null){
				buffedAnt = ((Containing) buffedAnt).getContainedAnt();
			}
			if (!buffedAnts.contains(buffedAnt)){
				buffedAnt.setDamage(buffedAnt.getDamage()*2);
				buffedAnts.add(buffedAnt);
			}
		}
		if (exit.getAnt()!= null ){
			Ant buffedAnt = exit.getAnt();
			if (buffedAnt instanceof Containing && ((Containing) buffedAnt).getContainedAnt() != null){
				buffedAnt = ((Containing) buffedAnt).getContainedAnt();
			}
			if (!buffedAnts.contains(buffedAnt)){
				buffedAnt.setDamage(buffedAnt.getDamage()*2);
				buffedAnts.add(buffedAnt);
			}
		}
	}
	
	/**
	 * 
	 * Redefine the queenPlace into an instance of QueenPlace, 
	 * containing the former queenPlace and the current location of the Queen.
	 * 
	 * @param colony
	 * 			The instance of ants'colony the queen lives in. 
	 * 
	 * @author Adam & Antonin
	 */
	public void redefineQueenPlace(AntColony colony){
		
		colony.setQueenPlace(new QueenPlace(colony.getQueenPlace().getName(), colony.getQueenPlace(),this.getPlace()));
		
	}
	
	public void action(AntColony colony) {
		if (isOriginalQueen){
			doubleDamageAura();
			redefineQueenPlace(colony);
		}else{
			reduceArmor(getArmor());
			colony.increaseFood(getFoodCost());
			System.out.println("This is a false queen !!");
		}
		
	}

}
