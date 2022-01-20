package baitap;

import java.util.Date;

public class Cosmetic implements ModelInterface {
    private String id;
    private String cosmeticName;
    private String cosmeticType;
    private String madeIn;
    private double inUnitPrice;
    private double outUnitPrice;
    private String dateIn;
    private int inAmount;
    private String dateOut;
    private int outAmount;
    private int totalInAmount;
    private int totalOutAmount;
    private int totalAmount;
    private double totalInUnitPrice;
    private double totalOutUnitPrice;

    public Cosmetic() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCosmeticName() {
        return cosmeticName;
    }

    public void setCosmeticName(String cosmeticName) {
        this.cosmeticName = cosmeticName;
    }

    public String getCosmeticType() {
        return cosmeticType;
    }

    public void setCosmeticType(String cosmeticType) {
        this.cosmeticType = cosmeticType;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public double getInUnitPrice() {
        return inUnitPrice;
    }

    public void setInUnitPrice(double inUnitPrice) {
        this.inUnitPrice = inUnitPrice;
    }

    public double getOutUnitPrice() {
        return outUnitPrice;
    }

    public void setOutUnitPrice(double outUnitPrice) {
        this.outUnitPrice = outUnitPrice;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public int getInAmount() {
        return inAmount;
    }

    public void setInAmount(int inAmount) {
        this.inAmount = inAmount;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public int getOutAmount() {
        return outAmount;
    }

    public void setOutAmount(int outAmount) {
        this.outAmount = outAmount;
    }

    public int getTotalInAmount() {
        return totalInAmount;
    }

    public void setTotalInAmount(int totalInAmount) {
        this.totalInAmount = totalInAmount;
    }

    public int getTotalOutAmount() {
        return totalOutAmount;
    }

    public void setTotalOutAmount(int totalOutAmount) {
        this.totalOutAmount = totalOutAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalInUnitPrice() {
        return totalInUnitPrice;
    }

    public void setTotalInUnitPrice(double totalInUnitPrice) {
        this.totalInUnitPrice = totalInUnitPrice;
    }

    public double getTotalOutUnitPrice() {
        return totalOutUnitPrice;
    }

    public void setTotalOutUnitPrice(double totalOutUnitPrice) {
        this.totalOutUnitPrice = totalOutUnitPrice;
    }
}
