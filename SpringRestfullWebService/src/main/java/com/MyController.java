package com;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping(value="sayHello")
	public String sayHello()
	{
		return "Welcome to Spring Restful Web Service";
	}
	@RequestMapping(value="info")
	public String greetingUser(@RequestParam("name") String name)
	{
		return "Welcome "+name;
	}
	@RequestMapping(value="info1/{name}",method=RequestMethod.GET)
	public String greeting(@PathVariable("name") String name)
	{
		return "Welcome "+name;
	}
	@RequestMapping(value="info2",produces=MediaType.TEXT_HTML_VALUE)
	public String doSomeWork()
	{
		return "<h1>Hii</h1>";
	}
}
