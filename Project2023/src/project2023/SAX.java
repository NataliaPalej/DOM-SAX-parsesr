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
    
    boolean bwinner = false;
    boolean bwinningScore = false;
    boolean bcourseLocation = false;
    boolean bcourse = false;
    boolean bfavourite = false;
    boolean byoungestCompetitor = false;

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
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Check which tag are we in
        if (qName.equalsIgnoreCase("major")) {
            String name = attributes.getValue("name");
            String year = attributes.getValue("year");
            String strokePlay = attributes.getValue("strokePlay");
            System.out.println("Name: " + name + "Year: " + year + "strokePlay: " + strokePlay);
        }
        else if (qName.equalsIgnoreCase("winner")){
        bwinner = true;
        }
        else if (qName.equalsIgnoreCase("winningScore")){
        bwinningScore = true;
        }
        else if (qName.equalsIgnoreCase("courseLocation")){
        bcourseLocation = true;
        }
        else if (qName.equalsIgnoreCase("course")){
        bcourse = true;
        }
        else if (qName.equalsIgnoreCase("favourite")){
        bfavourite = true;
        }
        else if (qName.equalsIgnoreCase("youngestCompetitor")){
        byoungestCompetitor = true;
        }
    }
    
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        // Get text from each tag
        if (bwinner) {
            System.out.println("Winner: " + new String(ch, start, length));
            // Set current tag to false, so we can move to another one
            bwinner = false;
        }
        else if (bwinningScore){
            System.out.println("Winning Score: " + new String(ch, start, length));
            bwinningScore = false;
        }
        else if (bcourseLocation){
            System.out.println("Course Location: " + new String(ch, start, length));
            bcourseLocation = false;
        }
        else if (bcourse){
            System.out.println("Course: " + new String(ch, start, length));
            bcourse = false;
        }
        else if (bfavourite){
            System.out.println("Favourite: " + new String(ch, start, length));
            bfavourite = false;
        }
        else if (byoungestCompetitor){
            System.out.println("Youngest Competitor: " + new String(ch, start, length));
            byoungestCompetitor = false;
        }

}
    

}
//end of SAX class

