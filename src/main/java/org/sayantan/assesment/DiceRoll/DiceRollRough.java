package org.sayantan.assesment.DiceRoll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class DiceRollRough {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		int numberOfRolls=100;
		int rollCount=1;
		ArrayList<Integer> rollResults = new ArrayList<Integer>();
		
		int sides=6;//number of sides in dices minimum 4
		int numberOfDice=3;//Default one
		
		while(rollCount<=numberOfRolls) {
			
			/*dice1 = (int)(Math.random()*sides) + 1;
			dice2 = (int)(Math.random()*sides) + 1;
			dice3 = (int)(Math.random()*sides) + 1;*/
			
			int sumOfDices=0;
			
			for (int i = 0; i < numberOfDice ; i++) {
				sumOfDices = sumOfDices + new Dice(sides).roll();
				
			}        
	        System.out.println("Your total roll is 	" + sumOfDices + " >>>>  For Roll Count "+ rollCount);	        
	        rollResults.add(sumOfDices);
	        
	        rollCount+=1;
		}
		
		System.out.println(rollResults);
		
		//hashmap to store frequency of dice roll sum
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(Integer i : rollResults) {
			Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
		}
		
        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
            System.out.println("Dice Count " + val.getKey() + " "
                               + "occurs"
                               + ": " + val.getValue() + " times");
        }
       
	}

}
