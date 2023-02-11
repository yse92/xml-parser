package solvd.parser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import solvd.models.Customer;
import solvd.models.Employee;
import solvd.models.Login;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Parser {
    private SAXParser saxParser = null;

    private String xmlPath;

    public Parser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public abstract List<Customer> parseCustomers();

    public abstract List<Employee> parseEmployees();

    public abstract List<Login> parseLogins();

    private SAXParser createSaxParser() {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxParser = factory.newSAXParser();

            return saxParser;
        } catch (ParserConfigurationException | SAXException ex) {

            Logger lgr = Logger.getLogger(ParserService.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

            return saxParser;
        }
    }

    public void parse(DefaultHandler handler) {
        File xmlDocument = Paths.get(xmlPath).toFile();

        try {

            SAXParser parser = createSaxParser();
            parser.parse(xmlDocument, handler);

        } catch (SAXException | IOException ex) {

            Logger lgr = Logger.getLogger(ParserService.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
