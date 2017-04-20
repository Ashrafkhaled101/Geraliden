/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dab;

import java.io.File;

/**
 *
 * @author Abd El Rahman
 */
public class DropXML {
    String tableName;

    public DropXML(String tableName) {
        this.tableName = tableName;
    }
    
    public void dropXML(){
        tableName = tableName.concat(".xml");
        System.out.println(tableName);
        File file = new File(tableName);
    //    file.
        if (file.exists()){
            System.out.println("file existis");
        }
        
        if(file.delete())
            System.out.println("File Deleted Successfully");                
        else
            System.out.println("Oops.... File Not Found ");
    }
}
