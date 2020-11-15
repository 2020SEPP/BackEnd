package com.pclogo.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserUtil {
    Boolean judge;
    String token;
    Integer uid;
    List<Integer> friends;
}
