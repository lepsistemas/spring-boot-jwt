package br.com.lepsistemas.springbootjwt.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import br.com.lepsistemas.springbootjwt.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthResourceTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void should_return_401_when_attempt_to_login_with_correct_credentials() throws Exception {
		String username = "root";
		String password = "root";
		ResultActions result = mockMvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.credentials(username, password)))
				.andExpect(status().isOk());
		assertTrue(result.andReturn().getResponse().getHeaderNames().contains("Authorization"));
	}
	
	@Test
	public void should_return_401_when_attempt_to_login_with_incorrect_credentials() throws Exception {
		String username = "root";
		String password = "";
		ResultActions result = mockMvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.credentials(username, password)))
				.andExpect(status().isUnauthorized());
		assertFalse(result.andReturn().getResponse().getHeaderNames().contains("Authorization"));
	}

}
