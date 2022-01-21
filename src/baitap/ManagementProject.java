package baitap;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManagementProject {

    public static void main(String[] args) throws IOException {
        ManagementProject ql = new ManagementProject();
        ql.handleOption();
    }

    public void handleOption() throws IOException {
        System.out.print(
                "1. Cosmetics" +
                        "\n2. Employee" +
                        "\n3. Customer" +
                        "\n4. Bill" +
                        "\n5. Role" +
                        "\nSelect one number of these following option numbers: "
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

    public void handleCustomer() throws IOException {
        CustomerManagement customerManagement = new CustomerManagement();
        List<Customer> customers = customerManagement.findAll();
        customerManagement.displayList(customers);
        System.out.print(
                "Select one these following option: " +
                        "\n1. Add customer" +
                        "\n2. Update customer" +
                        "\n3. Remove customer" +
                        "\n4. Find Customer" +
                        "\n0. Main menu" +
                        "\nOptions(1,2,3,0): "
        );
        Scanner sc = new Scanner(System.in);
        int cusOption = sc.nextInt();
        switch (cusOption) {
            case 1 -> {
                Customer customer = customerManagement.inputForAddNew();
                customerManagement.add(customer);
                handleCustomer();
            }
            case 2 -> {
                System.out.print(
                        "Update customer process:" +
                                "\nInput customer'ID: "
                );
                Scanner updateSc = new Scanner(System.in);
                String customerId = updateSc.nextLine();
                Customer updatedCustomer = customerManagement.findById(customerId);
                if (updatedCustomer == null) {
                    System.out.println("Customer not found");
                } else {
                    customerManagement.displaySingle(updatedCustomer);
                    Customer customer1 = customerManagement.inputForUpdate();
                    updatedCustomer.setAddress(customer1.getAddress());
                    updatedCustomer.setPhoneNumber(customer1.getPhoneNumber());
                    updatedCustomer.setFullName(customer1.getFullName());
                    customerManagement.update(updatedCustomer);
                }
                handleCustomer();
            }
            case 3 -> {
                System.out.print(
                        "Remove customer process" +
                                "\nInput removed customer'ID: "
                );
                Scanner deleteSc = new Scanner(System.in);
                String removedCustomerId = deleteSc.nextLine();
                Customer removedCustomer = customerManagement.findById(removedCustomerId);
                if (removedCustomer == null) {
                    System.out.println("Not found customer");
                } else {
                    customerManagement.displaySingle(removedCustomer);
                    customerManagement.delete(removedCustomerId);
                }
                handleCustomer();
            }
            case 4 -> {
                System.out.print(
                        "Find customer process" +
                                "\nInput customer'ID: "
                );
                Scanner findSc = new Scanner(System.in);
                String cusId = findSc.nextLine();
                Customer foundCustomer = customerManagement.findById(cusId);
                if (foundCustomer == null) {
                    System.out.println("Not found customer");
                } else {
                    customerManagement.displaySingle(foundCustomer);
                }
                handleCustomer();
            }
            case 0 -> handleOption();
            default -> handleCustomer();
        }
    }

    public void handleBill() {

    }

    public void handleRole() {

    }
}
