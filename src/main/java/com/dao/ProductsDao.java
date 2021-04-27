package com.dao;

import com.dto.ProductDto;
import java.util.List;

public interface ProductsDao {


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

}
