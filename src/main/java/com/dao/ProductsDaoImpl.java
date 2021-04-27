package com.dao;

import com.dto.ProductDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductsDaoImpl implements ProductsDao {

	private JdbcTemplate jdbcTemplate;

	public int addProductsSave(ProductDto productDto) {
		
		String sql = "insert into products(productId,productName,inr,usd,description,company,specification) values("
				+ productDto.getProductId() + ",'" + productDto.getProductName() + "',"+ productDto.getInr() + ","
				+ productDto.getUsd() + ",'" + productDto.getDescription() + "','" + productDto.getCompany() + "','"
				+ productDto.getSpecification() + "')";
		
		return jdbcTemplate.update(sql);
	}

	public List<ProductDto> getAllShowProducts() {

		return jdbcTemplate.query("select * from products", new RowMapper<ProductDto>() {
			public ProductDto mapRow(ResultSet rs, int row) throws SQLException {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getInt(1));
				productDto.setProductName(rs.getString(2));
				productDto.setUsd(rs.getFloat(3));
				productDto.setInr(rs.getFloat(4));
				productDto.setDescription(rs.getString(5));
				productDto.setCompany(rs.getString(6));
				productDto.setSpecification(rs.getString(7));

				return productDto;
			}
		});
	}

	public List<ProductDto> showProducts() {

		return jdbcTemplate.query("select * from products", new RowMapper<ProductDto>() {
			public ProductDto mapRow(ResultSet rs, int row) throws SQLException {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getInt(1));
				productDto.setProductName(rs.getString(2));
				productDto.setUsd(rs.getFloat(3));
				productDto.setInr(rs.getFloat(4));

				return productDto;
			}
		});
	}

	public ProductDto getDetailsById(int productId) {
		String sql = "select * from products where productId = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] {productId},
				new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
		
	}

	public List<ProductDto> getDetailsByName(String productName) {

		return jdbcTemplate.query("select * from products where productName='" + productName + "'",
				new RowMapper<ProductDto>() {
					public ProductDto mapRow(ResultSet rs, int row) throws SQLException {
						ProductDto productDto = new ProductDto();
						productDto.setProductId(rs.getInt(1));
						productDto.setProductName(rs.getString(2));
						productDto.setUsd(rs.getFloat(3));
						productDto.setInr(rs.getFloat(4));
						productDto.setDescription(rs.getString(5));
						productDto.setCompany(rs.getString(6));
						productDto.setSpecification(rs.getString(7));

						return productDto;
					}
				});
	}

	public ProductDto getProductById(int productId) {
		String sql = "select * from products where productId = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] {productId},
				new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	public int update(ProductDto productDto) {
		String sql = "update products set productName='" + productDto.getProductName() + "', usd=" + productDto.getUsd()
				+ ", inr=" + productDto.getInr() + ",description='" + productDto.getDescription() + "',company='"
				+ productDto.getCompany() + "',specification='" + productDto.getSpecification() + "' where productId="
				+ productDto.getProductId() + "";
		
		return jdbcTemplate.update(sql);
	}

	public int delete(int productId) {
		String sql = "delete from products where productId=" + productId + "";
		
		return jdbcTemplate.update(sql);
	}

	public JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}

}
