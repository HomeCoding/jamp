package hateoas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jamp.app.domain.Link;
import com.jamp.app.service.LinkService;

@RestController
@RequestMapping(value = "/links")
public class LinkController {

	@Autowired
	private LinkService webResourceService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Link getById(@PathVariable Integer id) {
		return webResourceService.getById(id);
	}
}
