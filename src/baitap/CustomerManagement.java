package baitap;

import java.util.List;
import java.util.Scanner;

public class CustomerManagement extends AbstractManagement<Customer> {

    @Override
    public String getFileName() {
        return "customer.txt";
    }

    @Override
    public String getTempFileName() {
        return "customerTemp.txt";
    }

    @Override
    public Customer getObjectFromFile(String[] strings) {
        Customer customer = new Customer();
        customer.setId(strings[0]);
        customer.setFullName(strings[1]);
        customer.setPhoneNumber(strings[2]);
        customer.setAddress(strings[3]);
        return customer;
    }

    @Override
    protected String generateObjectAsString(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.getId()).append(",")
                .append(customer.getFullName()).append(",")
                .append(customer.getPhoneNumber()).append(",")
                .append(customer.getAddress());
        return sb.toString();
    }

    public void displayList(List<Customer> customerList) {
        System.out.println("Customer list:");
        System.out.println(
                String.format("%-36s | %-25s | %-10s | %-100s",
                        "Customer ID", "Full Name", "Phone", "Address")
        );
        customerList.forEach(this::console);
    }

    public void displaySingle(Customer customer) {
        System.out.println("Customer's information");
        System.out.println(
                String.format("%-36s | %-25s | %-10s | %-100s",
                        "Customer ID", "Full Name", "Phone", "Address")
        );
        console(customer);
    }

    private void console(Customer customer) {
        System.out.println(
                String.format("%-36s | %-25s | %-10s | %-100s",
                        customer.getId(), customer.getFullName(), customer.getPhoneNumber(), customer.getAddress())
        );
    }

    @Override
    protected Customer input() {
        System.out.println(
                "Input customer's information"
        );
        Customer customer = new Customer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Full name: ");
        customer.setFullName(sc.nextLine());
        System.out.print("Phone Number: ");
        customer.setPhoneNumber(sc.nextLine());
        System.out.print("Address: ");
        customer.setAddress(sc.nextLine());
        return customer;
    }
}
