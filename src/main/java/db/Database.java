package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	
	private Connection c;
	
	private Database() {


        Properties connectionProps = new Properties();
        connectionProps.put("user", "SA");
        try {
            c = DriverManager.getConnection("jdbc:h2:~/test", connectionProps);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        //Operaciones aqui
        
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
}
