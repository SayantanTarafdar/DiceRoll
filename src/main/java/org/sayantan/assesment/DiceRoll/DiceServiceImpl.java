package org.sayantan.assesment.DiceRoll;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sayantan.assesment.DiceRoll.model.DiceCount;
import org.sayantan.assesment.DiceRoll.model.DiceDistribution;
import org.sayantan.assesment.DiceRoll.model.DiceSimulation;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.Api;

@Api("/roll")
public class DiceServiceImpl implements DiceService {

	@Autowired
	private DiceRepository diceRepository;
	@Autowired
	private DiceSimulationRepository diceSimulationRepository;
	
	@Resource
	private SessionFactory sessionFacotry;
	
	
	
	@Override
	public Response roll(Integer numberOfDices, Integer sides, Integer numberOfRolls) {
		//int numberOfRolls=100;
//		Session session;
//		try {
//		    session = sessionFacotry.getCurrentSession();
//		} catch (HibernateException e) {
//		    session = sessionFacotry.openSession();
//		}
//		
//		
//		
//		Transaction tx=session.beginTransaction();
//		
//		session.save(new DiceSimulation());
		
		DiceSimulation ds=diceSimulationRepository.save(new DiceSimulation(numberOfDices,sides,numberOfRolls));
		
		int rollCount=1;
		ArrayList<Integer> rollResults = new ArrayList<Integer>();
		
		
		while(rollCount<=numberOfRolls) {
			
			/*dice1 = (int)(Math.random()*sides) + 1;
			dice2 = (int)(Math.random()*sides) + 1;
			dice3 = (int)(Math.random()*sides) + 1;*/
			
			int sumOfDices=0;
			
			for (int i = 0; i < numberOfDices ; i++) {
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
		ArrayList<DiceCount> diceCount=new ArrayList<>();
		
        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
            System.out.println("Dice Count " + val.getKey() + " "
                               + "occurs"
                               + ": " + val.getValue() + " times");
            
            diceCount.add(new DiceCount(ds,val.getKey(),val.getValue()));
            
            diceRepository.save(new DiceCount(ds,val.getKey(),val.getValue()));
            
        }
        //tx.commit();
        
        return Response.status(Status.OK).entity(diceCount).build();
        
	}

	@Override
	public Response query() {
		int sumOfRolls=diceSimulationRepository.sumOfRolls();
		Map<DiceSimulation, ArrayList<DiceDistribution>> groupBy = new HashMap<DiceSimulation, ArrayList<DiceDistribution>>();
		
		Map<Long,Map<Integer,Map<Integer,ArrayList<DiceDistribution>>>> groupByDiceNumberAndSide=new HashMap<Long,Map<Integer,Map<Integer,ArrayList<DiceDistribution>>>>();
		
		ArrayList<DiceDistribution> diceDist=new ArrayList<>();
		diceRepository.findAll().forEach(entity->
				diceDist.add(new DiceDistribution(entity.getSimulationId(), sumOfRolls, entity.getDiceCount(), entity.getDiceCountOccured()))
		);
		Iterator<DiceDistribution> iterator = diceDist.iterator();
		while(iterator.hasNext()) {
			DiceDistribution dd=iterator.next();
			if(!groupByDiceNumberAndSide.containsKey(dd.getSimulationID().getId())) {
				
				ArrayList<DiceDistribution> list=new ArrayList<>();
				list.add(dd);
				Map<Integer,Map<Integer,ArrayList<DiceDistribution>>> diceAndSide=new HashMap<Integer,Map<Integer,ArrayList<DiceDistribution>>>();
				Map<Integer,ArrayList<DiceDistribution>> sideAndDistribution=new HashMap<Integer,ArrayList<DiceDistribution>>();
				sideAndDistribution.put(dd.getSimulationID().getSides(), list);
				diceAndSide.put(dd.getSimulationID().getDices(), sideAndDistribution);
				
				groupByDiceNumberAndSide.put(dd.getSimulationID().getId(),diceAndSide);
				
				
				//groupBy.put(dd.getSimulationID(), list);
				
			}else {
				//groupBy.get(dd.getSimulationID()).add(dd);
					if(groupByDiceNumberAndSide.get(dd.getSimulationID().getId()).containsKey(dd.getSimulationID().getDices())) {//Only dice match
						
						if(groupByDiceNumberAndSide.get(dd.getSimulationID().getId()).get(dd.getSimulationID().getDices()).containsKey(dd.getSimulationID().getSides()))
						{//sides match
							groupByDiceNumberAndSide.get(dd.getSimulationID().getId()).get(dd.getSimulationID().getDices()).get(dd.getSimulationID().getSides()).add(dd);
						}else {
							ArrayList<DiceDistribution> list=new ArrayList<>();
							list.add(dd);
							groupByDiceNumberAndSide.get(dd.getSimulationID().getId()).get(dd.getSimulationID().getDices()).put(dd.getSimulationID().getSides(), list);
						}
						
					}else {
						ArrayList<DiceDistribution> list=new ArrayList<>();
						list.add(dd);
						Map<Integer,ArrayList<DiceDistribution>> sideAndDistribution=new HashMap<Integer,ArrayList<DiceDistribution>>();
						sideAndDistribution.put(dd.getSimulationID().getSides(), list);
						
						groupByDiceNumberAndSide.get(dd.getSimulationID().getId()).put(dd.getSimulationID().getDices(), sideAndDistribution);
					}
				
				
			}
			
		}
		
		return Response.status(Status.OK).entity(groupByDiceNumberAndSide).build();
	}

}
