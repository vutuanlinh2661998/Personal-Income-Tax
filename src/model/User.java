/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author BVCN 88
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private int id;
    private TaxCode taxcode;
    private String type; //Có 2 kieu người dùng : Cá nhân và Doanh nghiệp
    private boolean  active;//True (vẫn hoạt động) or False

    public User(int id) {
        this.id = id;
    }
    
    
}
