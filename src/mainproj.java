import java.sql.*;
import java.util.Scanner;

public class mainproj {

    static String url = "jdbc:mysql://localhost:3306/product_info";
    static String user = "root";
    static String pass = "ayushsql";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            //Setting Up Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("CONNECTION ESTABLISHED");
            Options.optionsavailable();

            while (true) {
                System.out.println("");
                int id = sc.nextInt();
                System.out.println("");

                sc.nextLine();
                if(id==0){
                    Allproduct.browsingAll(conn);
                }
                else if (id == 1) {
                    BrowsingInput.browsingInput(conn);
                } else if (id == 2) {
                    TopSelling.topsellingproducts(conn);
                } else if (id == 3) {
                    ReviewsInput.reviewsinput(conn);
                } else if (id == 4) {
                    CheckExpireFood.checkingExpireFoodItems(conn);
                } else if (id == -1) {
                    break;
                } else if (id == 5) {
                    Options.optionsavailable();
                } else {
                    System.out.println("INVALID INPUT TRY AGAIN");
                }
                System.out.println("ENTER 5 TO SEE OPTIONS AGAIN OR CONTINUE IF YOU REMEMBER");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
