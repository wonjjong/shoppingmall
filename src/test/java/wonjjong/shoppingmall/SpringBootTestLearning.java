package wonjjong.shoppingmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wonjjong.shoppingmall.repository.MemberRepository;

@SpringBootTest

public class SpringBootTestLearning {

    @Autowired
    private MemberRepository memberRepository;

}
