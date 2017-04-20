/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dab;

import java.sql.SQLException;

/**
 *
 * @author Abd El Rahman
 */
public class Check {
    // VALIDATE COMMAND

    public boolean validateQuery(String query) throws SQLException {
        implement imp = new implement();
        String subs = query.substring(0, query.indexOf(' '));

        if (subs.equalsIgnoreCase("CREATE")) {
            return imp.executeStructureQuery(query);
        } else if (subs.equalsIgnoreCase("DROP")) {
            return imp.executeStructureQuery(query);
        } else if (subs.equalsIgnoreCase("INSERT")) {
        } else if (subs.equalsIgnoreCase("SELECT")) {
        } else if (subs.equalsIgnoreCase("DELETE")) {
        }
        return false;

    }
    // END 

}
