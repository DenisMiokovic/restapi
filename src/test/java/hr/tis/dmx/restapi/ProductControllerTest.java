package hr.tis.dmx.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tis.dmx.restapi.request.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testAddProduct() throws Exception {
		ProductRequest productRequest = new ProductRequest("HWIAW0WW4778201", "Huawei test cell", 178.99, "For testing purposes only");
		mockMvc.perform(post("/addProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(productRequest)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value("Huawei test cell"));
	}

	@Test
	public void testAddProductWithInvalidData() throws Exception {
		ProductRequest invalidProductRequest = new ProductRequest("", "", -1.0, "");
		mockMvc.perform(post("/addProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(invalidProductRequest)))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetProductByCode() throws Exception {
		mockMvc.perform(get("/products?code={code}", "sm"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetProductByName() throws Exception {
		mockMvc.perform(get("/products?name={name}", "Samsung"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetProductByCodeAndName() throws Exception {
		mockMvc.perform(get("/products?code={code}&name={name}", "sma54", "Samsung"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetAllProducts() throws Exception {
		mockMvc.perform(get("/products"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetProductByNonexistentCode() throws Exception {
		mockMvc.perform(get("/products?code=nonexistentCode"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(0));
	}

	@Test
	public void testGetProductByCodeWithSpecialCharacters() throws Exception {
		mockMvc.perform(get("/products?code=%22%3E%3Cscript%3Ealert(1)%3C%2Fscript%3E"))
				.andExpect(status().isOk());
	}

	@Test
	@Commit
	public void testAddAndFetchProduct() throws Exception {
		ProductRequest productRequest = new ProductRequest("HWIAW0WW4778201", "Huawei test cell", 178.99, "For testing purposes only");

		mockMvc.perform(post("/addProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(productRequest)))
				.andExpect(status().isCreated());

		mockMvc.perform(get("/products?code={code}", "HWIAW0WW4778201"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].code").value("HWIAW0WW4778201"))
				.andExpect(jsonPath("$[0].name").value("Huawei test cell"));
	}

	@Test
	public void testGetPopularProducts() throws Exception {
		mockMvc.perform(get("/products/mostPopular"))
				.andExpect(status().isOk());
	}
}
