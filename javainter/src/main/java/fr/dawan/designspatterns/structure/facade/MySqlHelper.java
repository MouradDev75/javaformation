package fr.dawan.designspatterns.structure.facade;

import java.sql.Connection;

public class MySqlHelper {

    public static Connection getMySqlConnection(){
        //logic
        return null;
    }

    public void generateMySqlHtmlReport(String tableName, Connection cnx){
        //lecture de table + génération du rapport HTML
        System.out.println("MySql HTML report..........");
    }

    public void generateMySqlPdfReport(String tableName, Connection cnx){
        //lecture de table + génération du rapport HTML
        System.out.println("MySql PDF report..........");
    }
}
