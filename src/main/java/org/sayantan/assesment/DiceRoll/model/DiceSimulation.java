package org.sayantan.assesment.DiceRoll.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class DiceSimulation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int dices;
    private int sides;
    private int rolls;

    
    public DiceSimulation() {
    	
    }
    
	public DiceSimulation(int dices, int sides, int rolls) {
		super();
		this.dices = dices;
		this.sides = sides;
		this.rolls = rolls;
	}

	/**
	 * @return the dices
	 */
	public int getDices() {
		return dices;
	}
	/**
	 * @param dices the dices to set
	 */
	public void setDices(int dices) {
		this.dices = dices;
	}
	/**
	 * @return the sides
	 */
	public int getSides() {
		return sides;
	}
	/**
	 * @param sides the sides to set
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}
	/**
	 * @return the rolls
	 */
	public int getRolls() {
		return rolls;
	}
	/**
	 * @param rolls the rolls to set
	 */
	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

    
}
