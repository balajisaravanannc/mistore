package com.service;

import com.ServiceJaxB.XmlService;
import com.dao.ProductsDao;
import com.dto.ProductDto;
import com.dto.ProductDtoList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsServiceImpl implements ProductsService{
	 
	private ProductsDao productsDao;
	private OxmService oxmService;
	private int todayValue;
	private XmlService xmlService;
	
	public int addProductsSave(ProductDto productDto) {
		productDto.setUsd(productDto.getInr() / getTodayValue());
		
		return getProductsDao().addProductsSave(productDto);
	}
	
	public List<ProductDto> getAllShowProducts(){
		
		return getProductsDao().getAllShowProducts();
	}

	public List<ProductDto> showProducts(){
		
		return getProductsDao().showProducts();
	}
	
	public ProductDto getDetailsById(int productId) {
		
		return getProductsDao().getDetailsById(productId);
	}

	public List<ProductDto> getDetailsByName(String productName) {
		
		return getProductsDao().getDetailsByName(productName);
	}
	
	public ProductDto getProductById(int productId) {
		
		return getProductsDao().getProductById(productId);
	}
	
	public int update(ProductDto productDto) {
		productDto.setUsd(productDto.getInr() / getTodayValue());
		
		return getProductsDao().update(productDto);
	}
	
	public int delete(int productId) {
		
		return getProductsDao().delete(productId);
	}

	@Override
	public String convertFromProductDtoObjectToXmlbyJaxb() {
		ProductDtoList productDtoList = new ProductDtoList();
		productDtoList.setProductDtoList(new ArrayList<>(getProductsDao().getAllShowProducts()));

		return getXmlService().convertObjectToXml(productDtoList);
	}

	@Override
	public Object convertFromProductDtoXmlToObjectbyJaxb(String xml) throws IOException {

		return getXmlService().convertXmlToObject(xml);
	}

	@Override
	public String convertOneProductDtoObjectToXmlByProductId(int productId) throws IOException {
		ProductDto productDto=getProductsDao().getDetailsById(productId);

		return getOxmService().convertOneProductDtoObjectToXmlByProductId(productDto);
	}

	@Override
	public String convertFromProductDtoObjectToXml() throws IOException {
		List<ProductDto> productDto = getProductsDao().getAllShowProducts();
		System.out.println(getOxmService().convertFromProductDtoObjectToXml(productDto));

		return getOxmService().convertFromProductDtoObjectToXml(productDto);
	}

	@Override
	public Object convertFromXmlToProductDtoObject(String xml) throws IOException {

		return getOxmService().convertFromXmlToProductDtoObject(xml);
	}

	public ProductsDao getProductsDao() {
		
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		
		this.productsDao = productsDao;
	}

	public OxmService getOxmService() {
		return oxmService;
	}

	public void setOxmService(OxmService oxmService) {
		this.oxmService = oxmService;
	}

	public int getTodayValue() {
		
		return todayValue;
	}

	public void setTodayValue(int todayValue) {
		
		this.todayValue = todayValue;
	}

	public XmlService getXmlService() {
		return xmlService;
	}

	public void setXmlService(XmlService xmlService) {
		this.xmlService = xmlService;
	}
}
