package baitap;

import java.util.List;

public class Bill implements ModelInterface {
    private String id;
    private String employee;
    private String customer;
    private List<Cosmetic> cosmetics;
    private double totalPrice;

    public Bill() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Cosmetic> getCosmetics() {
        return cosmetics;
    }

    public void setCosmetics(List<Cosmetic> cosmetics) {
        this.cosmetics = cosmetics;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
