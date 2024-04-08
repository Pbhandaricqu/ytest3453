import java.util.InputMismatchException;
import java.util.Scanner;

class Car {
    private String model;
    private String year;
    private double price;

    public Car(String model, String year, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}

public class CarExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String model, year;
        double price;

        do {
            try {
                System.out.print("Enter the model: ");
                model = scanner.nextLine();

                System.out.print("Enter the year: ");
                year = scanner.nextLine();

                System.out.print("Enter the price: ");
                price = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                Car car = new Car(model, year, price);
                System.out.printf("New car model: %s year: %s price: $%.2f%n", car.getModel(), car.getYear(), car.getPrice());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Price must be a number > 0");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (true);

        scanner.close();
    }
}
