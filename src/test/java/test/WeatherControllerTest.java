package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import test.domain.CityRequest;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {RestApplication.class})
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getCitiesWithMaxAndMinTemperature() throws Exception {
        CityRequest cityRequest = new CityRequest(Arrays.asList("Cairns", "London", "Mountain View", "Shuzenji"));
        String requestBody = new ObjectMapper().writeValueAsString(cityRequest);
        mvc.perform(
                post("/cities")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

}
