package com.cdperry.brewday.helpers.chucknorris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This is a generated POJO class to hold the JSON response from the Chuck Norris Database
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "joke",
        "categories"
})
public class ChuckNorrisResult {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("joke")
    private String joke;
    @JsonProperty("categories")
    private List<Object> categories = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The joke
     */
    @JsonProperty("joke")
    public String getJoke() {
        return joke;
    }

    /**
     *
     * @param joke
     * The joke
     */
    @JsonProperty("joke")
    public void setJoke(String joke) {
        this.joke = joke;
    }

    /**
     *
     * @return
     * The categories
     */
    @JsonProperty("categories")
    public List<Object> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    @JsonProperty("categories")
    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}