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



	

}
