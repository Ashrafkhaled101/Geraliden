/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dab;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Abd El Rahman
 */
public class main {
    

    public static void main (String [] args) throws SQLException{
        while (true){
            Scanner scanner = new Scanner(System.in);
            String query;
            query = scanner.nextLine();
            Check check = new Check();
            check.validateQuery(query);
        }
       // implement implement = new implement();
       // implement.executeStructureQuery(query);
    }
    
}
