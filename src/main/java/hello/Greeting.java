package hello;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;

@JsonApiResource(type = "greetings")
public class Greeting {

    @JsonApiId
    private final long id;
    private final String content;
    private final String country;

    public Greeting(long id, String content, String country) {
        this.id = id;
        this.content = content;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "greeting[id=" + id + ", content=" + content +  ", country=" + country + "]";
    }
}