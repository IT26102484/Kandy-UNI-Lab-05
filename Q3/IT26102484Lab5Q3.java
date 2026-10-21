import java.util.Scanner;

public class IT26102484Lab5Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double ROOM_CHARGE = 48000.00;
        final double DISCOUNT_3_TO_4_DAYS = 10.0;
        final double DISCOUNT_5_OR_MORE_DAYS = 20.0;

        System.out.print("Enter the start date (day): ");
        int startDate = input.nextInt();

        System.out.print("Enter the end date (day): ");
        int endDate = input.nextInt();

        // Validation 1
        if (startDate < 1 || startDate > 31 ||
            endDate < 1 || endDate > 31) {
            System.out.println("Error: Dates must be between 1 and 31.");
            input.close();
            return;
        }

        // Validation 2
        if (startDate >= endDate) {
            System.out.println("Error: Start date should be less than end date.");
            input.close();
            return;
        }

        int daysReserved = endDate - startDate;
        double totalAmount = daysReserved * ROOM_CHARGE;
        double discountRate = 0;

        if (daysReserved >= 5) {
            discountRate = DISCOUNT_5_OR_MORE_DAYS;
        } else if (daysReserved >= 3) {
            discountRate = DISCOUNT_3_TO_4_DAYS;
        }

        double discountAmount = totalAmount * discountRate / 100;
        double amountToPay = totalAmount - discountAmount;

        System.out.println("Number of days reserved: " + daysReserved);
        System.out.println("Total room charges: Rs. " + totalAmount);
        System.out.println("Discount rate: " + discountRate + "%");
        System.out.println("Discount amount: Rs. " + discountAmount);
        System.out.println("Total amount to be paid: Rs. " + amountToPay);

        input.close();
    }
}