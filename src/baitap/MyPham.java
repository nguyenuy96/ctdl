package baitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MyPham {
    private String maMP;
    private String tenMP;
    private String xuatXu;
    private double donGiaNhap;
    private double donGiaBan;
    private int soLuongDaBan;
    private int soLuong;
    private double thanhTien;

    public MyPham() {

    }

    public String getMaMP() {
        return maMP;
    }

    public void setMaMP(String maMP) {
        this.maMP = maMP;
    }

    public String getTenMP() {
        return tenMP;
    }

    public void setTenMP(String tenMP) {
        this.tenMP = tenMP;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(double donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public MyPham nhapMyPham(boolean isUpdated) {
        MyPham myPham = new MyPham();
        Scanner sc = new Scanner(System.in);
        if (isUpdated) {
            System.out.println("Ma MP: ");
            myPham.setMaMP(sc.nextLine());
        }
        System.out.print("Ten My Pham: ");
        myPham.setTenMP(sc.nextLine());
        System.out.print("Xuat xu: ");
        myPham.setXuatXu(sc.nextLine());
        System.out.println("Don Gia Nhap: ");
        myPham.setDonGiaNhap(sc.nextDouble());
        sc.nextLine();
        System.out.println("So Luong Nhap: ");
        myPham.setSoLuong(sc.nextInt());
        return myPham;
    }

    public void themMP(MyPham myPham) throws IOException {

        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fstream = new FileWriter("mypham.txt", true);
            bufferedWriter = new BufferedWriter(fstream);
            StringBuilder sb = new StringBuilder();
            this.maMP = UUID.randomUUID().toString();
            sb.append(myPham.getMaMP()).append(",")
                    .append(myPham.getTenMP()).append(",")
                    .append(myPham.getXuatXu()).append(",")
                    .append(myPham.getDonGiaBan()).append(",")
                    .append(myPham.getSoLuong());
            bufferedWriter.write("\n" + sb.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();;
            }
        }
    }

    public void xoaMP(String maMP) throws IOException {
        File file = new File("mypham.txt");
        File tempFile = new File("myphamTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(currentLine.contains(maMP)) continue;
            writer.write(currentLine + "\n");
        }
        writer.close();
        reader.close();
        file.delete();
        tempFile.renameTo(file);
    }

    public void chinhSuaMP(MyPham myPham) throws IOException {
        File file = new File("mypham.txt");
        File tempFile = new File("myphamTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(currentLine.contains(myPham.getMaMP())) {
                String[] strings = currentLine.split(",");
                StringBuilder sb = new StringBuilder();
                sb.append(myPham.getMaMP()).append(",")
                        .append(myPham.getTenMP()).append(",")
                        .append(myPham.getXuatXu()).append(",")
                        .append(myPham.getDonGiaBan()).append(",")
                        .append(myPham.getSoLuong());
                writer.write(sb.toString() + "\n");
            } else {
                writer.write(currentLine + "\n");
            }
        }

        writer.close();
        reader.close();
        file.delete();
        tempFile.renameTo(file);
    }

    public List<MyPham> danhSachMP() {
        List<MyPham> danhSachMP = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("mypham.txt"))) {
            //skip read the first line
            reader.readLine();
            String str;

            while ((str = reader.readLine()) != null) {
                String[] strList = str.split(",");
                MyPham myPham = new MyPham();
                myPham.setMaMP(strList[0]);
                myPham.setTenMP(strList[1]);
                myPham.setXuatXu(strList[2]);
                myPham.setDonGiaNhap(Double.parseDouble(strList[3]));
                myPham.setSoLuong(Integer.parseInt(strList[4]));
                danhSachMP.add(myPham);
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return danhSachMP;
    }
}
