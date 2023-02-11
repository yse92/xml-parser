package solvd.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import solvd.models.Branch;
import solvd.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class BranchHandler extends DefaultHandler {
    private List<Branch> branches = new ArrayList<>();

    private Branch branch;
    private boolean isAdress;
    private boolean isPhone;
    private boolean isBranch;

    public List<Branch> getBranches() {
        return branches;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("Branch".equals(qName)) {
            isBranch = true;
            branch = new Branch();

            int id = Integer.parseInt(attributes.getValue("branchID"));
            branch.setId(id);
        }
        if ("Customer".equals(qName)) {
            isBranch = false;
        }
        if (!isBranch)
            return;
        switch (qName) {
            case "adress":
                isAdress = true;
                break;
            case "phone":
                isPhone = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("Branch".equals(qName)) {
            branches.add(branch);
            branch = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (branch == null) {
            return;
        }
        if (isAdress) {
            branch.setAdress(new String(ch, start, length));
            isAdress = false;
        }

        if (isPhone) {
            branch.setPhone(new String(ch, start, length));
            isPhone = false;
        }
    }
}
