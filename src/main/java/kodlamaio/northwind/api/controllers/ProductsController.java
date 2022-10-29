package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public List<Product> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public Product getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public Product getByProductNameAndCategoryId
	(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId)
	{
	    return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public List<Product> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
		
	}
	
	@GetMapping("/getAllByPage")
	public List<Product> getAll(int pageNo,int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public List<Product> getAllShorted(){
		return this.productService.getAllShorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public List<ProductWithCategoryDto> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
}
