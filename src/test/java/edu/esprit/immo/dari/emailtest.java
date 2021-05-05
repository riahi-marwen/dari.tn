package edu.esprit.immo.dari;

import edu.esprit.immo.dari.services.EmailSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class emailtest {
    @Autowired
    private EmailSenderService emailSenderService;
    @Test
    public void testmail() {
        emailSenderService.sendSimpleMessage("c7f79b6a12-3fcecc@inbox.mailtrap.io","c7f79b6a12-3fcecc@inbox.mailtrap.io","test","dfsafdasfdsa");
    }

}
