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
public class CreateParser {
     Map<String, String> Ashraf = new LinkedHashMap<>();
     String tableName;

  //  private String subs;
    private final String query;

    public CreateParser(String query) {
       // subs = query.substring(0, query.indexOf(' '));
        this.query =  query  ;
    }

    // VALIDATES COMMAND 
    public boolean validateCreateCommand() {
            System.out.println("Validating...");
            Pattern pattern = Pattern.compile("CREATE\\sTABLE\\s\\w+\\s\\((\\w+\\s(int|varchar))(,\\w+\\s(int|varchar))*\\);\\z", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(this.query);
            return matcher.find();
    }
    
        public void Creation(){
            WriteXML x = new WriteXML(tableName,Ashraf);
            x.createXML();
            
        }
    
    public void cutCreateCommand() {
        System.out.println("Cutting...");
        tableName = this.query.substring(13, query.indexOf('(')-1);
        String subString = this.query.substring(this.query.indexOf('(')+1, this.query.indexOf(')'));
        System.out.println(subString);
       
        String tokens[] = subString.split(",");

         for (String token : tokens) {
             String[] Array = token.split(" ");
             Ashraf.put(Array[0], Array[1]);
         }
    }

}
