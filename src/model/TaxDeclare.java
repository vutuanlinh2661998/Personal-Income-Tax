/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.User;
import java.sql.Timestamp;
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
//Khai báo thuế
public class TaxDeclare {
    private User user;
    private String taxPeriod; //Kỳ tính thuế.VD: Quý 1-2020
    private boolean firstTime;
    private String time_update;
    private float total;//Tổng số tiền thuế phải đóng trong kỳ tính thuês
    private Timestamp createDate;//Ngày lập báo cáo
    public TaxDeclare(String taxPeriod, float total, String time_update) {
        this.taxPeriod = taxPeriod;
        this.total = total;
        this.time_update = time_update;
    }

    public TaxDeclare(int id, String taxPeriod, boolean firstTime, String time_update, float total, Timestamp createDate) {
        this.taxPeriod = taxPeriod;
        this.firstTime = firstTime;
        this.time_update = time_update;
        this.total = total;
        this.createDate = createDate;
    }

    

   
}
