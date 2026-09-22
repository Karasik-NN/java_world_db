package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {
	static Scanner scan = new Scanner(System.in);
	public void insert(Connection con, String table) {
	try {
		switch(table) {
		case "city"-> insertCity(con);
		//case "country"-> insertCountry(con);
		//case "countrylanguage"-> insertCountryLanguage(con);
		}
	}catch(SQLException e) {
		System.out.println("INSERT kluda:"+e.getMessage());
	}
	}
	
	private void insertCity(Connection con)throws SQLException{
		
		System.out.println("Ievadi pilsetas nosaukumu");
		String name = scan.nextLine();
		System.out.println("Ievadi valsts kodu (3 simboli)");
		String countrycode = scan.nextLine().trim().toUpperCase();
		System.out.println("Noradi apgabalu");
		String district = scan.nextLine();
		System.out.println("Noradi iedzivotaju skaitu");
		int population = Integer.parseInt(scan.nextLine());
		
		String sql=
				"INSERT INTO city(Name, Countrycode, District, Population) VALUES(?,?,?,?)";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,name);
			ps.setString(2, countrycode);
			ps.setString(3, district);
			ps.setInt(4, population);
			int rows = ps.executeUpdate();
			System.out.println("City tabula ievetotas "+ rows + "rindas");
		}
		
	}
}
