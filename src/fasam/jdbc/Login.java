package fasam.jdbc;

import java.sql.*;

public class Login {
	public static boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=Conexao.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from pessoas where email=? and senha=md5(?)");

			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}