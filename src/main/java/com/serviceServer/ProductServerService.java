package com.serviceServer;

import com.dao.ProductsDao;

public interface ProductServerService {

    String getAllProductDtoIntoJson();

    String getProductDtoIntoJsonById(int productId);

    String getProductDtoIntoJsonToDelete(int productId);
}
