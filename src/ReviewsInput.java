import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewsInput {
    static Scanner sc = new Scanner(System.in);

    static void reviewsinput(Connection conn) throws SQLException {
        String Query = "select id,name from product";
        PreparedStatement stmt = conn.prepareStatement(Query);
        ResultSet rs = stmt.executeQuery();
        int a = 1;
        ArrayList<Integer> prodlist = new ArrayList<>();
        
        while (rs.next()) {
            if (a == 1) {
                System.out.println("ENTER THE PRODUCT ID FROM THE FOLLOWING LIST TO ADD A REVIEW");
            }
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("");
            System.out.println("DETAILS FOR PRODUCT#" + a + ":-");
            System.out.println("ProductId: " + id);
            System.out.println("ProductName: " + name);
            prodlist.add(id);
            a++;
        }
        
        System.out.println("");
        int id = sc.nextInt();
        sc.nextLine();
        
        if (!prodlist.contains(id)) {
            System.out.println("INVALID ID SPECIFIED");
            return;
        }
        
        rs.close();
        stmt.close();
        Reviews.review(conn, id);
    }
}
