package no.hvl.dat107.jpa;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private final String url = "jdbc:postgresql://data1.hib.no:5432/h571541";
	private final String user = "h571541";
	private final String password = "pass";
	private Connection conn;

	public Connection connect() {

		Connection conn = null;

		try {
			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Oops");
		}

		this.conn = conn;

		return conn;
	}

	public boolean isConnected() {
		try {
			conn.isValid(10000);
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}

	public static String sanitize(String s) {


		return s;
	}
}
