package edu.ohiou.mfgresearch.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ohiou.mfgresearch.implanner.model.PartReader;

public class TestModel {

	@Test
	public void testPartModelParsing() {
		PartReader pr = new PartReader();
		String partJason = pr.createPartModel(new File("C:\\Users\\sarkara1\\git\\implanner.service\\data\\singleHole.prt"));
		System.out.println(partJason);
		assertTrue(partJason.length()>0);
	}

}
