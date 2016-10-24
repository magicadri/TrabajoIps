package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Database {
	
	private Connection c;
	private DatabaseTables dt;
	private Defaultdata dd;
	private static Database instance;
	
	public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
	
	public Connection getC() {
		return c;
	}

	private Database() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "SA");
        try {
            c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", connectionProps);
            
            // Crear las tablas
            dt = new DatabaseTables(c);
            //dt.crearTablas();
            
            // add de algunos datos para probar funcionalidades
            dd = new Defaultdata(c);
            //dd.addData();
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
}
