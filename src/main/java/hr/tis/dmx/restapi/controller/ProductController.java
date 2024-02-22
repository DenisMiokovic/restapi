package hr.tis.dmx.restapi.controller;

import hr.tis.dmx.restapi.dto.ProductDto;
import hr.tis.dmx.restapi.entity.Product;
import hr.tis.dmx.restapi.exception.ProductCreationException;
import hr.tis.dmx.restapi.request.ProductRequest;
import hr.tis.dmx.restapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequest productRequest) {
		try {
			Product product = productService.createNewProduct(productRequest);
			ProductDto productDto = convertToDto(product);
			return new ResponseEntity<>(productDto, HttpStatus.CREATED);
		}
		catch (ProductCreationException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
		}
	}

	@GetMapping("/products")
	public List<ProductDto> getProducts(@RequestParam(value = "code", required = false) String code,
	                                 @RequestParam(value = "name", required = false) String name
	) {
		List<Product> products = productService.findByCodeAndName(code, name);
		List<ProductDto> productDtos = new ArrayList<>();
		products.forEach(product -> productDtos.add(convertToDto(product)));

		return productDtos;
	}

	private ProductDto convertToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setCode(product.getCode());
		productDto.setName(product.getName());
		productDto.setPriceEur(product.getPriceEUR());
		productDto.setPriceUsd(product.getPriceUSD());
		productDto.setDescription(product.getDescription());

		return productDto;
	}
}
