import java.sql.*;

public class SeeReview {
    static void reviewForSelectedProduct(Connection conn, int productId) throws SQLException {
        String query = "select currentrating, totalreviews from review where productid = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, productId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String productQuery = "select name from product where id = ?";
            PreparedStatement prodStmt = conn.prepareStatement(productQuery);
            prodStmt.setInt(1, productId);
            ResultSet prodRs = prodStmt.executeQuery();

            String prodName = "Unknown Product";  
            if (prodRs.next()) {
                prodName = prodRs.getString("name");
            }

            float currentRating = rs.getFloat("currentrating");
            int totalReviews = rs.getInt("totalreviews");

            System.out.println("Review for Product: " + prodName);
            System.out.println("Product ID: " + productId);
            System.out.println("Current Rating: " + currentRating);
            System.out.println("Total Reviews: " + totalReviews);
            System.out.println();

            prodRs.close();
            prodStmt.close();
        } else {
            System.out.println("No reviews found for Product ID: " + productId);
        }

        rs.close();
        stmt.close();
    }
}
