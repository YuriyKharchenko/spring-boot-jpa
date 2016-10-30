package ua.home.springboot.sample.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.home.springboot.Application;
import ua.home.springboot.sample.model.Contact;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class XmlProcessorTest {
    @Autowired
    public XmlProcessor xmlProcessor;
    private static final File resultXMLXSD = new File("testXSD.xml");

    @Test
    public void testXSD() throws Exception {
        testWrite(xmlProcessor);
        testRead(xmlProcessor);
    }

    private void testWrite(XmlProcessor processor) {  //
        List<Contact> list = initTestData();
        processor.writeData(list, resultXMLXSD);
    }
    private void testRead(XmlProcessor processor){
        List<Contact> expectedList = initTestData();
        List<Contact> actualList = processor.readData(resultXMLXSD);
        assertEquals(expectedList.size(),actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i),actualList.get(i));
        }
        assertTrue(Arrays.equals(expectedList.toArray(),actualList.toArray()));
    }

    private List<Contact> initTestData(){
        List<Contact> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Contact("name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i,"name"+i, i+0L));
        }
        return list;
    }
}
