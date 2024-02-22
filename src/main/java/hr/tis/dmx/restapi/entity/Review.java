package hr.tis.dmx.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Review")
public class Review {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	@JsonIgnore
	private Product product;

	@Column(name = "REVIEWER", nullable = false)
	private String reviewer;

	@Column(name = "TEXT",columnDefinition = "TEXT")
	private String text;

	@Column(name = "RATING",nullable = false)
	private int rating;
}