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
                // case "country" -> updateCountry(con);
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
}