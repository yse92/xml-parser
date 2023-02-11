package solvd.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import solvd.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerHandler extends DefaultHandler {
    private List<Customer> customers = new ArrayList<>();
    private Customer customer;

    private boolean isFName = false;
    private boolean isLName = false;
    private boolean isPhone = false;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {

        if ("Customer".equals(qName)) {

            customer = new Customer();

            int id = Integer.parseInt(attributes.getValue("id"));
            customer.setId(id);
        }

        switch (qName) {
            case "firstName":
                isFName = true;
                break;
            case "lastName":
                isLName = true;
                break;
            case "phone":
                isPhone = true;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (customer == null) {
            return;
        }
        if (isFName) {
            customer.setFirstName(new String(ch, start, length));
            isFName = false;
        }

        if (isLName) {
            customer.setLastName(new String(ch, start, length));
            isLName = false;
        }

        if (isPhone) {
            customer.setPhone(new String(ch, start, length));
            isPhone = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {

        if ("Customer".equals(qName)) {
            customers.add(customer);
            customer = null;
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
