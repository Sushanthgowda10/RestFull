package com.nt.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristmanegementService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {

	@Autowired
	private ITouristmanegementService touristService;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		try {
			String resultMsg = touristService.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in tourist Enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourist() {
		try {
			List<Tourist> list = touristService.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("Problem in fetching Tourist ty again...",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
		try {
			Tourist tourist = touristService.fetchTouristByID(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
		ResponseEntity<String> responseEntity = null;
		try {
			String msg = touristService.updateTouristDetails(tourist);
			responseEntity = new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id) {
		try {
			String msg = touristService.deleteTouristDetails(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") float hikePercent) {
		try {
			String msg = touristService.deleteTouristBudgetByID(id, hikePercent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteInRange/{start}/{end}")
	@Transactional
	public ResponseEntity<String> deleteInRange(@PathVariable int start, @PathVariable int end) {
		try {
			String msg = touristService.deleteInRange(start, end);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/updateInRange/{start}/{end}/{newBudget}")
	@Transactional
	public ResponseEntity<String> updateInRange(@PathVariable("start") int start, @PathVariable("end") int end,
			@PathVariable("newBudget") double newBudget) {
		try {
			String msg = touristService.updateInRange(start, end, newBudget);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
