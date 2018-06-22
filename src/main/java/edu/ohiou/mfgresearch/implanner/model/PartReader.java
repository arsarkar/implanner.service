package edu.ohiou.mfgresearch.implanner.model;

import java.io.File;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ohiou.mfgresearch.implanner.features.MfgFeature;
import edu.ohiou.mfgresearch.implanner.parts.MfgPartModel;

public class PartReader {
	
	ObjectMapper mapper;
	
	public PartReader() {
		mapper = new ObjectMapper();
	}
	
	private Function<MfgFeature, String> featureMapper = f->{
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(f);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";            //e.getMessage();
		}
	};

	public MfgPartModel createPartModel(File file) {
		return new MfgPartModel().openUGFile(file);
	}
	
	public String transformToJason(MfgPartModel partModel) throws JsonProcessingException {
		
		return
		partModel.getFeatureList()
				 .stream()
				 .map(featureMapper)
				 .collect(Collectors.joining("\n,\n"));
	}
	
	

}
