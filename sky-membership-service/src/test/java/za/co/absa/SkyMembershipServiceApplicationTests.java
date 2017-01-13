package za.co.absa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.absa.model.Customer;
import za.co.absa.repo.MembershipDatabase;
import za.co.absa.service.ReportingServiceQueues;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkyMembershipServiceApplicationTests {
    private static final Logger LOG = LoggerFactory.getLogger(SkyMembershipServiceApplicationTests.class);

    @Autowired
    private ReportingServiceQueues reportingProc;
    
    @Autowired
    private MessageCollector msgCollector;
   
    @Autowired
    private MembershipDatabase memberDb;
    
    @Before
    public void init() {
        Customer roy = new Customer();
        roy.setName("Roy");
        roy.setSurname("Batty");
        roy.setEmailAddress("roy@offworld.com");
        Customer zohra = new Customer();
        zohra.setName("Zohra");
        Customer pris = new Customer();
        pris.setName("pris");
        memberDb.add(roy);
        memberDb.add(pris);
        memberDb.add(zohra);
    }
    
    @Test
    public void successRetrieval() {
        Message<String> initMsg = new GenericMessage<>("{'all' : 1}");
        
        reportingProc.reportRequest().send(initMsg);
        
        Message response = msgCollector.forChannel(reportingProc.reportResponse()).poll();
        assertNotNull(response);
        
        final String payload = (String) response.getPayload();
        assertNotNull(payload);
        assertTrue(payload.contains("Roy"));
        
        LOG.info("{}", payload);
    }
}
