package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationController {
//	@GetMapping("report/{no}/{name}")
//	public String fetchData1(@PathVariable("name") String cname,@PathVariable Integer no) {
//		return no+ "<-------->" +cname;
//	}

//	@GetMapping("report/{no}/{name}")
	//public String fetchData(@PathVariable(name="name",required=false)String cname, @PathVariable(required=false)Integer no) {
//		return no+ "<-------->" +cname;
	//}
	
	@GetMapping("report/{no}/name")
	public String fetchData2(@PathVariable(name="name",required=false)String cname, @PathVariable(required=false)Integer no) {
		return "from FetchData2";
	}
	
	@GetMapping("report/no/{name}")
	public String fetchData3(@PathVariable(name="name",required=false)String cname, @PathVariable(required=false)Integer no) {
		return "from FetchData3";
	}
	
	@GetMapping("report/no/name")
	public String fetchData4(@PathVariable(name="name",required=false)String cname, @PathVariable(required=false)Integer no) {
		return "from FetchData4";
	}
	
	@GetMapping("report/{no}/{name}")
	public String fetchData5(@PathVariable(name="name",required=false)String cname, @PathVariable(required=false)Integer no) {
		return "from FetchData5";
	}
	
	
	
}
