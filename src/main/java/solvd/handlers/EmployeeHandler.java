package solvd.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import solvd.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler extends DefaultHandler {
    private List<Employee> employees = new ArrayList<>();
    private Employee employee;

    private boolean isFName = false;
    private boolean isLName = false;
    private boolean isSalary = false;
    private boolean isPosition = false;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {

        if ("Employee".equals(qName)) {

            employee = new Employee();

            int id = Integer.parseInt(attributes.getValue("id"));
            employee.setId(id);
        }

        switch (qName) {
            case "firstName":
                isFName = true;
                break;
            case "lastName":
                isLName = true;
                break;
            case "salary":
                isSalary = true;
                break;
            case "position":
                isPosition = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (employee == null) {
            return;
        }
        if (isFName) {
            employee.setFirstName(new String(ch, start, length));
            isFName = false;
        }

        if (isLName) {
            employee.setLastName(new String(ch, start, length));
            isLName = false;
        }

        if (isSalary) {
            employee.setSalary(new String(ch, start, length));
            isSalary = false;
        }

        if (isPosition) {
            employee.setPosition(new String(ch, start, length));
            isPosition = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {

        if ("Employee".equals(qName)) {
            employees.add(employee);
            employee = null;
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
