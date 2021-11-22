package com.stackoverlow.autowire.validation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AppTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	public void givenValidDto_thenOk() throws Exception {
		this.mockMvc
				.perform(post("/some").contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\": \"john\",\"email\": \"john.doe@localhost\",\"custom\": \"heLLo\"}"))
				.andExpect(status().isOk());
	}

	@Test
	public void givenInvalidCustom_thenNotOk() throws Exception {
		this.mockMvc
				.perform(post("/some").contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\": \"john\",\"email\": \"john.doe@localhost\",\"custom\": \"heLLA\"}"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void givenNoName_thenNotOk() throws Exception {
		this.mockMvc
				.perform(post("/some").contentType(MediaType.APPLICATION_JSON)
						.content("{\"email\": \"john.doe@localhost\",\"custom\": \"heLLA\"}"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void givenEmptyEmail_thenNotOk() throws Exception {
		this.mockMvc.perform(post("/some").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"john\",\"custom\": \"heLLA\"}")).andExpect(status().isBadRequest());
	}

	@Test
	public void givenInvalidEmail_thenNotOk() throws Exception {
		this.mockMvc
				.perform(post("/some").contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\": \"john\",\"email\": \"john.doe\",\"custom\": \"heLLA\"}"))
				.andExpect(status().isBadRequest());
	}
}
