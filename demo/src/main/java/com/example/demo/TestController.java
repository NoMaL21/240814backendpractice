package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("test")
public class TestController {
	@GetMapping
	public String testController() {
		return "Hello World";
	}
	
	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(name = "id", required = false) Integer id) {
	    if (id == null) {
	        return "Hello World! ID is not provided";
	    }
	    return "Hello World! ID " + id;
	}

	@GetMapping("/Param")
	public String testControllerRequestParam(@RequestParam(name = "id", required = false) Integer id) {
	    if (id == null) {
	        return "Hello World! ID param is not provided";
	    }
	    return "Hello World! ID param " + id;
	}
}
