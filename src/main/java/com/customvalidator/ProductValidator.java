package com.customvalidator;

import com.dto.ProductDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ProductValidator implements Validator {

    private static final Logger logger = LogManager.getLogger(ProductValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDto.class.equals(clazz);
    }

    @Override
    public void validate(Object productDto, Errors bindingResult) {
        BasicConfigurator.configure();
        logger.info("inside the customvalidator validate method");

        ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "specification","productDto.specification","*specification cannot be empty");

        int productId = ((ProductDto) productDto).getProductId();

        if (productId == 0) {
            bindingResult.rejectValue("productId","productDto.productId");
        }

        float inr = ((ProductDto) productDto).getInr();

        if (inr == 0.0) {
            bindingResult.rejectValue("inr","productDto.inr");
        }

        String productName = ((ProductDto) productDto).getProductName();

        if (!productName.contains("mi")) {
            bindingResult.rejectValue("productName","productDto.productName");
        }
    }
}
