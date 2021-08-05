package wonjjong.shoppingmall.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@ToString
@Table(name = "member_jongmin")
@AttributeOverride(name = "attributeOverride", column = @Column(name = "MEMBER_ATTRIBUTEOVERRIDE"))
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Address address;

    private String userName;
    private String email;
    private String phoneNumber;

    @Builder
    private Member(String username, String email) {
        this.userName = username;
        this.email = email;
    }
}
