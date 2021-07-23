package org.sayantan.assesment.DiceRoll.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class DiceCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="simulations_id", nullable=false)
    private DiceSimulation simulationId;
    private int diceCount;
    private int diceCountOccured;
	public DiceCount() {
		
	}
	
	public DiceCount(DiceSimulation simulationId,int diceCount, int diceCountOccured) {
		super();
		this.simulationId = simulationId;
		this.diceCount = diceCount;
		this.diceCountOccured = diceCountOccured;
	}
	/**
	 * @return the diceCount
	 */
	public int getDiceCount() {
		return diceCount;
	}
	/**
	 * @param diceCount the diceCount to set
	 */
	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}
	/**
	 * @return the diceCountOccured
	 */
	public int getDiceCountOccured() {
		return diceCountOccured;
	}
	/**
	 * @param diceCountOccured the diceCountOccured to set
	 */
	public void setDiceCountOccured(int diceCountOccured) {
		this.diceCountOccured = diceCountOccured;
	}

	/**
	 * @return the simulationId
	 */
	public DiceSimulation getSimulationId() {
		return simulationId;
	}

	/**
	 * @param simulationId the simulationId to set
	 */
	public void setSimulationId(DiceSimulation simulationId) {
		this.simulationId = simulationId;
	}

}
