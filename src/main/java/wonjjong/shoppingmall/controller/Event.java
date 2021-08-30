package wonjjong.shoppingmall.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Event {
    private Integer id;
    private String name;

    @Min(0)
    private Integer limit;
}
