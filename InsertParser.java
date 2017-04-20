/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Abd El Rahman
 */
public class InsertParser {

    Map<String, String> inserting = new LinkedHashMap<>();
    String tableName;

    //  private String subs;
    private final String query;

    public InsertParser(String query) {
        // subs = query.substring(0, query.indexOf(' '));
        this.query = query;
    }

    // VALIDATES COMMAND 
    public boolean validateInsertCommand() {
        System.out.println("Validating...");
        Pattern pattern = Pattern.compile("INSERT\\sINTO\\s\\(\\w+(,\\s\\w+)*\\)\\sVALUES\\s\\(\\w+(,\\s\\w+)*\\);\\z", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.query);
        return matcher.find();
    }

    public void Creation() {
    }

    public int cutInsertCommand() {
        System.out.println("Cutting...");

        String substringCol = query.substring(query.indexOf('(') + 1, query.indexOf(')'));
        String replaced = query.replaceFirst(substringCol, " ");
        String substringVal = replaced.substring(replaced.lastIndexOf('(') + 1, replaced.lastIndexOf(')'));

        String ColTokens[] = substringCol.split(", ");
        String ValTokens[] = substringVal.split(", ");

        if (ColTokens.length == ValTokens.length) {
            for (int i = 0; i < ColTokens.length; i++) {
                inserting.put(ColTokens[i], ValTokens[i]);
            }
            return ColTokens.length;
        } else {
            System.out.println("Oops... Uneven number of attributes");
        }
        return 0;
    }
}
