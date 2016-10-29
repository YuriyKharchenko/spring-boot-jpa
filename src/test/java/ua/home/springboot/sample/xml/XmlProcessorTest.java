package ua.home.springboot.sample.xml;

import org.junit.Test;
import ua.home.springboot.sample.model.Contact;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XmlProcessorTest {

    public XmlProcessor xmlProcessor = new XsdXmlProcessorImpl();
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
