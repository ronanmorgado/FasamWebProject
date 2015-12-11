package fasam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	Connection con;
	
	public static Connection getConnection(){
		Connection con=null;
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/fasam","root","1234");

		} catch (SQLException e) {
			System.out.printf("Não foi possivel conectar no banco:" + e.getMessage());			
		}
		return con;
	}

}
