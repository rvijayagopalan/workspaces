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
public class OptionExpiry {

	@NonNull String optionExpiry;
	List<OptionStrikePrice> optionStrikePrice = new ArrayList<>();
}
