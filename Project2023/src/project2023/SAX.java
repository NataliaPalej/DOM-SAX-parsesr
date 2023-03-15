package project2023;

import java.io.File;
import java.io.IOException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAX extends DefaultHandler {

    public static void main(String[] args) {

        
        
        try {
            // Create an instance of file
            File inputFile = new File("GolfMajors.xml");
            // Get a SAX factory spf
            SAXParserFactory spf = SAXParserFactory.newInstance();
            // Get an instance of parser
            SAXParser sp = spf.newSAXParser();
            SAX SAXparse = new SAX();
            System.out.println("SAXparse.SAX.main()");
            // Parse the file
            sp.parse(inputFile, SAXparse);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error: " + e);
        }

    }
//end of main

}
//end of SAX class

