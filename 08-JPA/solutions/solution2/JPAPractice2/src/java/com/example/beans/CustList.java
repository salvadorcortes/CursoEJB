/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

/**
 *
 * @author admin
 */

import com.example.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;


public class CustList implements java.io.Serializable{
  private java.util.List<CustomerEntity> customerList;
  public CustList(){
     customerList=new ArrayList<CustomerEntity>(); 
  }
    
    public List<CustomerEntity> getCustomerList(){
        return customerList;
    }
public void setCustomerList(List<CustomerEntity> custlist){
    customerList=custlist;
}
public void add(CustomerEntity cobj){
    customerList.add(cobj);
    System.out.println(cobj.getFirstname());
}
}




    

