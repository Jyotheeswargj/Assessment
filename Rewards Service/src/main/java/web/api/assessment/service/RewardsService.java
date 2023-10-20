package web.api.assessment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import web.api.assessment.exception.TransactionDataException;
import web.api.assessment.model.CustomerTransactions;

@Component
public class RewardsService {
	private static Log log = LogFactory.getLog(RewardsService.class);
	public ResponseEntity<Map> calculatePoints(List<CustomerTransactions> custTransactions) {
		Integer rewardsPts = 0;
		Map<String, Integer> pointsMap = new HashMap<String, Integer>();
		for (CustomerTransactions transctions : custTransactions) {
			Integer expenses = transctions.getAmountSpent();
			try {
				if (expenses <= 0)
					throw new TransactionDataException();
			} catch (TransactionDataException e) {
				log.info("Customer Transaction Entry is Incorect");
	              if (log.isDebugEnabled()) {
	                  log.debug("Customer Transaction Entry is Incorect.");
	                  log.debug(transctions.getId() + transctions.getMonth());
	          }
			}
			
			if (expenses > 100) {
				rewardsPts = 50 + (expenses - 100) * 2;
			}
			else if (expenses > 50 && expenses < 100) {
				rewardsPts = (expenses - 50);
			} else {
				rewardsPts = 0;
			} 

			String custTransactionEntry = transctions.getId() +"-"+ transctions.getMonth();

			if (pointsMap.get(custTransactionEntry) != null) {
				pointsMap.put(custTransactionEntry, pointsMap.get(custTransactionEntry) + rewardsPts);
			} else {
				pointsMap.put(custTransactionEntry, rewardsPts);
			}
		}
		return new ResponseEntity<Map>(pointsMap, HttpStatus.OK);
	}
}