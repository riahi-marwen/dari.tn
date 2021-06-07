package edu.esprit.immo.Dari;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.esprit.immo.Dari.entities.Reclamation;
import edu.esprit.immo.Dari.service.ReclamationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReclamationServiceImplTest {

	@Autowired
	ReclamationService rs;
	private static final Logger log = LogManager.getLogger(ReclamationServiceImplTest.class);

	@Test
	public void testretieveReclamation() {
		Reclamation rec = rs.retieveReclamation("1");
		//assertNotNull(rec.getPrenom());
		log.info("retieveReclamation : " + rec);
	}
	
	@Test
	public void testaddReclamation() throws ParseException {

	//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//Date date = dateFormat.parse("2015-03-23");
	//Reclamation rec = new Reclamation(null, "Mr", "ahmed", "ahmed", "eeeee", null, null, null, null, null, null);
	Reclamation rec = new Reclamation("Mr", "ahmed2", "ouertani");
	//assertTrue(rec.getNom().equals(rec.getPrenom()));
	rs.addReclamation(rec);
	}
}
