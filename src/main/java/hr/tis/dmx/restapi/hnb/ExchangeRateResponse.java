package hr.tis.dmx.restapi.hnb;

import lombok.Getter;

import java.util.List;

@Getter
public class ExchangeRateResponse {

	List<ExchangeRateResponseEntry> exchangeRateResponseEntries;
}
