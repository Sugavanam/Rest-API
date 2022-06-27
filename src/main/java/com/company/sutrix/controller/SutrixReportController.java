package com.company.sutrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.sutrix.serviceImpl.ReportServiceImpl;

@RestController
public class SutrixReportController {

@Autowired
private ReportServiceImpl reportServiceImpl;

	@GetMapping(path = "/report")
	public String reportCsv() throws RuntimeException {
		 return reportServiceImpl.readCSVReport();
	}  


}
