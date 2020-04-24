package me.sup2is.memberservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberChangeModel {

    private Long id;
    private String message;

}
