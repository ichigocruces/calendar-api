package es.a2m.calendar.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.a2m.calendar.AbstractTest;
import es.a2m.calendar.domain.Cliente;
import junit.framework.Assert;

public class ClientRestControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getActiveClients() throws Exception {
		String uri = "/api/clients";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		
		Cliente[] clientList = super.mapFromJson(content, Cliente[].class);
		Assert.assertTrue(clientList.length > 0);
	}

}
