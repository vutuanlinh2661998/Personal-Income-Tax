/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//Mã số thuế
public class TaxCode {
    private int taxcode;  //Mã số thuế cá nhân.
    private int userID;//CMND or căn cước
    private String name;
    private String sex;
    private String nationality;
    private String phone;
    private String email;
    private String address;
    private boolean  status; //Trạng thái True (mã số thuế vẫn còn hiệu lực) or False, 

    public TaxCode(int taxcode, int userID, String name, String sex, String nationality, String phone, String email, String address, boolean status) {
        this.taxcode = taxcode;
        this.userID = userID;
        this.name = name;
        this.sex = sex;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public TaxCode() {
    }

    public TaxCode(int code, String name, String sex, String nationality, String phone, String email, String adress, boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(int taxcode) {
        this.taxcode = taxcode;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
