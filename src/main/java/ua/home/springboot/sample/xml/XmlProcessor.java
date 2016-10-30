package ua.home.springboot.sample.xml;

import ua.home.springboot.sample.model.Contact;

import java.io.File;
import java.util.List;

public interface XmlProcessor {

    public List<Contact> readData(File file);
    public void writeData(List<Contact> data, File file);
    //for test

    public boolean isValid(String input);
}
