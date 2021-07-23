package org.sayantan.assesment.DiceRoll;

import org.sayantan.assesment.DiceRoll.model.DiceDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class DistributionRepositoryImpl implements DistributionRepository {
	
	@Autowired
	@Lazy
	DiceSimulationRepository diceSimulationRepository;
	
	@Autowired 
	@Lazy
	DiceRepository diceRepository;

	@Override
	public DiceDistribution calculateDiceDistribution() {
		int sumOfAll=diceSimulationRepository.sumOfRolls();
			
		return null;
	}

}
