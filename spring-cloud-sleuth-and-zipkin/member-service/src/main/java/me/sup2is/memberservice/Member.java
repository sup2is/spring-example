package me.sup2is.memberservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private String password;


}
