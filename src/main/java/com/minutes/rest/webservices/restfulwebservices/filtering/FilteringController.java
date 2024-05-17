package com.minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	// static filtering

	@GetMapping("/filter")
	public MappingJacksonValue filterBean() {
		List<SomeBean> asList = Arrays.asList(
				new SomeBean("num1", "num2", "num3")
				);
		return FilteringLogic(asList,"value1","value2");
	}

	@GetMapping("/filter/static")
	public MappingJacksonValue staticFilterBean() {
		List<SomeBean> asList = Arrays.asList(
				new SomeBean("num1","num2","num3"),
				new SomeBean("num3","num4","num5")
				);
		return FilteringLogic(asList,"value1","value2");
	}
	
	public MappingJacksonValue FilteringLogic(List<SomeBean> asList,String value1,String value2) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(value1, value2);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
