/*
 * This file is generated by jOOQ.
 */
package com.bank.dao.gen.tables.pojos;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customers implements Serializable {

    private static final long serialVersionUID = -1667475703;

    private Integer   id;
    private String    fullName;
    private String    email;
    private String    phone;
    private String    address;
    private Date      dateOfBirth;
    private Timestamp created;
    private Timestamp modified;

    public Customers() {}

    public Customers(Customers value) {
        this.id = value.id;
        this.fullName = value.fullName;
        this.email = value.email;
        this.phone = value.phone;
        this.address = value.address;
        this.dateOfBirth = value.dateOfBirth;
        this.created = value.created;
        this.modified = value.modified;
    }

    public Customers(
        Integer   id,
        String    fullName,
        String    email,
        String    phone,
        String    address,
        Date      dateOfBirth,
        Timestamp created,
        Timestamp modified
    ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.created = created;
        this.modified = modified;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customers (");

        sb.append(id);
        sb.append(", ").append(fullName);
        sb.append(", ").append(email);
        sb.append(", ").append(phone);
        sb.append(", ").append(address);
        sb.append(", ").append(dateOfBirth);
        sb.append(", ").append(created);
        sb.append(", ").append(modified);

        sb.append(")");
        return sb.toString();
    }
}
