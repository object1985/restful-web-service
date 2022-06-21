package jp.co.tonaise.rest.webservice.restfulwebservice.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    // Get /users
    // retriveAllUsers
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
	return userRepository.findAll();
    }

    // GET /users/{id}
    // retriveUserint id)
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@ApiParam(value = "User id", example = "1") @PathVariable int id) {
	Optional<User> user = userRepository.findById(id);

	if (!user.isPresent())
	    throw new UserNotFoundException("id-" + id);

	// "all-users", SERVER_PATH + "/users"
	// retrieveAllUsers
	EntityModel<User> resource = EntityModel.of(user.get());

	WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

	resource.add(linkTo.withRel("all-users"));

	// HATEOAS

	return resource;
    }

    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/jpa//users")
    public User createUser(@Valid @RequestBody User user) throws DuplicatedException {
	Integer targetId = user.getId();
	checkDuplicated(targetId);
	User savedUser = userRepository.save(user);
	// CREATED
	// /user/4
//	UriComponentsBuilder builder = MvcUriComponentsBuilder.fromMethodName(SampleController.class, "test");
//	URI location = UriComponentsBuilder.;
//	// ResponseEntity<T>.created(location)
//	return ResponseEntity.created(location).build();
	return savedUser;
    }

    private void checkDuplicated(Integer targetId) throws DuplicatedException {
	if (targetId != null) {
	    boolean duplicated = retrieveAllUsers().stream().anyMatch(e -> targetId == e.getId());
	    if (duplicated) {
		throw new DuplicatedException("user id is duplicated.[id]:" + targetId);
	    }
	}
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
	userRepository.deleteById(id);
	System.out.println("delete fin.");
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id) {
	Optional<User> userOptional = userRepository.findById(id);
	if (userOptional.isPresent()) {
	    throw new UserNotFoundException("id-" + id);
	}
	return userOptional.get().getPosts();
    }

    @PostMapping("/jpa//users/{id}/posts")
    public Post createPost(@PathVariable int id, @RequestBody Post post) throws DuplicatedException {
	Optional<User> userOptional = userRepository.findById(id);
	if (!userOptional.isPresent()) {
	    throw new UserNotFoundException("id-" + id);
	}

	// CREATED
	User user = userOptional.get();
	post.setUser(user);
	Post savedPost = postRepository.save(post);

	return savedPost;
    }

}
