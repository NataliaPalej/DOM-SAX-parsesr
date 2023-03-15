package project2023;

/**
 * @author Natalia A00279259
 */
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DOM {

    // Create an array list to store the items in
    ArrayList<Golf> golfMajors = new ArrayList<>();
    // Declare document
    Document dom;

    // Main method
    public static void main(String[] args) {
        DOM display = new DOM();
        display.outputData();
    }
// End of main
    
    // Method that runs the file
    public void runDOM(String fileName){
        // Calling the methods to test if file is parsing properly
        loadXMLFileIntoDOM(fileName);
        parseTheDOM();
        outputData();
    }
    
    // Method that loads XML file into DOM
    void loadXMLFileIntoDOM(String fileName) {
        // Create DocumentBuilderFactory instance
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try{
            // Create DocumentBuilder instance
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Parse xml file to dom Document
            dom = db.parse(fileName);
        }
        catch (IOException | ParserConfigurationException | SAXException e){
            System.out.println("Error: " + e);
        }
    }
    
   // Method that parse the DOM
    void parseTheDOM(){
        Element e = dom.getDocumentElement();
        
        // Get elements with a tagname "major"
        NodeList nl = e.getElementsByTagName("major");
        // If list not empty and not less than zero condition
        if(nl != null && nl.getLength() > 0){
            //loop through the items 
            for(int i=0; i<nl.getLength(); i++){
                Element el = (Element)nl.item(i);
                Golf x = getGolf(el);
                //add item to array list
                golfMajors.add(x);
            }
        }
    }
    
    // Method to get text from file
    private String getTextValue(Element e, String tagName){
        // Declare textValue 
        String textVal = null;
        // Get element by tagName
        NodeList nl = e.getElementsByTagName(tagName);
        // Condition if list not empty
        if(nl!=null && nl.getLength() > 0){
            Element el = (Element)nl.item(0);
            textVal=el.getFirstChild().getNodeValue();
        }
        return textVal;
    }
    
    // Method to get elements from file
    private Golf getGolf(Element e){
        String winner = getTextValue(e,"winner");
        String winningScore = getTextValue(e,"winningScore");
        //int winningScore = Integer.parseInt(getTextValue(e, "winningScore"));
        String courseLocation = getTextValue(e, "courseLocation");
        String course = getTextValue(e, "course");
        String favourite = getTextValue(e, "favourite");
        String youngestCompetitor = getTextValue(e, "youngestCompetitor");
        // Get attributes
        String name = e.getAttribute("name");
        String year = e.getAttribute("year");
        String strokePlay = e.getAttribute("strokePlay");
        
        // Create an object of class Golf
        Golf x = new Golf(name, year, strokePlay, winner, winningScore, courseLocation, course, favourite, youngestCompetitor);
        return x;
    }
    
     void outputData(){
        // Loop through the array to output data
        for(Golf golf : golfMajors){
        System.out.println(golf + "\n"); 
        }
    }
}
// End of class DOM

