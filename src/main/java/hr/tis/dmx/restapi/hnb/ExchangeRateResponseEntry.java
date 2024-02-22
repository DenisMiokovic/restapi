package hr.tis.dmx.restapi.hnb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeRateResponseEntry {

	@JsonProperty("broj_tecajnice")
	private String exchangeRateNumber;

	@JsonProperty("datum_primjene")
	private String applicationDate;

	@JsonProperty("drzava")
	private String country;

	@JsonProperty("drzava_iso")
	private String countryIso;

	@JsonProperty("kupovni_tecaj")
	private String buyingRate;

	@JsonProperty("prodajni_tecaj")
	private String sellingRate;

	@JsonProperty("sifra_valute")
	private String currencyCode;

	@JsonProperty("srednji_tecaj")
	private String middleRate;

	@JsonProperty("valuta")
	private String currency;
}
