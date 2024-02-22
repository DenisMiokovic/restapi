package hr.tis.dmx.restapi.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

	@NotNull
	@Size(min = 15, max = 15)
	private String code;

	@NotNull
	private String name;

	@NotNull
	@Positive
	private Double priceEur;

	@NotNull
	private String description;

	@Override
	public String toString() {
		return "ProductRequest{" +
				"code='" + code + '\'' +
				", name='" + name + '\'' +
				", priceEur=" + priceEur +
				", description='" + description + '\'' +
				'}';
	}
}
