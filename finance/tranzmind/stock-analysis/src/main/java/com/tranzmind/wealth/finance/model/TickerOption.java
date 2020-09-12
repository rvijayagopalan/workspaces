package com.tranzmind.wealth.finance.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TickerOption {

	@NonNull String ticker;
	List<OptionExpiry> optionExpiryList = new ArrayList<>();
}