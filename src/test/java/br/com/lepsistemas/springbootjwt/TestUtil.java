package br.com.lepsistemas.springbootjwt;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lepsistemas.springbootjwt.dto.CredentialsDTO;

public class TestUtil {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	public static byte[] credentials(String username, String password) throws IOException {
		return convertObjectToJsonBytes(instantiateCredentials(username, password));
	}

	private static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsBytes(object);
	}

	private static CredentialsDTO instantiateCredentials(String username, String password) {
		CredentialsDTO credentials = new CredentialsDTO();
		credentials.setUsername(username);
		credentials.setPassword(password);
		return credentials;
	}
}