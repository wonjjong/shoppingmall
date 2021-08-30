package wonjjong.shoppingmall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import wonjjong.shoppingmall.controller.Event;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestBodyTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void postEventReqeustBody() throws Exception {
        Event event = Event.builder().name("wonjjong").limit(10).build();

        mockMvc.perform(post("/events/requestBody")
                .content(objectMapper.writeValueAsString(event))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("wonjjong"))
                .andExpect(jsonPath("limit").value(10))
                ;


    }

    @Test
    public void postEventModelAttribute() throws Exception {
        Event event = Event.builder().name("wonjjong").limit(10).build();

        //the value of the request body cannot be bound to the DTO object;
        mockMvc.perform(post("/events/modelAttribute")
                .content(objectMapper.writeValueAsString(event))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("wonjjong"))
                .andExpect(jsonPath("limit").value(10))
        ;

        //need setter methods
        mockMvc.perform(post("/events/modelAttribute")
        .param("name","wonjjong")
        .param("limit","10"))
        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("wonjjong"))
                .andExpect(jsonPath("limit").value(10))
        ;
    }

}
