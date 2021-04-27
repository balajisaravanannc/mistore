package com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDto {

    @XmlElement
    private int productId;
    @XmlElement
    private String productName;
    @XmlElement
    private float inr;
    @XmlElement
    private float usd;
    @XmlElement
    @NotBlank(message = "*description can't be blank")
    private String description;
    @XmlElement
    @NotBlank(message = "*company can't be blank")
    private String company;
    @XmlElement
    @NotBlank(message = "*specification can't be blank")
    private String specification;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getInr() {
        return inr;
    }

    public void setInr(float inr) {
        this.inr = inr;
    }

    public float getUsd() {
        return usd;
    }

    public void setUsd(float usd) {
        this.usd = usd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", inr=" + inr +
                ", usd=" + usd +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }


    // @Pattern(regexp="^[a-zA-Z0-9]{3}",message="*productName should contain A,a,1")
}
