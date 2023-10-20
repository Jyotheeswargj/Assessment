/**
 * 
 */
package web.api.assessment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.api.assessment.model.CustomerTransactions;
import web.api.assessment.service.RewardsService;

@RestController
public class RewardsController {

	@Autowired
	RewardsService rewardsService;
	
		@RequestMapping(value = "/getrewards")
		public ResponseEntity<Map> ComputeRewards(@RequestBody List<CustomerTransactions> transactions) {
			return rewardsService.calculatePoints(transactions);
		}
	}
