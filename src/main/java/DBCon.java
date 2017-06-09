import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

import static java.sql.DriverManager.*;

/**
 * Created by dkuzmich on 5/26/2017.
 */
public class DBCon {
    private String URL = "jdbc:mysql://localhost:3306/testsh";
    private String UserDB = "root";
    private String PassDB = "12345";
    public Connection connection = null;
    public Statement statement =null;



    public void dbConnectio() {
        try {

            connection = getConnection(URL, UserDB, PassDB);
            statement= connection.createStatement();
            System.out.println("!!!!!!!!!!!Connected to DB Sucessfully!!!!!!!!!");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void getDatafromDB(){
        String SqlStatement="Select UName, UPass from testtable";
        try {
            ResultSet resultSet=statement.executeQuery(SqlStatement);
            while(resultSet.next()){
            String tName=resultSet.getString("UName");
            String tPass=resultSet.getString("Upass");
                System.out.println("Login= "+tName+" Pass= " + tPass);

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("!!!!!!!!! DB internal erroor");
        }


    }

}




