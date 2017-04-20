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
public class implement implements Database {

    @Override
    public boolean executeStructureQuery(String query) throws SQLException {
        
        CreateParser CParser = new CreateParser(query);
        DropParser DParser = new DropParser(query);
        if(CParser.validateCreateCommand()){
            System.out.println("Create!");
            CParser.cutCreateCommand();
            CParser.Creation();
            return true;
        }
        else if (DParser.validateDropCommand()){
            System.out.println("Drop!");
            DParser.Cutting();
            DParser.Delete();
            return true;
        }
        return false;
    }

    @Override
    public Object[][] executeRetrievalQuery(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int executeUpdateQuery(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
