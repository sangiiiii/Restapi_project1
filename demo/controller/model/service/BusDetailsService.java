package com.example.demo.controller.model.service;

import java.util.List;

import com.example.demo.BusManagement;


/* here we declare some of the methods like save BusDetails,get BusDetails ,
 * get BusDetails by id, updating and delete details by id*/

public  interface BusDetailsService{
	BusManagement saveBusDetails(BusManagement busDetails);
	List<BusManagement>  getBusDetailsFromDb();
	BusManagement getBusDetailsById(int busId);
	BusManagement updateBusDetails(BusManagement busDetails, int busId);
	void deleteBusDetailsById(int busId);

}