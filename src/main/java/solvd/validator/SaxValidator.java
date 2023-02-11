package solvd.validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaxValidator {
    public static void validateXml(String xsdName, String xmlName) {
        try {
            Path xmlPath = Paths.get(xmlName);
            Reader reader = Files.newBufferedReader(xmlPath);

            Schema schema = loadSchema(xsdName);

            Validator validator = schema.newValidator();

            validator.validate(new SAXSource(new InputSource(reader)));

            System.out.println("The document was validated OK");

        } catch (SAXException ex) {
            Logger lgr = Logger.getLogger(SaxValidator.class.getName());
            lgr.log(Level.SEVERE, "The document failed to validate");
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            Logger lgr = Logger.getLogger(SaxValidator.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static Schema loadSchema(String name) {
        Schema schema = null;
        File xsdFile = new File(name);
        try {
            String schemaLang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            schema = factory.newSchema(xsdFile);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return schema;
    }
}

