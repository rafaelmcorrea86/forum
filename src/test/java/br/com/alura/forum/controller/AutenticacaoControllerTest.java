package br.com.alura.forum.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws Exception {
		
		URI uri = new URI("/auth");
		String jsonBadRequest = "{\"email:\"\"invalido@email.com\",\"senha:\"\"123456\"}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(jsonBadRequest)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
		
//		String jsonOk = "{\"email:\"\"aluno@email.com\",\"senha:\"\"$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq\"}";
//		
//		mockMvc.perform(MockMvcRequestBuilders
//				.post(uri)
//				.content(jsonOk)
//				.contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().is(200));
		
	}

}
