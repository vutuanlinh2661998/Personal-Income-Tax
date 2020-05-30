/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author thaik
 */
public class TaxPayer {

    private int id;
    private TaxCode tax_code;
    //private String phone;
    // private String mail;
    private String bank;
    private String bankCode;
    private String currency;
    private Timestamp date;
    // private double total;
    // private String taxPeriod;
    private TaxDeclare taxDeclare;

    public TaxPayer(int id, TaxCode tax_code, String bank, String bankCode, String currency, Timestamp date, TaxDeclare taxDeclare) {
        this.id = id;
        this.tax_code = tax_code;
        this.bank = bank;
        this.bankCode = bankCode;
        this.currency = currency;
        this.date = date;
        this.taxDeclare = taxDeclare;
    }

    public TaxPayer() {

    }

    public TaxCode getTax_code() {
        return tax_code;
    }

    public void setTax_code(TaxCode tax_code) {
        this.tax_code = tax_code;
    }

    public TaxDeclare getTaxDeclare() {
        return taxDeclare;
    }

    public void setTaxDeclare(TaxDeclare taxDeclare) {
        this.taxDeclare = taxDeclare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
