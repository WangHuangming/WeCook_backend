package com.huangming.wecook.dataclass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {
    private String name;
    private String category;

    @JsonProperty("weightInGrams")
    private int weightInGrams;
    @JsonProperty("purchaseDate")
    private String purchaseDate;

    public Ingredient() {
    }

    public Ingredient(String name, String category, int weightInGrams, String purchaseDate) {
        this.name = name;
        this.category = category;
        this.weightInGrams = weightInGrams;
        this.purchaseDate = purchaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
