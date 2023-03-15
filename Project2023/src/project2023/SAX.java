package project2023;

import java.io.File;
import java.io.IOException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAX extends DefaultHandler {

    boolean isWinner = false;
    boolean isWinningScore = false;
    boolean isCourseLocation = false;
    boolean isCourse = false;
    boolean isFavourite = false;
    boolean isYoungestCompetitor = false;

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
            System.out.println("Name: " + name + " Year: " + year + " strokePlay: " + strokePlay);
        } else if (qName.equalsIgnoreCase("winner")) {
            isWinner = true;
        } else if (qName.equalsIgnoreCase("winningScore")) {
            isWinningScore = true;
        } else if (qName.equalsIgnoreCase("courseLocation")) {
            isCourseLocation = true;
        } else if (qName.equalsIgnoreCase("course")) {
            isCourse = true;
        } else if (qName.equalsIgnoreCase("favourite")) {
            isFavourite = true;
        } else if (qName.equalsIgnoreCase("youngestCompetitor")) {
            isYoungestCompetitor = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        // Get text from each tag
        if (isWinner) {
            System.out.println("Winner: " + new String(ch, start, length));
            // Set current tag to false, so we can move to another one
            isWinner = false;
        } else if (isWinningScore) {
            System.out.println("Winning Score: " + new String(ch, start, length));
            isWinningScore = false;
        } else if (isCourseLocation) {
            System.out.println("Course Location: " + new String(ch, start, length));
            isCourseLocation = false;
        } else if (isCourse) {
            System.out.println("Course: " + new String(ch, start, length));
            isCourse = false;
        } else if (isFavourite) {
            System.out.println("Favourite: " + new String(ch, start, length));
            isFavourite = false;
        } else if (isYoungestCompetitor) {
            System.out.println("Youngest Competitor: " + new String(ch, start, length));
            isYoungestCompetitor = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Check if end tag was reached 
        if (qName.equalsIgnoreCase("major")) {
            System.out.println("Reached End Element: " + qName);
            System.out.println();
        }
    }
}
//end of SAX class

