import java.sql.*;
import java.util.Scanner;

public class TopSelling {
    static Scanner sc = new Scanner(System.in);

    public static void topsellingproducts(Connection conn) throws SQLException {
        String query = "select productid, sum(qtysold) as total_sold " +
                       "from sales " +
                       "group by productid " +
                       "order by total_sold desc";

        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        int a = 0;

        while (rs.next() && a < 3) {
            int qtysold = rs.getInt("total_sold");
            int prodId = rs.getInt("productid");

            String query2 = "select name, qty, categoryname from product " +
                            "join category on category.categoryid = product.categoryid " +
                            "where product.id = ?";
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setInt(1, prodId);
            ResultSet rs2 = stmt2.executeQuery();

            if (rs2.next()) {
                String prodname = rs2.getString("name");
                String category = rs2.getString("categoryname");
                int qty = rs2.getInt("qty");
                System.out.println();
                System.out.println("Top Selling Product #" + (a + 1));
                System.out.println("Product Name: " + prodname);
                System.out.println("Category Name: " + category);
                System.out.println("Quantity Sold: " + qtysold);
                System.out.println("Available Quantity: " + qty);
                
                a++;
            }
          
            rs2.close();
            stmt2.close();
        }

        if(a != 3){
            System.out.println();
            System.out.println("CURRENTLY WE HAVE NOT SOLD MORE THAN " + a + " PRODUCTS");
        }
        System.out.println();

        rs.close();
        stmt.close();
    }
}
