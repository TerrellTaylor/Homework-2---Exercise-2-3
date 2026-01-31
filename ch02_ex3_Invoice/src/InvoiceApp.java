import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);

        // perform invoice calculations until choice isn't equal to "y" or "Y" and record the number of invoices, the invoice average sum, and the discount average sum
        String choice = "y";
        int subtotalCount = 0;
        int invoiceAverageCount = 0;
        int discountAverageCount = 0;
        double invoiceAverage = 0;
        double discountAverage = 0;
        double invoiceAverageSum = 0;
        double discountAverageSum = 0;
        while (choice.equalsIgnoreCase("y")) {
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            String input = sc.nextLine();
            double subtotal = Double.parseDouble(input);
            subtotalCount++;

            // calculate the discount amount and total
            double discountPercent;
            if (subtotal >= 500) {
                discountPercent = .25;
                discountAverageCount++;
            } else if (subtotal >= 200) {
                discountPercent = .2;
                discountAverageCount++;
            } else if (subtotal >= 100) {
                discountPercent = .1;
                discountAverageCount++;
            } else {
                discountPercent = 0.0;
            }
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;
            invoiceAverageSum = invoiceAverageSum + total;
            invoiceAverageCount++;
            discountAverageSum = discountAverageSum + discountAmount;

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";            
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }

        // handle user input that isn't "n" or "N"
        while (!choice.equalsIgnoreCase("n")) {
            System.out.println("Invalid input.");
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        
        //calculate the average invoice amount and the average discount amount and then display them along with the number of invoices when the user ends the application
        invoiceAverage = invoiceAverageSum / invoiceAverageCount;
        discountAverage = discountAverageSum / discountAverageCount;
        if (choice.equalsIgnoreCase("n")) {
            String messageFinal = "Invoice count:    " + subtotalCount + "\n"
                                + "Invoice average:  " + invoiceAverage + "\n"
                                + "Discount average: " + discountAverage + "\n";
            System.out.println(messageFinal);
        }
    }
}