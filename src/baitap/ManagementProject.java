package baitap;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManagementProject {

    public static void main(String[] args) throws IOException {
        ManagementProject ql = new ManagementProject();
        ql.handleOption();
    }

    public void handleOption() {
        System.out.println(
                "1. Cosmetics" +
                        "\n 2. Employee" +
                        "\n 3. Customer" +
                        "\n 4. Bill" +
                        "\n 5. Role" +
                        "\n Select one number of these following option numbers: "
        );
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1 -> handleCosmetic();
            case 2 -> handleEmployee();
            case 3 -> handleCustomer();
            case 4 -> handleBill();
            case 5 -> handleRole();
            default -> System.out.println("Please select one of these numbers to process option: 1,2,3,4,5");
        }

    }

    public void handleCosmetic() {
        CosmeticManagement cosmeticManagement = new CosmeticManagement();
        List<Cosmetic> cosmeticList = cosmeticManagement.findAll();
        System.out.println("Cosmetics:");

    }

    public void handleEmployee() {

    }

    public void handleCustomer() {

    }

    public void handleBill() {

    }

    public void handleRole() {

    }
}
