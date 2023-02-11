package solvd.parser;

import org.xml.sax.helpers.DefaultHandler;
import solvd.handlers.*;
import solvd.models.*;

import java.util.List;

public class ParserService extends Parser {
    public ParserService(String xmlPath) {
        super(xmlPath);
    }

    public List<Customer> parseCustomers() {
        var handler = new CustomerHandler();
        parse(handler);

        return handler.getCustomers();
    }

    public List<Employee> parseEmployees() {
        var handler = new EmployeeHandler();
        parse(handler);

        return handler.getEmployees();
    }

    public List<Login> parseLogins() {
        var handler = new LoginHandler();
        parse(handler);

        return handler.getLogins();
    }

    public List<Branch> parseBranches() {
        var handler = new BranchHandler();
        parse(handler);

        return handler.getBranches();
    }

    public List<Account> parseAccounts() {
        var handler = new AccountHandler();
        parse(handler);

        return handler.getAccounts();
    }
}
