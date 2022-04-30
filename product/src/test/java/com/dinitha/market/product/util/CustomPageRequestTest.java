package com.dinitha.market.product.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

class CustomPageRequestTest {

//	@Test
//	@DisplayName("Test null page number and size")
//	public void testNullPageNumberAndSize() {
//		
//		Pageable pageable = CustomPageRequest.of(null, null);
//		
//		assertThat(pageable.getPageNumber()).isEqualTo(0);
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MIN_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test zero page number and size")
//	public void testZeroPageNumberAndSize() {
//		
//		Pageable pageable = CustomPageRequest.of(null, null);
//		
//		assertThat(pageable.getPageNumber()).isEqualTo(0);
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MIN_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test negative page number and size")
//	public void testNegativePageNumberAndSize() {
//		
//		Pageable pageable = CustomPageRequest.of(-1, -1);
//		
//		assertThat(pageable.getPageNumber()).isEqualTo(0);
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MIN_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test positive page number and size")
//	public void testPositivePageNumberAndSize() {
//		
//		Pageable pageable = CustomPageRequest.of(10, CustomPageRequest.MIN_PAGE_SIZE - 10);
//		
//		assertThat(pageable.getPageNumber()).isEqualTo(10);
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MIN_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test large positive page number and size")
//	public void testLargePositivePageNumberAndSize() {
//		
//		Pageable pageable = CustomPageRequest.of(100, CustomPageRequest.MAX_PAGE_SIZE + 100);
//		
//		assertThat(pageable.getPageNumber()).isEqualTo(100);
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MAX_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test minimum page size")
//	public void testMinimumPageSize() {
//		
//		Pageable pageable = CustomPageRequest.of(10, CustomPageRequest.MIN_PAGE_SIZE);
//		
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MIN_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test maximum page size")
//	public void testMaximumPageSize() {
//		
//		Pageable pageable = CustomPageRequest.of(10, CustomPageRequest.MAX_PAGE_SIZE);
//
//		assertThat(pageable.getPageSize()).isEqualTo(CustomPageRequest.MAX_PAGE_SIZE);
//	}
//	
//	@Test
//	@DisplayName("Test allowed page size")
//	public void testAllowedPageSize() {
//		
//		int min = CustomPageRequest.MIN_PAGE_SIZE;
//		int max = CustomPageRequest.MAX_PAGE_SIZE;
//		int anAllowedPageSize = (int) (min + max) / 2;
//		
//		Pageable pageable = CustomPageRequest.of(10, anAllowedPageSize);
//
//		assertThat(pageable.getPageSize()).isEqualTo(anAllowedPageSize);
//	}
}
