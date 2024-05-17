package com.minutes.rest.webservices.restfulwebservices.hello;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	MessageSource messageSource;
	public HelloWorld(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@GetMapping(path="/hello-world")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("hello");
	}
	
	//path-variable 
	@GetMapping(path="hello-world/path-var/{name}")
	public HelloWorldBean helloWorldWithPathV(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello path var %s", name));
	}
	
	@GetMapping(path="hello-world/i18n")
	public String helloWorldI18N() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
}
