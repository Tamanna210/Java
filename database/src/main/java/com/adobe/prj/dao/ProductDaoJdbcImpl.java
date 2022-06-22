package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {
	private static String DRIVER  = "com.mysql.cj.jdbc.Driver";	
	private static String URL ="jdbc:mysql://localhost:3306/java_bootcamp";
	private static String USER = "root";
	private static String PWD = "Welcome123";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	 
	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate(); // INSERT, DELETE, UPDATE
		} catch (SQLException e) {
			throw new DaoException("unable to add product", e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Product> getProducts() throws DaoException {
		List<Product> products = new ArrayList<>();
		String SQL = "SELECT id, name, price, quantity FROM products";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = con.createStatement();
			ResultSet rs  = stmt.executeQuery(SQL); // SELECT
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setPrice(rs.getDouble("PRICE"));
				p.setQuantity(rs.getInt("QUANTITY"));
				products.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			throw new DaoException("unable to get products", e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		// TODO
		String SQL = "SELECT id, name, price, quantity FROM products WHERE id = ?"; 
		return null;
	}

}
