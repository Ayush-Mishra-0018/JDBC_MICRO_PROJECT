import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Allproduct {
     static void browsingAll(Connection conn) throws SQLException {
        String query = "Select name, qty from product join category on product.categoryid = category.categoryid";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        int c = 1;

        while (rs.next()) {
            System.out.println();
            String name = rs.getString("name");
            int qty = rs.getInt("qty");

            System.out.println("Details For Product# " + c + " are as follow:-");
            System.out.println("Product Name: " + name);
            System.out.println("Available Quantity: " + qty);
            c++;
        }

        System.out.println();
        rs.close();
        stmt.close();
    }
}
