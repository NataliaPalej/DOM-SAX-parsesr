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
        display.runExample();
    }
// End of main
    
    // Method that runs the file 
    public void runExample(){
        loadXMLFileIntoDOM();
        parseTheDOM();
        outputData();
    }
    
    // Method that loads XML file into DOM
    private void loadXMLFileIntoDOM() {
        //create DocumentBuilderFactory instance
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try{
            //create DocumentBuilder instance
            DocumentBuilder db = dbf.newDocumentBuilder();
            //parse xml file to dom Document
            dom = db.parse("GoldMajors.xml");
        }
        catch (IOException | ParserConfigurationException | SAXException e){
            System.out.println("Error: " + e);
        }
    }
    
   

}
// End of class DOM

