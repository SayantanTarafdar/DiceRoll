package org.sayantan.assesment.DiceRoll;

import org.sayantan.assesment.DiceRoll.model.DiceSimulation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DiceSimulationRepository extends CrudRepository<DiceSimulation, Long> {

	@Query("SELECT SUM(rolls) FROM DiceSimulation")
    Integer sumOfRolls();
}
