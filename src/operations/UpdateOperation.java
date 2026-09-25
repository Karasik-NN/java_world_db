package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperation {
    static Scanner scan = new Scanner(System.in);

    public void update(Connection con, String table) {
        try {
            switch(table) {
                case "city" -> updateCity(con);
                case "country" -> updateCountry(con);
                // case "countrylanguage" -> updatecountrylanguage(con);
            }
        } catch(SQLException e) {
            System.out.println("UPDATE Kluda: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("Kluda: Jāievada derīgs skaitlis!");
        }
    }

    private void updateCity(Connection con) throws SQLException {
        System.out.println("Kuru pilsetu labot? (Noradi ID)");
        int id = Integer.parseInt(scan.nextLine().trim());

        System.out.println("Noradi pilsetas nosaukumu");
        String name = scan.nextLine().trim();

        System.out.println("Noradi valsts kodu (3 simboli)");
        String countrycode = scan.nextLine().trim().toUpperCase();

        System.out.println("Noradi apgabalu");
        String district = scan.nextLine().trim();

        System.out.println("Noradi iedzivotaju skaitu");
        int population = Integer.parseInt(scan.nextLine().trim());

        String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, countrycode);
            ps.setString(3, district);
            ps.setInt(4, population);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();
            System.out.println("City atjauninats: " + rows + " rindas");
        }
    }
private void updateCountry(Connection con)throws SQLException{
		
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
				"UPDATE country SET Code = ?, Name = ?, Continent = ?, Region = ?, SurfaceArea = ?, IndepYear = ?, Population = ?,LifeExpectancy = ?, LocalName = ?, GovernmentForm = ?, HeadOfState = ?, Capital = ? WHERE Code2 = ?";
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
}