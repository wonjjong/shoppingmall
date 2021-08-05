package wonjjong.shoppingmall.db;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import wonjjong.shoppingmall.domain.Member;
import wonjjong.shoppingmall.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc //@AutoConfigureMockMvc를 통해 MockMvc를 Builder없이 주입 받을 수 있다. 스프링부트의 매력인 Auto Config의 장점이다.
@Rollback(false)
public class MysqlConnectionsTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @BeforeEach
    public void before() {
        Member member1 = Member.builder().username("wonjjong").email("wjm358@naver.com").build();
        Member member2 = Member.builder().username("wjm358").email("wonjjong.dev@gmail.com").build();
        memberRepository.save(member1);
        memberRepository.save(member2);
    }

    @Test
    @DisplayName("status code test")
    public void statusCodeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/status_code"))
                .andDo(print());
    }

    @Test
    @DisplayName("responsebody test")
    public void responseEntityBodyTest() {

    }
    @Test
    @DisplayName("Auditing injection test")
    public void auditingTest() {

        Member member = new Member();

        System.out.println("member = " + member);

        Member saved = memberRepository.save(member);
        Assertions.assertThat(member).isEqualTo(saved);

        System.out.println("member'' = " + member);


    }

    @Test
    public void connectionTest() throws SQLException {
        System.out.println("ac = " + ac);

        DataSource dataSource = (DataSource) ac.getBean("dataSource");

        Connection connection = dataSource.getConnection();
        
        Assertions.assertThat(connection).isNotNull();

//        try {
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306",
//                    "root",
//                    "dnjswhdals1@"
//            );
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(
//                    "show databases"
//            );
//
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
