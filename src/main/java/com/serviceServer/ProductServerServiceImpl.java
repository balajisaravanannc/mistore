package com.serviceServer;

import com.dao.ProductsDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Required;

import java.io.File;
import java.io.IOException;

//Marshallaing
public class ProductServerServiceImpl implements ProductServerService {

    private ProductsDao productsDao;

    //ObjectToString
    @Override
    public String getAllProductDtoIntoJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(getProductsDao().getAllShowProducts());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @Override
    public String getProductDtoIntoJsonById(int productId) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(getProductsDao().getDetailsById(productId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @Override
    public String getProductDtoIntoJsonToDelete(int productId) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(getProductsDao().delete(productId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public ProductsDao getProductsDao() {
        return productsDao;
    }

    @Required
    public void setProductsDao(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }
}