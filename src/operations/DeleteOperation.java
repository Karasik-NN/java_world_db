package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteOperation {
Scanner scan = new Scanner(System.in);
public void delete(Connection con, String table) {
	try {
		switch(table) {
		case "city" -> deleteCity(con);
		//case "country" -> deleteCountry(con);
		//case "countrylanguage" -> deleteClanguage(con);
		default -> System.out.println("Neatbilstita tabula " + table);
		}
		
		
	}catch(SQLException e) {
		System.out.println("DELETE kluda" + e.getMessage());
	}
	
	
}
private void deleteCity(Connection con)throws SQLException{
	System.out.println("Noradi pilsetas id kuru dzest");
		int id = scan.nextInt();
		scan.nextLine();
		
		String sql = "DELETE FROM city WHERE ID =?";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println("City tabula dzesti "+rows+" ieraksti");
			                            
		}
}

}