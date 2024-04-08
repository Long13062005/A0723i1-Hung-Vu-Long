package controller;

import services.imp.BikeService;
import services.interface_service.IBikeService;

public class BikeContronller {
	private IBikeService bikeService = new BikeService();
	
	public void add() {
		bikeService.add();
	}
	public void display() {
		bikeService.displayAll();
	}
	public void delete(String id) {
		bikeService.checkID(id);
	}
}
