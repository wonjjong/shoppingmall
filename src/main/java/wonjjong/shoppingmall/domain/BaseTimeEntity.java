package wonjjong.shoppingmall.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
@MappedSuperClass는 테이블과 매핑 되지 않고
자식 클래스에 엔티티의 매핑정보를 상속하기 위해 사용 되기 때문에 정식 엔티티가 아니다.
그래서 find()나 JPQL등의 메소드를 사용할 수 없다.
 */
@Getter
@MappedSuperclass
@ToString
@EntityListeners(AuditingEntityListener.class)

//createBy는 AuditorAware + Spring Security를 사용해야 하는 듯
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    //상속받는 클래스마다 컬럼명을 변경할 수 있음.
    private String attributeOverride;

}
