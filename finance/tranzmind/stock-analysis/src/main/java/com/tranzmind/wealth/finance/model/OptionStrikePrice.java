package com.tranzmind.wealth.finance.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@RequiredArgsConstructor
public class OptionStrikePrice {
	
	@NonNull String strikePrice;
	Option call;
	Option put;
}