package org.seminify.spring5fs.dbquery;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {
    private DataSource dataSource;

    public DbQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int count() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM MEMBER");
                resultSet.next();
                return resultSet.getInt(1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                }
        }
    }
}
