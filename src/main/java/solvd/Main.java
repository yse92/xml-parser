package solvd;

import solvd.parser.ParserService;
import solvd.validator.SaxValidator;

public class Main {
    public static void main(String[] args) {
        //Sax validate
        String schemaName = "src/main/resources/bank.xsd";
        String xmlName = "src/main/resources/bank.xml";
        SaxValidator.validateXml(schemaName, xmlName);
        System.out.println();

        //Sax parse
        var parserService = new ParserService(xmlName);

//        parserService.parseCustomers().forEach(System.out::println);
//        System.out.println("* * *");
//        parserService.parseEmployees().forEach(System.out::println);
//        System.out.println("* * *");
//        parserService.parseLogins().forEach(System.out::println);
//        System.out.println("* * *");
//        parserService.parseBranches().forEach(System.out::println);
//        System.out.println("* * *");
//        parserService.parseAccounts().forEach(System.out::println);

    }
}
