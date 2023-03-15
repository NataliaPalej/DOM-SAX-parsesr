package project2023;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAX extends DefaultHandler {

    boolean isName = false;
    boolean isYear = false;
    boolean isStrokePlay = false;
    boolean isWinner = false;
    boolean isWinningScore = false;
    boolean isCourseLocation = false;
    boolean isCourse = false;
    boolean isFavourite = false;
    boolean isYoungestCompetitor = false;

    ArrayList<Golf> golfMajors = new ArrayList<>();
    private String tempMajor;
    private Golf tempGolf;

    public void runSAX() {
        parseDocument();
        outputList();
    }

    private void parseDocument() {
        // Get a SAX factory spf
        SAXParserFactory spf = SAXParserFactory.newInstance();
        // Create an instance of file
        File inputFile = new File("GolfMajors.xml");
        try {
            // Get an instance of parser
            SAXParser sp = spf.newSAXParser();
            sp.parse(inputFile, this);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error: " + e);
        }
    }

    private void outputList() {
        for (Golf golf : golfMajors) {
            System.out.println(golf);
        }
    }

    public static void main(String[] args) {
        SAX s = new SAX();
        s.runSAX();
    }
//end of main

    // Event Handlers
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Reset temporary value
        tempMajor = "";
        // Check which tag are we in
        if (qName.equalsIgnoreCase("major")) {
            tempGolf = new Golf();
        } else if (attributes.getValue("name") != null) {
            tempGolf.setName(attributes.getValue("name"));
            isName = true;
        } else if (attributes.getValue("year") != null) {
            tempGolf.getYear();
            isYear = true;
        } else if (attributes.getValue("strokePlay") != null) {
            tempGolf.getStrokePlay();
            isStrokePlay = true;
        } else if (qName.equalsIgnoreCase("winner")) {
            tempGolf.getWinner();
            isWinner = true;
        } else if (qName.equalsIgnoreCase("winningScore")) {
            tempGolf.getWinningScore();
            isWinningScore = true;
        } else if (qName.equalsIgnoreCase("courseLocation")) {
            tempGolf.getCourseLocation();
            isCourseLocation = true;
        } else if (qName.equalsIgnoreCase("course")) {
            tempGolf.getCourse();
            isCourse = true;
        } else if (qName.equalsIgnoreCase("favourite")) {
            tempGolf.getFavourite();
            isFavourite = true;
        } else if (qName.equalsIgnoreCase("youngestCompetitor")) {
            tempGolf.getYoungestCompetitor();
            isYoungestCompetitor = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        // Add text from tags to tempMajor 
        tempMajor += new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Check if end tag was reached 
        if (qName.equalsIgnoreCase("major")) {
            // if it did - add the element to the list
            golfMajors.add(tempGolf);
        // get attribute of element major
        } else if (qName.equalsIgnoreCase("name")) {
            tempGolf.setName(tempMajor);
        } else if (qName.equalsIgnoreCase("year")) {
            tempGolf.setYear(tempMajor);
        } else if (qName.equalsIgnoreCase("strokePlay")) {
            tempGolf.setStrokePlay(tempMajor);
        } else if (qName.equalsIgnoreCase("winner")) {
            tempGolf.setWinner(tempMajor);
        } else if (qName.equalsIgnoreCase("winningScore")) {
            tempGolf.setWinningScore(tempMajor);
        } else if (qName.equalsIgnoreCase("courseLocation")) {
            tempGolf.setCourseLocation(tempMajor);
        } else if (qName.equalsIgnoreCase("course")) {
            tempGolf.setCourse(tempMajor);
        } else if (qName.equalsIgnoreCase("favourite")) {
            tempGolf.setFavourite(tempMajor);
        } else if (qName.equalsIgnoreCase("youngestCompetitor")) {
            tempGolf.setYoungestCompetitor(tempMajor);
        }
    }
}
//end of SAX class

