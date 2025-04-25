import java.sql.*;
import java.time.LocalDate;

public class CheckExpireFood {
    static void checkingExpireFoodItems(Connection conn) throws SQLException {
        String query = "select id, name, expirydates from product join category on product.categoryid = category.categoryid where category.expirydates is not null";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        int a = 1;
        boolean found = false;

        while (rs.next()) {
            Date date = rs.getDate("expirydates");
            LocalDate expiryDate = date.toLocalDate();
            LocalDate today = LocalDate.now();
            String name = rs.getString("name");
            int id = rs.getInt("id");

            if (expiryDate.isBefore(today)) {
                if (!found) {
                    System.out.println("LIST OF EXPIRED FOOD ITEMS:-");
                    found = true;
                }
                System.out.println("DETAILS FOR EXPIRED FOOD ITEM #" + a + " :");
                System.out.println("Product Name: " + name);
                System.out.println("Product Id: " + id);
                System.out.println("Expiry Date: " + expiryDate);
                a++;
            }
        }

        if (!found) {
            System.out.println("NO EXPIRED FOOD ITEMS");
        }

        rs.close();
        stmt.close();
    }
}
