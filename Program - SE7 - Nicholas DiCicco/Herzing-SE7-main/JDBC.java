package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {
	
	// object attributes
	final private static String url = "jdbc:mysql://localhost:3306/ordermanagementsystem";
	final private static String username = "gus_team";
	final private static String password = "password1234";
	private static Connection conn;
	
	
	
	// JDBC private constructor
	private JDBC () {}//end constructor Date
	
	
	
	// open database
	protected static void connect() {
		try { conn = DriverManager.getConnection(url, username, password); }
		catch (SQLException e) { e.printStackTrace(); }
	}//end method connect

	
	// close database
	protected static void close() {
		try { conn.close(); }
		catch (SQLException e) { e.printStackTrace(); }
	}//end method close
	


	// ======================================================================================	
	// -------------------------------------- PRODUCTS --------------------------------------
	// ======================================================================================
	
	
	
	// load products
	public static ArrayList<Product> loadProducts() {
		ArrayList<Product> product_list = new ArrayList<>();
		String query = "SELECT id, name, sku, quantity, price FROM product";
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Product product = new Product(result.getInt("id"),result.getString("name"), result.getString("sku"), result.getInt("quantity"), result.getDouble("price"));
				product_list.add(product);
			}//end while loop
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch
				
		return product_list;
	}//end method loadProducts
	
	
	
	// load product with product id
	public static Product loadProduct(int id) {
		Product product = new Product();
		String query = "SELECT id, name, sku, quantity, price FROM product WHERE id = ?";
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, id);
			ResultSet result = prep.executeQuery();
			while(result.next()) {
				product.setID(result.getInt("id"));
				product.setName(result.getString("name"));
				product.setSku(result.getString("sku"));
				product.setQuantity(result.getInt("quantity"));
				product.setPrice(result.getDouble("price"));
			}//end while loop
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch
		
		return product;
	}//end method loadProduct
	
	
	
	// add product
	public static int addProduct(Product product) {
		int lastID = JDBC.getMaxID() + 1;
		String sql = "INSERT INTO product (name, sku, quantity, price) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement prep = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prep.setString(1, product.getName());
			prep.setString(2, product.getSku());
			prep.setInt(3, product.getQuantity());
			prep.setDouble(4, product.getPrice());
			prep.executeUpdate();
			ResultSet result = prep.getGeneratedKeys();
			if (result.next()) {
				lastID = result.getInt(1);
			}
		
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch
		return lastID;
	}//end method addProduct

	
	
	// update product
	public static void updateProduct(String sql) {
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch
	}//end updateProduct
	
	
	
	// delete product
	public static int deleteProduct(int id) {
		int rows_affected = 0;
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			rows_affected = prep.executeUpdate();
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch
		return rows_affected;
	}//end method deleteProduct
	
	
	
	// count products
	public static int countProducts() {
		int count = 0;
		String query = "SELECT COUNT(*) FROM product";
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				count = result.getInt(1);
			}//end while loop
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch 

		return count;
	}//end method countProducts

	
	
// get max product id
	public static int getMaxID() {
		int maxID = 0;
		String query = "SELECT MAX(id) FROM product";
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				maxID = result.getInt(1);
			}//end while loop
		}//end try
		catch (SQLException e) { e.printStackTrace(); }//end catch 

		return maxID;
	}//end method getMaxID
	
		
}//end class JDBC
