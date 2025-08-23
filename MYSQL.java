/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframe;

/**
 *
 * @author abesi
 */

    import java.sql.DriverManager;
    import java.sql.Connection;
    import java.sql.Statement;
    import java .sql.SQLException;
import java.sql.ResultSet;
    

public class MYSQL {
    private static final String DATABASE ="system";
    private static final String  USERNAME="root";
    private static String PASSWORD= "200651802829@Dew";
    private static Connection connection;
    
    public static Connection getConnection(){
            if(connection==null){
        try{
        
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE,USERNAME,PASSWORD);
            }catch(ClassNotFoundException | SQLException e){
                    e.printStackTrace();
                    }
        }
            return connection;
    }
    public static ResultSet execute(String query) throws SQLException{
        
        getConnection().createStatement();
        Statement smt =getConnection().createStatement();
        if(query.toUpperCase().startsWith("SELECT")){
            return smt.executeQuery(query);
        }else{
            smt.executeUpdate(query);
            return null;
        }
        
        
    }
}
