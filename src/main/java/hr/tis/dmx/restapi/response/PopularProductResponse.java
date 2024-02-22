package hr.tis.dmx.restapi.response;

import hr.tis.dmx.restapi.dto.PopularProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PopularProductResponse {

	private List<PopularProductDto> popularProducts;
}
