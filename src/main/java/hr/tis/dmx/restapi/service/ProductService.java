package hr.tis.dmx.restapi.service;

import hr.tis.dmx.restapi.entity.Product;
import hr.tis.dmx.restapi.exception.ProductCreationException;
import hr.tis.dmx.restapi.hnb.ExchangeRateResponseEntry;
import hr.tis.dmx.restapi.repository.ProductRepository;
import hr.tis.dmx.restapi.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hnb.api.usd.url}")
	private String hnbUrl;

	public Product createNewProduct(ProductRequest productRequest) throws ProductCreationException {
		if (productRepository.existsByCode(productRequest.getCode())) {
			throw new ProductCreationException("A product with the given code " + productRequest.getCode() + " already exists");
		}
		Double eurToUsdExchangeRate = fetchExchangeRate();

		BigDecimal priceUsd = BigDecimal.valueOf(eurToUsdExchangeRate * productRequest.getPriceEur())
				.setScale(2, RoundingMode.HALF_UP);

		Product product = new Product();
		product.setCode(productRequest.getCode());
		product.setName(productRequest.getName());
		product.setPriceEUR(productRequest.getPriceEur());
		product.setPriceUSD(priceUsd.doubleValue());
		product.setDescription(productRequest.getDescription());

		return productRepository.save(product);
	}

	private Double fetchExchangeRate() throws ProductCreationException {
		try {
			ExchangeRateResponseEntry[] response = restTemplate.getForObject(hnbUrl, ExchangeRateResponseEntry[].class);
			if (response != null && response.length > 0) {
				return Double.parseDouble(response[0].getMiddleRate().replace(",", "."));
			} else {
				throw new ProductCreationException("Failed to fetch exchange rate data or invalid response");
			}
		} catch (RestClientException e) {
			throw new ProductCreationException("Failed to fetch exchange rate data", e);
		}
	}

	public List<Product> findByCodeAndName(String code, String name) {
		return productRepository.findAllByCodeAndName(code, name);
	}


}