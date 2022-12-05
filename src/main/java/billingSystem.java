// Shopping bill Calculator
import java.util.*;
import java.text.SimpleDateFormat;
class Products {

    // Properties
    private String id;
    private int quantity;
    private double price;
    private double totalPrice;
    private String productsName;

    // Constructor
    Products(String id, int quantity, double price, double totalPrice, String productsName) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.productsName = productsName;
    }

    //getter Methods
    public String getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public String getProductsName() {
        return productsName;
    }

    // Layout
    public static void displayFormat() {
        System.out.format("----------------------------------------------------------------------------");
        System.out.print("\nProd-ID \tName \tQuantity \tRate \t\t\t\t\tTotal Amount\n");
        System.out.format("----------------------------------------------------------------------------");
    }

    // Display results
    public void display() {
        System.out.format("\n%-9s %-9s %5d %9.2f \t\t\t\t %14.2f\n", id, productsName, quantity, price, totalPrice);
    }
}
public class billingSystem {

    public static void main(String[] args) {
        // Variables
        String id = null;
        String productsName = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overallPrice = 0.0;
        double vatChrg, servChrg, subtotal = 0.0, discount = 0.0;
        char selection = '\0';
        System.out.println("\t----------Invoice----------");
        System.out.println("\t " + " " + "Sirius Supermarket");
        System.out.println("\t 369 Andromeda Galaxy");

        //Date & Time Format
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Date & time Output
        System.out.println("\nDate: " + formatter.format(date) + " " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);

        Scanner scan = new Scanner(System.in);
        System.out.println("\nName of the Customer: ");
        String customerName = scan.nextLine();

        // Scanner class Object
        //An ArrayList to store the product
        List<Products> product = new ArrayList<Products>();
        char choice;
        do {
            // Read input
            System.out.println("\nEnter the product details: ");

            System.out.println("\nProduct ID: ");
            id = scan.nextLine();

            System.out.println("\nProduct Name: ");
            productsName = scan.nextLine();

            System.out.println("\nQuantity: ");
            quantity = scan.nextInt();

            System.out.println("\nPrice (per unit): ");
            price = scan.nextDouble();

            // Calculate total Price for the specific product
            totalPrice = price * quantity;

            // Calculate overall price
            overallPrice = overallPrice + totalPrice;

            // Product class object and add it to list
            product.add(new Products(id, quantity, price, totalPrice, productsName));

            // Ask for continue shopping?
            System.out.println("Want to add more items?(Y or N): ");

            // Reads a character Y or N
            choice = scan.next().charAt(0);

            // Read remaining characters
            scan.nextLine();
        }
        while (choice == 'Y' || choice == 'y');

        // Display all products with its properties
        Products.displayFormat();
        for (Products p : product) {
            p.display();
        }

        // Price calculation
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t      Total Amount: " + overallPrice + " €");

        // Discount calculation
        discount = overallPrice * 2.5/100;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Discount: " + discount + " €");

        // Total Price after discount
        subtotal = overallPrice - discount;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal: " + subtotal + " €");

        // Service charge and VAT calculation
        servChrg = overallPrice * 1.5/100;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Service(1.5%): " + servChrg + " €");

        vatChrg = overallPrice * 19/100;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t   VAT charge(19%): " + vatChrg + " €");

        // Total amount to be paid
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total: " + (subtotal + servChrg + vatChrg) + " €");
        System.out.println("\n\t\t\t\t-----Thank you for visiting us!!!-----");

        // close scanner
        scan.close();
    }
}
