# Product Information Management System

This project is a basic Java application that manages product information. It connects to a MySQL database and allows users to browse products, track expired food items, view top-selling products, and give reviews. The system is divided into several use cases, each with different functionality.

## Folder Structure

- `src`: Contains all the Java source files for the project.
- `lib`: (Optional) This folder is where you can store any required libraries or external dependencies.

## Use Cases

1. **Browsing Products**
   - **Actor**: Service Consumer
   - **Action**: Displays products categorized by their respective categories.
   - **Tables**: `Product`, `Category`

2. **Keeping Track of Expired Food Items**
   - **Actor**: Service Provider
   - **Action**: Keeps track of expired food items.
   - **Tables**: `Category`

3. **Top Products**
   - **Actor**: Service Provider/Consumer
   - **Action**: Displays the top-selling products.
   - **Tables**: `Sales`, `Product`, `Category`

4. **Review**
   - **Actor**: Service Consumer
   - **Action**: Allows users to give reviews for products.
   - **Tables**: `Review`

## Setup Instructions

1. **Prerequisites**
   - Install Java (JDK 8 or higher)
   - Install MySQL and create a database named `product_info`.
   - Ensure you have the MySQL JDBC driver available in your project.

2. **Database Configuration**
   - The system assumes that the following tables exist in the `product_info` database:
     - `Product`
     - `Category`
     - `Sales`
     - `Review`
   - You should configure your MySQL connection details in the `mainproj.java` file (URL, username, password).

3. **Running the Project**
   - Compile and run the Java program:
     ```bash
     javac -d bin src/*.java
     java -cp bin mainproj
     ```

4. **Database Connection Details**
   - **URL**: `jdbc:mysql://localhost:3306/product_info`
   - **User**: `root`
   - **Password**: `ayushsql`

5. **Using the Application**
   - When the program runs, you will be presented with several options:
     - **0**: Browse All Products
     - **1**: Browse Products by Category
     - **2**: View Top Selling Products
     - **3**: Submit a Product Review
     - **4**: Track Expired Food Items
     - **5**: View Options Again
     - **-1**: Exit the Program

## Key Classes and Methods

### `mainproj.java`
This is the main entry point of the application where the database connection is established and options are presented to the user.

### `Allproduct.java`
Handles the functionality to browse all products.

### `BrowsingInput.java`
Handles the functionality to browse products by category.

### `TopSelling.java`
Displays the top-selling products based on sales data.

### `ReviewsInput.java`
Allows users to submit reviews for products.

### `CheckExpireFood.java`
Tracks expired food items.

### `Options.java`
Displays available options for the user to choose from.

## Dependencies
- **MySQL JDBC Driver**: Ensure that the MySQL JDBC driver is added to the project’s classpath.
