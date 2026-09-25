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
		case "country"-> insertCountry(con);
		case "countrylanguage"-> insertCountryLanguage(con);
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
			System.out.println("City tabula ievetotas "+ rows + " rindas");
		}
		
	}
	
private void insertCountry(Connection con)throws SQLException{
		
		System.out.println("Ievadi Valsts codu (3 simboli)");
		String code = scan.nextLine();
		System.out.println("Ievadi valsts nosaukumu");
		String vname = scan.nextLine().trim().toUpperCase();
		System.out.println("Noradi kontinentu");
		String vcontinent = scan.nextLine();
		System.out.println("Noradi regionu ");
		String vregion = scan.nextLine();	
		System.out.println("Ievadi virsmas laukumu");
		int area = Integer.parseInt(scan.nextLine().trim());
		System.out.println("Ievadi Neatkarību gadu");
		int vgags = Integer.parseInt(scan.nextLine().trim());
		System.out.println("Ievadi iedzivotaju skaitu");
		int vpop = Integer.parseInt(scan.nextLine().trim());
		System.out.println("Ievadi Videjo dzivibas garumu");
		double vdzgar = scan.nextDouble();
		scan.nextLine();
		System.out.println("Ievadi lokalu nosaukumu");
		String LName = scan.nextLine().trim().toUpperCase();
		System.out.println("Ievadi Valdības veidlapa");
		String GName = scan.nextLine();
		System.out.println("Ievadi Valsts vadītāju");
		String VName = scan.nextLine();
		System.out.println("Ievadi Kapitālu");
		int kapitals = Integer.parseInt(scan.nextLine().trim());
		System.out.println("Ievadi Valsts kodu2 (2 simboli)");
		String code2 = scan.nextLine();
		
		String sql=
				"INSERT INTO country(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population,LifeExpectancy, LocalName, GovernmentForm, HeadOfState, Capital, Code2) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,code);
			ps.setString(2, vname);
			ps.setString(3, vcontinent);
			ps.setString(4, vregion);
			ps.setInt(5, area);
			ps.setInt(6, vgags);
			ps.setInt(7, vpop);
			ps.setDouble(8, vdzgar);
			ps.setString(9, LName);
			ps.setString(10, GName);
			ps.setString(11, VName);
			ps.setInt(12, kapitals);
			ps.setString(13, code2);
			int rows = ps.executeUpdate();
			System.out.println("Country tabula ievetotas "+ rows + " rindas");
		}
		
	}
private void insertCountryLanguage(Connection con)throws SQLException{
	
	System.out.println("Ievadi CountryCode (3 simboli)");
	String Ccode = scan.nextLine();
	System.out.println("Ievadi Valodu");
	String valoda = scan.nextLine().trim().toUpperCase();
	System.out.println("Noradi vai valoda ir oficiala(T vai F)");
	String ofic = scan.nextLine();
	System.out.println("Noradi procentus");
	Double proc = scan.nextDouble();
	scan.nextLine();
	
	String sql=
			"INSERT INTO CountryLanguage(CountryCode, Language, IsOfficial, Percentage) VALUES(?,?,?,?)";
	try(PreparedStatement ps = con.prepareStatement(sql)){
		ps.setString(1,Ccode);
		ps.setString(2, valoda);
		ps.setString(3, ofic);
		ps.setDouble(4, proc);
		int rows = ps.executeUpdate();
		System.out.println("City tabula ievetotas "+ rows + " rindas");
	}
	
}
}
