import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrowsingInput {
    static Scanner sc = new Scanner(System.in);

    static void browsingInput(Connection conn) throws SQLException {
        String Category;
        String query = "Select distinct categoryname from category";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        boolean isThere = false;
        int c = 1;
        ArrayList<String> cats = new ArrayList<>();

        while (rs.next()) {
            if (!isThere) {
                System.out.println("SELECT FROM THE FOLLOWING CATEGORY(ENTER THE CATEGORY NAME)");
            }
            isThere = true;
            String cat = rs.getString("categoryname");
            cats.add(cat);
            System.out.println("Option# " + c + " : " + cat);
            c++;
        }

        if (!isThere) {
            System.out.println("There Is Zero Products At The Moment");
        }

        System.out.println("");
        Category = sc.nextLine();

        if (!cats.contains(Category)) {
            System.out.println("INCORRECT CATEGORY SPECIFIED");
            return;
        }

        rs.close();
        stmt.close();

        BrowseProduct.browsing(conn, Category);
    }
}
