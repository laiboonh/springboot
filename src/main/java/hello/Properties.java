package hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@ConfigurationProperties(prefix="properties")
public class Properties {
    private HashMap<String, String> countryMap;

    public HashMap<String, String> getCountryMap() {
        return countryMap;
    }

    public void setCountryMap(HashMap<String, String> countryMap) {
        this.countryMap = countryMap;
    }
}
