package com.paperjais.ozone.restController;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.httpclient.URIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paperjais.ozone.entity.Client;
import com.paperjais.ozone.entity.ClientDTO;
import com.paperjais.ozone.repository.ClientRepository;
import com.paperjais.ozone.restController.utils.HeaderUtil;

@Configuration
@RestController
@Controller
@RequestMapping(value = "/ozone/api/client")
public class ClientRest {

	@Autowired
	private ClientDTO client1;

	@Autowired
	private ClientRepository repository;

	@RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST)
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> addCient(@RequestBody ClientDTO client)
			throws URISyntaxException {

		if (client.getFirstName() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}

		client1.setLastName(client.getLastName());
		client1.setFirstName(client.getFirstName());
		client1.setEmail(client.getEmail());
		client1.setAddress(client.getAddress());
		client1.setTelephone(client.getTelephone());
		
		return ResponseEntity.created(new URI("/ozone/api/client/" + client1.getFirstName()))
				.headers(HeaderUtil.createEntityCreationAlert("client", client1.getFirstName().toString()))
				.body(client1);

	}

	@RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public ClientDTO getClient() {
		return client1;
	}

}
