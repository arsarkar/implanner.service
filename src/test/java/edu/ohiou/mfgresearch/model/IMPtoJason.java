package edu.ohiou.mfgresearch.model;

import javax.vecmath.Point3d;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ohiou.mfgresearch.labimp.gtk2d.InvalidLineException;
import edu.ohiou.mfgresearch.labimp.gtk3d.*;

public class IMPtoJason {

	@Test
	public void testIMPObjectSerialization() {
		try {
			Line3d line = new Line3d(new Point3d(1, 2, 3), new Point3d(3, 2, 1));
			ObjectMapper mapper = new ObjectMapper();
			String lineJason = mapper.writeValueAsString(line);
		} catch (InvalidLineException e) {
			// TODO Auto-generated catch block
			System.out.println("Line 3D could not be created....... \n" + e.getMessage());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in Jackson Parsing....... \n" + e.getMessage());
		}
			
	}

}
