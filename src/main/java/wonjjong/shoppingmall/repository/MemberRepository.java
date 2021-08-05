package wonjjong.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wonjjong.shoppingmall.domain.Member;


public interface MemberRepository extends JpaRepository<Member,Long> {

}
