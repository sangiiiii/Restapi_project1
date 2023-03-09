package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BusManagement;
import com.example.demo.controller.model.BusManagementServiceImpl;

@RestController
@RequestMapping("/BusDetails.com")
public class BusController {


	public BusManagementServiceImpl  busService;

	public BusController(BusManagementServiceImpl  busService) {
		this.busService = busService;
	}

	@PostMapping("/savebus")

	public ResponseEntity<BusManagement> savebus(@RequestBody BusManagement bus){
		return new ResponseEntity<BusManagement>(busService.saveBusDetails(bus), HttpStatus.CREATED);
	}

	@PutMapping("/updateBusDetails/{busId}")
	public ResponseEntity<BusManagement> updateBusDetailsById(@PathVariable("busId") int id,
			@RequestBody BusManagement bus){
		return new ResponseEntity<BusManagement>(busService.updateBusDetails(bus, id), HttpStatus.OK);

	}

	@GetMapping("/readAllBusDetails")
	public List<BusManagement> getAllBusDetails(){
		return busService.getBusDetailsFromDb();
	}


	@GetMapping("/readbus/{id}")
	public ResponseEntity<BusManagement>  getBusDetailsById(@PathVariable("id")  int busId){
		return new ResponseEntity<BusManagement>(busService.getBusDetailsById(busId), HttpStatus.OK);
	}
	@DeleteMapping("/deletebus/{id}")
	public ResponseEntity<String> deleteBusDetailsById(@PathVariable("id")  int busId){
		busService.deleteBusDetailsById(busId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
}