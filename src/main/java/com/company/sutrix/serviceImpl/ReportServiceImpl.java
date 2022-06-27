package com.company.sutrix.serviceImpl;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.company.sutrix.model.ActorsDetails;
import com.company.sutrix.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

@Service
public class ReportServiceImpl implements ReportService {

	@Override
	public String readCSVReport()throws RuntimeException {
		ArrayList<ActorsDetails> list = new ArrayList<>();
		return convertToJson(csvReaderToList(list));
	}

	@SuppressWarnings("unused")
	private ArrayList<ActorsDetails> csvReaderToList(ArrayList<ActorsDetails> list ) throws RuntimeException {  
		try(CSVReader reader = new CSVReader(
				new FileReader("src\\main\\resources\\sutrixReport.csv",StandardCharsets.UTF_8)))
		{    
			String [] nextLine;  
			while ((nextLine = reader.readNext()) != null)  
			{  
				if(!((nextLine[0]).equals("First Name"))) {
					ActorsDetails actors = new ActorsDetails();
					for(String token : nextLine)  
					{  
						actors.setFirst_name(nextLine[0]);
						actors.setLast_name(nextLine[1]);
						actors.setAge(Integer.parseInt(nextLine[2]));
					}
					list.add(actors);  
				}  }}  
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}
		return list;  
	}

	private String convertToJson(ArrayList<ActorsDetails> list) throws RuntimeException {
		ObjectMapper Obj = new ObjectMapper();  
		String jsonStr =null;
		try {  
			jsonStr = Obj.writeValueAsString(list);     
		}  
		catch (IOException e) {  
			e.printStackTrace();  
		}
		return jsonStr;  
	}

}
