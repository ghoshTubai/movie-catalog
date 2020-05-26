package com.ghoshtubai.movie.moviecatalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ratings
{
    private String Source;

    private String Value;

    public void setSource(String Source){
        this.Source = Source;
    }
    @JsonProperty("Source")
    public String getSource(){
        return this.Source;
    }
    public void setValue(String Value){
        this.Value = Value;
    }
    @JsonProperty("Value")
    public String getValue(){
        return this.Value;
    }
}
