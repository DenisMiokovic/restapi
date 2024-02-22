package hr.tis.dmx.restapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

	private Long id;
	private String code;
	private String name;
	private double priceEur;
	private double priceUsd;
	private String description;
}
