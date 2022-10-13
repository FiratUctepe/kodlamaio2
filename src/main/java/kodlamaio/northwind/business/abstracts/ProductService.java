package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	List<Product> getAll();
	
	List<Product> getAll(int pageNo,int pageSize);
	
	List<Product> getAllShorted();
	
	String add(Product product);
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategoryId(String productName,int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
