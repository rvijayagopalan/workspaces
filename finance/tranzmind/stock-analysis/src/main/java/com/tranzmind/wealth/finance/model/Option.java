package com.tranzmind.wealth.finance.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter 
@Setter
@Slf4j
public class Option {
	
	 String type;
	 String expiry;
	 String last;
	 String bid;
	 String ask;
	 String strikePrice;
	 
	 public String toString() {
		 log.info("{}, {}, {}, {}", expiry, type, strikePrice, last);
		 return (this.expiry + this.strikePrice + this.type);
	 }
}