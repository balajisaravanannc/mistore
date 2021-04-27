package com.controller;

import com.dto.ProductDto;
import com.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class ProductRestController {

    @Autowired
    @Qualifier("productsService")
    private ProductsService productsService;

    private Logger logger = Logger.getLogger(String.valueOf(ProductRestController.class));

    @RequestMapping(value = "/convertFromProductDtoObjectToXmlbyJaxb", produces = {"application/xml"})
    public String convertFromProductDtoObjectToXmlbyJaxb() {
        logger.info("convertFromProductDtoObjectToXmlbyJaxb");

        return productsService.convertFromProductDtoObjectToXmlbyJaxb();
    }

    @RequestMapping(value = "/convertFromProductDtoXmlToObjectbyJaxb")
    public Object convertFromProductDtoXmlToObjectbyJaxb() throws IOException {
        String xml = productsService.convertFromProductDtoObjectToXmlbyJaxb();
        logger.info("convertFromProductDtoXmlToObjectbyJaxb");
        Object productDtoList = productsService.convertFromProductDtoXmlToObjectbyJaxb(xml);
        logger.info("convertFromProductDtoXmlToObjectbyJaxb"+productDtoList.toString());

        return productDtoList;
    }

    @RequestMapping(value = "/convertOneProductDtoObjectToXmlByProductId/{productId}", produces = {"application/xml"})
    public String convertOneProductDtoObjectToXml(@PathVariable("productId") int productId) throws IOException {
        logger.info("convertOneProductDtoObjectToXmlByProductId");

        return productsService.convertOneProductDtoObjectToXmlByProductId(productId);
    }

    @RequestMapping(value = "/convertFromProductDtoObjectToXml", produces = {"application/xml"})
    public String convertFromProductDtoObjectToXml() throws IOException {
        logger.info("convertFromProductDtoObjectToXml");
        System.out.println(productsService.convertFromProductDtoObjectToXml());

        return productsService.convertFromProductDtoObjectToXml();
    }

    @RequestMapping(value = "/convertFromXmlToProductDtoObject")
    public Object convertFromXmlToProductDtoObject() throws IOException {
        String xml = productsService.convertFromProductDtoObjectToXml();
        logger.info("convertFromXmlToProductDtoObject");
        Object productDtoList = productsService.convertFromXmlToProductDtoObject(xml);
        logger.info("convertFromXmlToProductDtoObject"+productDtoList.toString());

        return productDtoList;
    }
}


