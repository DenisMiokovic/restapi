package hr.tis.dmx.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tis.dmx.restapi.request.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddProduct() throws Exception {
		ProductRequest productRequest = new ProductRequest("SMA54FGA1234567", "Samsung Galaxy A54", 316.99, "Description");
		mockMvc.perform(post("/addProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(productRequest)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value("Samsung Galaxy A54"));
	}
}
