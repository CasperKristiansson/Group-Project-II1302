package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
    Connection connection = null;
    String connectionString;

    Database() throws IOException {
        InputStream input = new FileInputStream("src\\main\\databaseCredentials.properties");
        Properties prop = new Properties();
        prop.load(input);

        this.connectionString = prop.getProperty("connectionString");
    }

    public void connect() throws Exception {
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(this.connectionString);
        }
    }

    public void disconnect() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}