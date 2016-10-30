package ua.home.springboot.sample.xml;

import org.springframework.stereotype.Service;
import ua.home.springboot.sample.model.Contact;
import ua.home.springboot.sample.model.Contacts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class XmlProcessorImpl implements XmlProcessor{


 public XmlProcessorImpl getXmlProcessorImpl(){

    return new XmlProcessorImpl();
 }


    @Override
    public List<Contact> readData(File file) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Contacts.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Contacts  contacts = (Contacts) unmarshaller.unmarshal(file);
            return contacts.getContacts();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void writeData(List<Contact> data, File file) {    // Преобразуем JAVA в XML
        try {
            JAXBContext ctx = JAXBContext.newInstance(Contacts.class);
            Marshaller marshaller = ctx.createMarshaller();              //Маршаллер из JAVA в XML
            Contacts contacts = new Contacts(data);

            marshaller.marshal(contacts, file);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
    //for test
    @Override
    public boolean isValid(String input) {
        return true;
    }
}
