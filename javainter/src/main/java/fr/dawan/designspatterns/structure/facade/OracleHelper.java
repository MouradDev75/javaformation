package fr.dawan.designspatterns.structure.facade;

import java.sql.Connection;

public class OracleHelper {

    public static Connection getOraclelConnection(){
        //logic
        return null;
    }

    public void generateOracleHtmlReport(String tableName, Connection cnx){
        //lecture de table + génération du rapport HTML
        System.out.println("Oracle HTML report..........");
    }

    public void generateOraclePdfReport(String tableName, Connection cnx){
        //lecture de table + génération du rapport HTML
        System.out.println("Oracle PDF report..........");
    }
}
