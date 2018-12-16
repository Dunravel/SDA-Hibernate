package pl.sda.app;

import java.sql.*;

public class ShopApp
{
    static final private String DB_URL = "jdbc:mysql://localhost/workerdb";
     static final private String USER = "worker";
     static final private String PASS = "workerpass";

    public static void main(String[] args) {

        // register mysql driver
        registerMysqlDriver();

        // establish connection
        Connection connection = getSqlConnection();

        // query execution
        Statement statement = null;

        try {

            statement = connection.createStatement();
            insertProduct(statement);
            boolean execute = statement.execute("SELECT product_id,name FROM Products;");
            System.out.println(execute);
            performQuery(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // closing connection
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Connection getSqlConnection(){
        try {
            return DriverManager.getConnection(DB_URL,USER,PASS);

             //Properties properties = new Properties();
       // properties.setProperty()
        //Connection connection = DriverManager.getConnection(DB_URL,properties);
        //

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void registerMysqlDriver(){
        Driver driver;
        try {
            driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void performQuery(Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT product_id,name FROM Products;");

            while(resultSet.next()){
                int product_id = resultSet.getInt("product_id");
                String name = resultSet.getString("name");

                System.out.println("Product with ID: " + product_id + " and name: " + name + ".");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void insertProduct(Statement statement){
        try {
            int inserted = statement.executeUpdate("INSERT INTO PRODUCTS VALUES" +
                       "(1,'123','first product', null);");
            System.out.println(inserted + " new products added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
