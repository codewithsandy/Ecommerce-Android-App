package co.sandyedemo.ecomdemo.MVP;

import java.util.HashMap;
import java.util.Map;

public class TermsResponse {

private String terms;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getTerms() {
return terms;
}

public void setTerms(String terms) {
this.terms = terms;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}