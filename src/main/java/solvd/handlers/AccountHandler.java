package solvd.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import solvd.models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountHandler extends DefaultHandler {
    private List<Account> accounts = new ArrayList<>();
    private Account account;

    private boolean isBalance = false;
    private boolean isActive = false;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {

        if ("Account".equals(qName)) {

            account = new Account();

            int id = Integer.parseInt(attributes.getValue("accountID"));
            account.setId(id);
        }

        switch (qName) {
            case "balance":
                isBalance = true;
                break;
            case "isActive":
                isActive = true;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (account == null) {
            return;
        }
        if (isBalance) {
            account.setBalance(Double.parseDouble(new String(ch, start, length)));
            isBalance = false;
        }

        if (isActive) {
            if ("1".equals(new String(ch, start, length))) {
                account.setActive(true);
            } else {
                account.setActive(false);
            }
            isActive = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {

        if ("Account".equals(qName)) {
            accounts.add(account);
            account = null;
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
