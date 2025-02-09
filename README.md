Vehicle Rental Management System
Overview:
This is a console based Java application where you can rent a vehicle efficiently. It has two types of users admins who can oversee the details and customers who can rent and return a vehicle that they want

Features:
For Administrators:
1. Add, remove, and update vehicle details.
2. Change customer roles (promote/demote to/from admin).
3. View a list of all available vehicles.

For Customers:
1. Search for a vehicle by ID.
2. Rent and return vehicles.
3. View a list of rented vehicles.

Supported Vehicle Types:
Cars
Motorbikes
Boats
Electric Scooters (unfortunately it is called Electro samokat (kazakh))

System Structure
The application is divided into several key classes:
Core Classes:
Panels.java – Manages the admin and customer panels, providing options like adding vehicles and updating statuses.
Vehicle.java – The base class for all vehicles, containing attributes like ID, brand, price, and availability.
RentalSystem.java – Handles database operations such as adding, removing, renting, and searchinsg for vehicles.
DatabaseHandler.java – Uses the Singleton pattern for database connectivity.
LoginSystem.java – Manages user authentication and redirects users based on their roles (admin or customer).

Vehicle-Specific Classes:
Car.java – Extends Vehicle
Boat.java –  Extends Vehicle
ElecSamokat.java –  Extends Vehicle           => super
Motorbike.java –  Extends Vehicle

Installation & Setup
Prerequisites:
1. Java JDK 8 or higher.
2. PostgreSQL installed and running.
3. Database tables (users, customers, admins, Vehicles) must be created.

Configuration:
Modify database connection details in DatabaseHandler.java and Panels.java:
String url = "jdbc:postgresql://localhost:5432/postgres";
String user = "postgres";
String password = "your_password";

Running the Application:
1. Compile all Java files and ensure the JDBC driver is included.
2. Run LoginSystem.java as the entry point.
3. Log in using the default admin credentials or create a new account.

How It Works
Admin Actions:
Log in as an admin.
Add, update, or remove vehicle details.
View a list of all available vehicles.
Promote/demote customers to admin.

Customer Actions:
Log in as a customer.
Search for a vehicle using its ID.
Rent and return vehicles.
View a list of rented vehicles.

Example Workflows
Admin Workflow:
1. Log in as an admin.
2. Add a new Car, specifying details like seating capacity and fuel type.
3. Retrieve a list of available vehicles.
4. Modify or remove a vehicle if needed.

Customer Workflow:
1. Log in as a customer.
2. Search for a Boat using its ID.
3. Rent the Boat if available.
4. Return the Boat after use.
