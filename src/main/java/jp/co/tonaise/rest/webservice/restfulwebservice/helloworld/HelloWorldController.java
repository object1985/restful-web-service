package jp.co.tonaise.rest.webservice.restfulwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // GET
    // URI - /hello-world
    // method - "Hello World"
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
	return "hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldbean() {
	return new HelloWorldBean("hello world");
    }

    /// hello-world/path-variable/in28minutes
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldVariable(@PathVariable String name) {
	return new HelloWorldBean(String.format("hello world,%s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
	return "Good Morning";
//	return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
