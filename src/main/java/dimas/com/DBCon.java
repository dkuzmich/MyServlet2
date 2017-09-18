package dimas.com;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.ArrayList;
import dimas.com.*;

import static java.sql.DriverManager.*;

/**
 * Created by dkuzmich on 5/26/2017.
 */
public class DBCon {
    private String URL = "jdbc:mysql://localhost:3306/userdb";
    private String UserDB = "root";
    private String PassDB = "12345";
    public Connection connection = null;
    public Statement statement =null;
    public User user;
    ArrayList userList=new ArrayList();


    public void dbConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, UserDB, PassDB);
            statement= connection.createStatement();
            System.out.println("!!!!!!!!!!!Connected to DB Sucessfully!!!!!!!!!");
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getDatafromDB(){
        String SqlStatement="SELECT name, email, country, password FROM users";
        try {
            ResultSet resultSet=statement.executeQuery(SqlStatement);
            while(resultSet.next()){

            String tname=resultSet.getString("name");
            String temeil=resultSet.getString("email");
            String tcountry=resultSet.getString("country");
            String  tpassword=resultSet.getString("password");

            System.out.println("!!!! name " +tname+" email "+temeil+" country "+ tcountry+ " pass "+tpassword);

            userList.add(new User(tname,temeil,tcountry,tpassword));

            }


        } catch (SQLException e1) {
           // e1.printStackTrace();
            System.out.println("!!!!!!!!! DB internal erroor");
        }


    }

    public void getUsetListfromDB(){
        int userListSize=userList.size();



        for(int i=0;i<userListSize;i++){
            System.out.println(userList.get(i).toString());
        }
    }

    public ArrayList getUsetListfromDBinListFormat(){
       return  userList;
        }


public String checkIfExistUserInDB(String tuser, String tEmail) {
    String SqlStatement = "SELECT name, email From users";

    if (statement == null) {
        dbConnection();

    }
        try {
            ResultSet resultSet = statement.executeQuery(SqlStatement);

            while (resultSet.next()) {
                if (tuser == resultSet.getString("name")) {
                    return "bad name";
                }
                if (tEmail == resultSet.getString("email")) {
                    return "bad mail";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    public void addRegisteredUserToDB(String name,String email, String country, String password){
        String SqlStatementAddUserToDb ="INSERT INTO users (name, email, country, password) VALUES (name,email,country,password) ";
        if (statement == null) {
            dbConnection();
        }
            try {
                ResultSet resultSet = statement.executeQuery(SqlStatementAddUserToDb);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        System.out.println("Data is added to DB");

    }

}










