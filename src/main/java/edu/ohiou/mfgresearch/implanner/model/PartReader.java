package edu.ohiou.mfgresearch.implanner.model;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ohiou.mfgresearch.implanner.parts.MfgPartModel;

public class PartReader {
	
	
	public String createPartModel(File file) {
		
		MfgPartModel partModel = new MfgPartModel().openUGFile(file);
		String partJason = "";
		//convert to json
		try {
			return transformToJason(partModel);
		} catch (Exception e) {
			return "Failed to parse file due to: " + e.getMessage();
		}
	}
	
	private String transformToJason(MfgPartModel partModel) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(partModel);
	}

}
