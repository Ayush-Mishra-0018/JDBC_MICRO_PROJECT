import java.sql.*;

public class BrowseProduct {
    static void browsing(Connection conn, String Category) throws SQLException {
        String query = "Select name, qty from product join category on product.categoryid = category.categoryid where category.categoryname = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, Category);
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
        }
    }
}
