import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Created on 23.11.2006 by mb
 *
 */

public class EasyDbConnector {

	public static void main(String args[]) throws Exception {

		// load the jdbc driver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		// show login dialog and wait for a correct database login
		LoginDialogView lg = new LoginDialogView();

		// get the database connection from the login dialog
		Connection conn = lg.getConn();
		
		// build a statement
		Statement stmt = conn.createStatement();

		// execute a query
		ResultSet rset = stmt.executeQuery("select * from emp");

		// get the results from query
		while (rset.next()) {
			System.out.println(rset.getString("EMPNO")+", "+ rset.getString("ENAME")+", "+ rset.getString("JOB")+", "+ rset.getString("HIREDATE"));
		}

		// close the connection 
		conn.close();
	}
}
