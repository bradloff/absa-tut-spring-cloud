package za.co.absa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkyReportingServiceApplicationTests {

    @Autowired
    private Source skySrc;
    
    @Autowired
    private MessageCollector postman;
    
    @Test
    public void successProduce() {
        assertEquals(1, postman.forChannel(skySrc.output()).size());
    }

}
