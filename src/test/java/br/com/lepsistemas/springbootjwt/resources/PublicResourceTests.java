package br.com.lepsistemas.springbootjwt.resources;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
public class PublicResourceTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_access_public_endpoints_when_no_token_passed() throws Exception {
		this.mockMvc.perform(get("/public"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("public")));
	}
	
	@Test
	public void should_access_public_endpoints_when_valid_token_passed() throws Exception {
		String username = "root";
		String password = "root";
		ResultActions result = mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(TestUtil.credentials(username, password)));
		
		String token = result.andReturn().getResponse().getHeader("Authorization");
		
		this.mockMvc.perform(get("/public").header("Authorization", token))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("public")));
	}
	
	@Test
	public void should_access_public_endpoints_when_invalid_token_passed() throws Exception {
		this.mockMvc.perform(get("/public").header("Authorization", "Bearer invalid_token"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("public")));
	}

}
