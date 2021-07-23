package org.sayantan.assesment.DiceRoll;

import java.util.Random;

public class Dice {
	
    private int myRollCount;   // # times rolled
    private int mySides;       // # sides
    private Random myRandGen;  // the random number generator

    public Dice()
    {
    	this(6);
    }
    
    public Dice(int sides)
    {
		myRollCount = 0;
		mySides = sides;
		myRandGen = new Random();
    }
    
    public int roll()
    {
		myRollCount++; 
		return myRandGen.nextInt(mySides) + 1;
    }
    
    /*
     * Returns number of sides of die
     * @return number of sides of this dice object
     */
    
    public int numSides()
    {
    	return mySides;
    }

    /*
     * Returns number of times this die object has been rolled.
     * @return number of times dice object rolled
     */
    
    public int numRolls()
    {
    	return myRollCount;
    }

    /**
     * Returns a string representing this Dice object
     */

    public String toString()
    {
    	return "# sides: " + numSides() + " # rolls: " + numRolls();
    }

}
