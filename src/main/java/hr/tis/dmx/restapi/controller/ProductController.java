package hr.tis.dmx.restapi.controller;

import hr.tis.dmx.restapi.dto.ProductDto;
import hr.tis.dmx.restapi.entity.Product;
import hr.tis.dmx.restapi.exception.ProductCreationException;
import hr.tis.dmx.restapi.request.ProductRequest;
import hr.tis.dmx.restapi.response.PopularProductResponse;
import hr.tis.dmx.restapi.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(value = "code", required = false) String code,
	                                                    @RequestParam(value = "name", required = false) String name,
	                                                    HttpServletRequest request) throws ProductCreationException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (!List.of("code", "name").containsAll(parameterMap.keySet())) {
			throw new ProductCreationException("The request is allowed to have only the 'code' and 'name' parameters which are optional");
		}

		List<Product> products = productService.findByCodeAndName(code, name);
		List<ProductDto> productDtos = new ArrayList<>();
		products.forEach(product -> productDtos.add(convertToDto(product)));

		return ResponseEntity.ok(productDtos);
	}

	@GetMapping("/products/mostPopular")
	public PopularProductResponse getTop3PopularProducts() {

		return productService.findTop3PopularProducts();
	}

	private ProductDto convertToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setCode(product.getCode());
		productDto.setName(product.getName());
		productDto.setPriceEur(product.getPriceEUR());
		productDto.setPriceUsd(product.getPriceUSD());
		productDto.setDescription(product.getDescription());
		productDto.setReviews(product.getReviews());

		return productDto;
	}
}
