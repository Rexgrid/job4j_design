package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Config config = new Config("app.properties");
            config.load();
            connection = DriverManager.getConnection(config.value("url"), config.value("login"),
                    config.value("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private Statement createStatement() throws Exception {
            initConnection();
            return connection.createStatement();
        }

    public void createTable(String tableName) throws Exception {
          Statement statement = createStatement();
            String sql = String.format("create table if not exist %s(%s);",
                    tableName,
                    "id serial primary key");
                 statement.execute(sql);
    }

    public void dropTable(String tableName) throws Exception {
        Statement statement = createStatement();
            String sql = String.format("drop table %s;",
                    tableName);
            statement.execute(sql);

    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        Statement statement = createStatement();
            String sql = String.format("alter table %s add column %s %s;",
                    tableName,
                    columnName,
                    type);
            statement.execute(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        Statement statement = createStatement();
            String sql = String.format("alter table %s drop column %s;",
                    tableName,
                    columnName);
            statement.execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        Statement statement = createStatement();
            String sql = String.format("alter table %s rename column %s to %s",
                    tableName,
                    columnName,
                    newColumnName);
            statement.execute(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }


    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}

