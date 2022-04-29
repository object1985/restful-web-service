package jp.co.tonaise.rest.webservice.restfulwebservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    // Get /users
    // retriveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
	return service.findAll();
    }

    // GET /users/{id}
    // retriveUserint id)
    @GetMapping("users/{id}")
    public User retrieveUser(@PathVariable int id) {
	User user = service.findOne(id);
	if (user == null) {
	    throw new UserNotFoundException("id-" + id);
	}
	return user;
    }

    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
	User savedUser = service.save(user);
	// CREATED
	// /user/4
//	UriComponentsBuilder builder = MvcUriComponentsBuilder.fromMethodName(SampleController.class, "test");
//	URI location = UriComponentsBuilder.;
//	// ResponseEntity<T>.created(location)
//	return ResponseEntity.created(location).build();
	return savedUser;
    }
}
