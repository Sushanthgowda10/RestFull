package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Tourist;
import com.nt.model.TouristNotFoundException;
import com.nt.repository.repository;

@Service
public class TouristManegementServiceImpl implements ITouristmanegementService {

	@Autowired
	private repository touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid = touristRepo.save(tourist).getTid();
		return "Tourist is registered having the id value ::" + tid;

	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;

	}

	@Override
	public Tourist fetchTouristByID(Integer tid) throws TouristNotFoundException {
		return touristRepo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid + "Tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if (optional.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid() + "Tourist is Updated";
		} else
			throw new TouristNotFoundException(tourist.getTid() + "Tourist not found");

	}

	@Override
	public String deleteTouristDetails(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> optional = touristRepo.findById(tid);
		if (optional.isPresent()) {
			touristRepo.delete(optional.get());
			return tid + " Tourist deleted";

		} else
			throw new TouristNotFoundException(tid + "Tourist not Founfd");

	}

	@Override
	public String deleteTouristBudgetByID(Integer id, float hikePercentage) throws TouristNotFoundException {

		Optional<Tourist> optional = touristRepo.findById(id);
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget() + tourist.getBudget() + (hikePercentage / 100));
			return "Tourist budget is updated";

		} else
			throw new TouristNotFoundException(id + "Tourist not found");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteInRange(int start, int end) throws TouristNotFoundException {
		int list = touristRepo.deleteAllByRange(start, end);
		if (list > 0) {
			return list + "- numbers of records deleted";
		} else
			throw new TouristNotFoundException(" tourist not found");
	}

	@Override
	public String updateInRange(int start, int end, double newbudget) throws TouristNotFoundException {
		int updateByIdRange = touristRepo.updateByIdRange(start, end, newbudget);
		if (updateByIdRange > 0) {
			return updateByIdRange + "- numbers of record updated";
		} else
			throw new TouristNotFoundException(" tourist not found");
	}

}