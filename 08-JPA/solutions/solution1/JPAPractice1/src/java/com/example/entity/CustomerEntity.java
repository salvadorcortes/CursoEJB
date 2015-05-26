/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
/**
 *
 * @author admin
 */
@Entity
@Table(name = "CUSTOMER")
//@NamedQueries({
   // @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM CUSTOMER c")})
  public class CustomerEntity implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PREFERRED_ID")
    private Integer preferredId;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPreferredId() {
        return preferredId;
    }

    public void setPreferredId(Integer preferredId) {
        this.preferredId = preferredId;
    }  
}
