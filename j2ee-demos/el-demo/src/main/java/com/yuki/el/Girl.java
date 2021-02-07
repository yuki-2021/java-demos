package com.yuki.el;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Girl {

    private String name;
    private Integer age;
    private String city;
    private List<String> hobby = new ArrayList<String>();
}
