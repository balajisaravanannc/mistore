package com.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoList {

    @XmlElement
    List<ProductDto> productDtoList;

    public List<ProductDto> getProductDtoList() {

        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    @Override
    public String toString() {
        return "ProductDtoList{" +
                "productDtoList=" + productDtoList +
                '}';
    }
}
