package hr.tis.dmx.restapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODE",unique = true, length = 15, nullable = false)
	private String code;

	@Column(name = "NAME",nullable = false)
	private String name;

	@Column(name = "PRICE_EUR", nullable = false)
	private double priceEUR;

	@Column(name = "PRICE_USD", nullable = false)
	private double priceUSD;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(mappedBy = "product")
	private List<Review> reviews;
}