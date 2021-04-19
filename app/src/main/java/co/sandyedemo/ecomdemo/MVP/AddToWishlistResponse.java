package co.sandyedemo.ecomdemo.MVP;

import java.util.HashMap;
import java.util.Map;

public class AddToWishlistResponse {

private String success;
private String message;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getSuccess() {
return success;
}

public void setSuccess(String success) {
this.success = success;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}