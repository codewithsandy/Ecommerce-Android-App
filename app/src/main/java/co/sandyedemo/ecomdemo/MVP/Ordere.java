
package co.sandyedemo.ecomdemo.MVP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ordere {

    private String orderid;
    private String paymentmode;
    private String paymenref;
    private String paymenstatus;
    private String date;
    private String total;
    private String address;
    private List<Product> ordredproduct = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getPaymenref() {
        return paymenref;
    }

    public void setPaymenref(String paymenref) {
        this.paymenref = paymenref;
    }

    public String getPaymenstatus() {
        return paymenstatus;
    }

    public void setPaymenstatus(String paymenstatus) {
        this.paymenstatus = paymenstatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Product> getOrdredproduct() {
        return ordredproduct;
    }

    public void setOrdredproduct(List<Product> ordredproduct) {
        this.ordredproduct = ordredproduct;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}