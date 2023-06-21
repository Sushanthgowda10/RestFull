package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.model.TouristNotFoundException;

public interface ITouristmanegementService {
	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTourists();

	public Tourist fetchTouristByID(Integer tid) throws TouristNotFoundException;

	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;

	public String deleteTouristDetails(Integer tid) throws TouristNotFoundException;

	public String deleteTouristBudgetByID(Integer id, float hikePercentage) throws TouristNotFoundException;

	public String deleteInRange(int start, int end) throws TouristNotFoundException;

	public String updateInRange(int start, int end, double newbudget) throws TouristNotFoundException;

}
