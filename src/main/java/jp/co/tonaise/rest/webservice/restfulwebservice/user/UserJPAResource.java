package jp.co.tonaise.rest.webservice.restfulwebservice.user;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAResource {

//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id) {
//	User user = service.findOne(id);
//
//	if (user == null)
//	    throw new UserNotFoundException("id-" + id);
//
//	// "all-users", SERVER_PATH + "/users"
//	// retrieveAllUsers
//	EntityModel<User> resource = EntityModel.of(user);
//
//	WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//	resource.add(linkTo.withRel("all-users"));
//
//	// HATEOAS
//
//	return resource;
//    }
}
