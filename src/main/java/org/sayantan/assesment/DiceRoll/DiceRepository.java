package org.sayantan.assesment.DiceRoll;

import org.sayantan.assesment.DiceRoll.model.DiceCount;
import org.springframework.data.repository.CrudRepository;

public interface DiceRepository extends CrudRepository<DiceCount, Long> {
	
}
