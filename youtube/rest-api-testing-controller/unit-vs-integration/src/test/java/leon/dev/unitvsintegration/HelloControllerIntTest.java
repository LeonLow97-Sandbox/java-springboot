package leon.dev.unitvsintegration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import leon.dev.unitvsintegration.controllers.HelloController;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@WebMvcTest(HelloController.class)
public class HelloControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }

    @Test
    public void testHelloWithName() throws Exception {
        mockMvc.perform(get("/hello?name=Leon"))
            .andExpect(content().string("Hello, Leon"));
    }
    
}
