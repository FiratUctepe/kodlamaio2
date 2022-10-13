package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{
	
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return this.productDao.findAll();
	}

	@Override
	public String add(Product product) {
		this.productDao.save(product);
		return new String("Ürün Eklendi.");
	}

	@Override
	public Product getByProductName(String productName) {
		return this.productDao.getByProductName(productName);
	}

	@Override
	public Product getByProductNameAndCategoryId(String productName, int categoryId) {
		return this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId);
	}

	@Override
	public List<Product> getByProductNameOrCategoryId(String productName, int categoryId) {
		return this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId);
	}

	@Override
	public List<Product> getByCategoryIn(List<Integer> categories) {
		return this.productDao.getByCategoryIn(categories);
	}

	@Override
	public List<Product> getByProductNameContains(String productName) {
		return this.productDao.getByProductNameContains(productName);
	}

	@Override
	public List<Product> getByProductNameStartsWith(String productName) {
		return this.productDao.getByProductNameStartsWith(productName);
	}

	@Override
	public List<Product> getByNameAndCategory(String productName, int categoryId) {
		return this.productDao.getByNameAndCategory(productName,categoryId);
	}

	@Override
	public List<Product> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return this.productDao.findAll(pageable).getContent();
	}

	@Override
	public List<Product> getAllShorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return this.productDao.findAll(sort);
	}

	@Override
	public List<ProductWithCategoryDto> getProductWithCategoryDetails() {
		return this.productDao.getProductWithCategoryDetails();
	}
}
