package hr.tis.dmx.restapi.dto;

import hr.tis.dmx.restapi.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
	private List<Review> reviews;
}
