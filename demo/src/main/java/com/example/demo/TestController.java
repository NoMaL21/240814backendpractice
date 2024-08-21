package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;



import com.example.demo.dto.TestRequestBodyDTO;
import com.example.demo.dto.ResponseDTO;

import org.springframework.web.bind.annotation.RequestBody;

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
	
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello World! \nID :"+testRequestBodyDTO.getId()+" \nMessage : "+ testRequestBodyDTO.getMessage();
	}
	
	@GetMapping("/testResponseBody")
	public ResponseDTO<String>testControllerResponseBody(){
		List<String> list = new ArrayList<String>();
		list.add("Hello World! I'm ResponseDTO");
		list.add("See you!");
		
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
	
	@GetMapping("/testResponseEntityOk")
	public ResponseEntity<?>testControllerResponseEntityOk(){
		List<String> list = new ArrayList<String>();
		list.add("This is ResponseEntity, code 200");
		list.add("See you!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/testResponseEntityBad")
	public ResponseEntity<?>testControllerResponseEntityBad(){
		List<String> list = new ArrayList<String>();
		list.add("This is ResponseEntity. code 400");
		list.add("See you!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.badRequest().body(response);
	}
	
}
