/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btvn1;

/**
 *
 * @author admin
 */
public class Student {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String className;
    private double diem_oop;               
    private double diem_qlda;  
    private double diem_hocmay;   
    private double diem_csdl;         
    private double diem_mobileApp;        

    
    
    public double diem_TB(){
        return (diem_oop + diem_qlda + diem_hocmay + diem_csdl + diem_mobileApp)/5;
    }
    
    public String xepLoai(){
        double tb = diem_TB();
         if (tb >= 8.5) {
            return "A";
        } else if (tb >= 7) {
            return "B";
        } else if (tb >= 5.5) {
            return "C";
        } else if (tb >= 4) {
            return "D";
        } else {
            return "<D";
        }
    }
    
    public Student() {
    }

    public Student(String firstName, String lastName, String birthdate, String address, String className, double diem_oop, double diem_qlda, double diem_hocmay, double diem_csdl, double diem_mobileApp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.diem_oop = diem_oop;
        this.diem_qlda = diem_qlda;
        this.diem_hocmay = diem_hocmay;
        this.diem_csdl = diem_csdl;
        this.diem_mobileApp = diem_mobileApp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getClassName() {
        return className;
    }

    public double getDiem_oop() {
        return diem_oop;
    }

    public double getDiem_qlda() {
        return diem_qlda;
    }

    public double getDiem_hocmay() {
        return diem_hocmay;
    }

    public double getDiem_csdl() {
        return diem_csdl;
    }

    public double getDiem_mobileApp() {
        return diem_mobileApp;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDiem_oop(double diem_oop) {
        this.diem_oop = diem_oop;
    }

    public void setDiem_qlda(double diem_qlda) {
        this.diem_qlda = diem_qlda;
    }

    public void setDiem_hocmay(double diem_hocmay) {
        this.diem_hocmay = diem_hocmay;
    }

    public void setDiem_csdl(double diem_csdl) {
        this.diem_csdl = diem_csdl;
    }

    public void setDiem_mobileApp(double diem_mobileApp) {
        this.diem_mobileApp = diem_mobileApp;
    }

    
    
}
