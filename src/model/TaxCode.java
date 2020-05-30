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
//Mã số thuế
public class TaxCode {
    private int taxcode;  //Mã số thuế cá nhân.
    private String name;
    private String sex;
    private String nationality;
    private String phone;
    private String email;
    private String address;
    private boolean  status; //Trạng thái True (mã số thuế vẫn còn hiệu lực) or False, 
}
