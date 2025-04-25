import java.sql.*;
import java.util.Scanner;

public class Reviews {
    static Scanner sc = new Scanner(System.in);

    static void review(Connection conn, int productId) throws SQLException {
        String selectQuery = "select currentrating, totalreviews from review where productid = ?";
        PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
        selectStmt.setInt(1, productId);
        ResultSet rs = selectStmt.executeQuery();

        System.out.println("ENTER THE RATING [0–5] OF THE PRODUCT WITH ID " + productId);
        float newRating = sc.nextFloat();
        sc.nextLine();

        if (newRating < 0 || newRating > 5) {
            System.out.println("INVALID RATING!!!");
            return;
        }

        if (rs.next()) {
            float currentRating = rs.getFloat("currentrating");
            int totalReviews = rs.getInt("totalreviews");
            int updatedReviews = totalReviews + 1;
            float updatedRating = (currentRating * totalReviews + newRating) / updatedReviews;

            String updateQuery = "update review set currentrating = ?, totalreviews = ? where productid = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setFloat(1, updatedRating);
            updateStmt.setInt(2, updatedReviews);
            updateStmt.setInt(3, productId);
            updateStmt.executeUpdate();
            updateStmt.close();
            conn.commit();
            System.out.println("REVIEW UPDATED SUCCESSFULLY");
        } else {
            String insertQuery = "insert into review (productid, currentrating, totalreviews) values (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, productId);
            insertStmt.setFloat(2, newRating);
            insertStmt.setInt(3, 1);
            insertStmt.executeUpdate();
            insertStmt.close();
            conn.commit();
            System.out.println("REVIEW ADDED SUCCESSFULLY");
        }

        rs.close();
        selectStmt.close();
        SeeReview.reviewForSelectedProduct(conn, productId);
    }
}
