package org.sayantan.assesment.DiceRoll.model;

import java.text.DecimalFormat;

public class DiceDistribution {
	private DiceSimulation simulationID;
	private int sumTotal;
	private int diceCount;
	private int diceCountOccured;
	private String relativeDistributions;
	public DiceDistribution() {
		
	}
	
	public DiceDistribution(DiceSimulation simulationID, int sumTotal, int diceCount, int diceCountOccured) {
		super();
		this.simulationID = simulationID;
		this.sumTotal = sumTotal;
		this.diceCount = diceCount;
		this.diceCountOccured = diceCountOccured;
		//this.relativeDistributions = relativeDistributions;
	}
	/**
	 * @return the simulationID
	 */
	public DiceSimulation getSimulationID() {
		return simulationID;
	}
	/**
	 * @param simulationID the simulationID to set
	 */
	public void setSimulationID(DiceSimulation simulationID) {
		this.simulationID = simulationID;
	}
	/**
	 * @return the sumTotal
	 */
	public int getSumTotal() {
		return sumTotal;
	}
	/**
	 * @param sumTotal the sumTotal to set
	 */
	public void setSumTotal(int sumTotal) {
		this.sumTotal = sumTotal;
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
	 * @return the relativeDistributions
	 */
	public String getRelativeDistributions() {
		DecimalFormat df = new DecimalFormat("0.00");
		double rd = (float)this.diceCountOccured/this.sumTotal*100.0;
		return df.format(rd);
	}
	/**
	 * @param relativeDistributions the relativeDistributions to set
	 */
	public void setRelativeDistributions(String relativeDistributions) {
		this.relativeDistributions = relativeDistributions;
	}
	
}
