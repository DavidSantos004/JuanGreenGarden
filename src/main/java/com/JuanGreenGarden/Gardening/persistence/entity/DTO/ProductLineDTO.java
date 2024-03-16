package com.JuanGreenGarden.Gardening.persistence.entity.DTO;


public class ProductLineDTO {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public String getProductLine() {
        return this.productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return this.textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return this.htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
