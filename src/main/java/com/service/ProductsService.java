package com.service;

import com.dto.ProductDto;
import com.dto.ProductDtoList;

import java.io.IOException;
import java.util.List;

public interface ProductsService {
	
	/**
	 * To save the products into the database which we get from user
	 * @param productDto
	 * 
	 */
	int addProductsSave(ProductDto productDto);

	/**
	 * To get all products from database
	 *
	 */
	List<ProductDto> getAllShowProducts();

	/**
	 * To get all show products from database
	 * 
	 */
	List<ProductDto> showProducts();

	/**
	 * To get details by productId
	 * @param productId
	 *
	 */
	ProductDto getDetailsById(int productId);
	
	/**
	 * To get details by productName
	 * @param productName
	 *
	 */
	List<ProductDto> getDetailsByName(String productName);

	/**
	 * To get product by productId to edit
	 * @param productId
	 *
	 */
	ProductDto getProductById(int productId);

	/**
	 * To update
	 * @param productDto
	 *
	 */
	int update(ProductDto productDto);

	/**
	 * To delete product by productId
	 * @param productId
	 *
	 */
	int delete(int productId);

	/**
	 *To convertOneProductDtoObjectToXmlByProductId
	 * @param productId
	 * @return
	 * @throws IOException
	 */
	String convertOneProductDtoObjectToXmlByProductId(int productId) throws IOException;

	/**
	 * To convertFromProductDtoObjectToXml
	 * @return
	 * @throws IOException
	 */
    String convertFromProductDtoObjectToXml() throws IOException;

	/**
	 * To convertFromXmlToProductDtoObject
	 * @param xml
	 * @return
	 * @throws IOException
	 */
	Object convertFromXmlToProductDtoObject(String xml) throws IOException;

	String convertFromProductDtoObjectToXmlbyJaxb();

	Object convertFromProductDtoXmlToObjectbyJaxb(String xml) throws IOException;
}
