package co.sandyedemo.ecomdemo.MVP;

import java.util.HashMap;
import java.util.Map;

public class RegistrationResponse {

private String Success;
private String Message;
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

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}