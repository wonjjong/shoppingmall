package wonjjong.shoppingmall.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import wonjjong.shoppingmall.controller.MemberController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebMvcTest(MemberController.class)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ApplicationContext ac;


    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"dsunni\", \"password\":\"123\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(equalTo("dsunni"))))
                .andExpect(jsonPath("$.password", is(equalTo("123"))));
    }
    @Test
    public void connectionTest() throws SQLException {
        System.out.println("ac = " + ac);
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        Assertions.assertThat(connection).isNotNull();
    }

    @BeforeEach
    public void init() {

    }

    @Test
    public void createNewMember() {

    }
}