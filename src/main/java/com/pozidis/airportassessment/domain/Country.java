package com.pozidis.airportassessment.domain;

/**
 * @author arist
 */

public class Country {
    private long id;
    private String code;
    private String name;
    private String continent;
    private String wikipediaLink;
    private String keywords;

    public Country() {
    }

    public Country(String code, String name, String continent, String wikipediaLink, String keywords) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.wikipediaLink = wikipediaLink;
        this.keywords = keywords;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikiLink) {
        this.wikipediaLink = wikiLink;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
