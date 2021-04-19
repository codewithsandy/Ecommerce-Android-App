package co.sandyedemo.ecomdemo.MVP;

import java.util.HashMap;
import java.util.Map;

public class FAQResponse {

private String title;
private String description;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}