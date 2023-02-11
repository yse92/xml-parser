package solvd.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import solvd.models.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginHandler extends DefaultHandler {
    private List<Login> logins = new ArrayList<>();
    private Login login;

    private boolean isName = false;
    private boolean isPassword = false;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {

        if ("Login".equals(qName)) {

            login = new Login();

            int id = Integer.parseInt(attributes.getValue("id"));
            login.setId(id);
        }

        switch (qName) {
            case "name":
                isName = true;
                break;
            case "password":
                isPassword = true;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (login == null) {
            return;
        }
        if (isName) {
            login.setName(new String(ch, start, length));
            isName = false;
        }

        if (isPassword) {
            login.setPassword(new String(ch, start, length));
            isPassword = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {

        if ("Login".equals(qName)) {
            logins.add(login);
            login = null;
        }
    }

    public List<Login> getLogins() {
        return logins;
    }
}
