/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Abd El Rahman
 */
public class DropParser {

    private String tableName;
    private final String query;

    public DropParser(String query) {
        this.query = query;
    }

    public boolean validateDropCommand() {
        System.out.println("Validating(Drop)...");
        String regex = "DROP\\sTABLE\\s\\w+;\\z";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        return matcher.find();
    }

    public void Delete() {
        DropXML dropper = new DropXML(tableName);
        dropper.dropXML();

    }

    public void Cutting() {
        System.out.println("Cutting...");
        tableName = query.substring(11, query.indexOf(';'));
        System.out.println(tableName);
    }

}
