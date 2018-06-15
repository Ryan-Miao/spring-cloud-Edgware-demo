package com.test.cloud.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ryan Miao at 2018-06-15 10:36
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Integer id;
    private String name;
    private Integer age;
    private LocalDate birth;
}
