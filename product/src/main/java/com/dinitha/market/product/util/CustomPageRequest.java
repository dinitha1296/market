package com.dinitha.market.product.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class CustomPageRequest {

	public static final int MIN_PAGE_SIZE = 20;
	public static final int MAX_PAGE_SIZE = 50;
	
	public static Pageable of(Integer pageNumber, Integer resultsPerPage) {
		
		int pageNumberConverted = 0;
		int resultsPerPageConverted = MIN_PAGE_SIZE;
		
		if (pageNumber != null && pageNumber > 0) {
			pageNumberConverted = pageNumber;
		}
		
		if (resultsPerPage != null) {
			if (resultsPerPage <= MIN_PAGE_SIZE) {
				resultsPerPageConverted = MIN_PAGE_SIZE;
			} else if (resultsPerPage >= MAX_PAGE_SIZE) {
				resultsPerPageConverted = MAX_PAGE_SIZE;
			} else {
				resultsPerPageConverted = resultsPerPage;
			}
		}
		
		return PageRequest.of(pageNumberConverted, resultsPerPageConverted);
	}
}
