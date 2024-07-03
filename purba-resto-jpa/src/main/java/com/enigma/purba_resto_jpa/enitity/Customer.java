package com.enigma.purba_resto_jpa.enitity;

public class Customer {
   private Integer id;
   private String customerName;
   private String customerPhone;
   private Boolean isMember;

    public Customer(Integer id, String customerName, String customerPhone, Boolean isMember) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.isMember = isMember;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }


    @Override
             public String toString() {
        return "\nCustomer    : " +
                "\n\tid             : " + id +
                "\n\tcustomerName   : " + customerName  +
                "\n\tcustomerPhone  : " + customerPhone +
                "\n\tisMember       : " + isMember +"\n"+
                "-".repeat(30);
    }
}
