package edu.ohiou.mfgresearch.model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.junit.Test;

import edu.ohiou.mfgresearch.implanner.model.PartReader;
import edu.ohiou.mfgresearch.implanner.parts.MfgPartModel;

public class TestModel {
	
	private String OUTPUT_FOLDER = "C:/Users/sarkara1/git/implanner.service/data/output/";

	@Test
	public void testPartModelParsing() {
		PartReader pr = new PartReader();		

		String partJason = "";
		//convert to json
		try {
			MfgPartModel partModel = pr.createPartModel(new File("C:\\Users\\sarkara1\\git\\implanner.service\\data\\singleHole.prt"));
			partJason = pr.transformToJason(partModel);
		} catch (Exception e) {
			System.out.println( "Failed to parse file due to: " + e.getMessage());
			e.printStackTrace();			
		}
		System.out.println(partJason);
		assertTrue(partJason.length()>0);
	}
	
	@Test
	public void testPartModelWriting() {
		PartReader pr = new PartReader();
		

		String partJason = "";
		//convert to json
		try {
			MfgPartModel partModel = pr.createPartModel(new File("C:\\Users\\sarkara1\\git\\implanner.service\\data\\Slider.prt"));
			partJason = pr.transformToJason(partModel);

			FileWriter fw = new FileWriter(new File(OUTPUT_FOLDER+"features_test_"
													   +DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now())+".json"
													   ));
			fw.write(partJason);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println( "Failed to parse file due to: " + e.getMessage());
			e.printStackTrace();			
		}
		//System.out.println(partJason);
		assertTrue(partJason.length()>0);
	}

}
