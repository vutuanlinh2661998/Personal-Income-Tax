/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
public class Account implements Serializable{
    private int id;
    private String username;
    private String password;
    private TaxCode taxcode;
   
            
}
