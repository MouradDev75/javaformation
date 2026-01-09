package fr.dawan.designspatterns.structure.facade;

import java.sql.Connection;

public class FacadeHelper {
     /*
        Facade propose en sortie des méthodes répondant aux besoins de l'application principale
    */

    public enum DbType{
        ORACLE,
        MYSQL
    }

    public enum ReportType{
        HTML,
        PDF
    }

    public static void generateReport(DbType dbType, ReportType reportType, String tableName){

        Connection cnx = null;
        switch (dbType){
            case MYSQL:
                cnx = MySqlHelper.getMySqlConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType){
                    case HTML:
                        mySqlHelper.generateMySqlHtmlReport(tableName, cnx);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPdfReport(tableName, cnx);
                        break;
                }
                break;

            case ORACLE:
                cnx = OracleHelper.getOraclelConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType){
                    case HTML:
                        oracleHelper.generateOracleHtmlReport(tableName, cnx);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePdfReport(tableName, cnx);
                        break;
                }

                break;
        }

    }
}
