package co.sandyedemo.ecomdemo.MVP;
import java.util.HashMap;
import java.util.Map;

public class StripeResponse {

private String Success;
private String Message;
private Integer amount;
private String status;
private String date;
private String paymentref;
private String currency;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getSuccess() {
return Success;
}

public void setSuccess(String success) {
this.Success = success;
}

public String getMessage() {
return Message;
}

public void setMessage(String message) {
this.Message = message;
}

public Integer getAmount() {
return amount;
}

public void setAmount(Integer amount) {
this.amount = amount;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getPaymentref() {
return paymentref;
}

public void setPaymentref(String paymentref) {
this.paymentref = paymentref;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}