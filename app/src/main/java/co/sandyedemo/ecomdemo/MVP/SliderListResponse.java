package co.sandyedemo.ecomdemo.MVP;

import java.util.HashMap;
import java.util.Map;

public class SliderListResponse {

    private Product productsdetails;
    private String id;
    private String bannerimage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Product getProductsdetails() {
        return productsdetails;
    }

    public void setProductsdetails(Product productsdetails) {
        this.productsdetails = productsdetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return bannerimage;
    }

    public void setImage(String image) {
        this.bannerimage = image;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}