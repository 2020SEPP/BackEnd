package com.pclogo.demo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collation = "userMongo")
public class UserMongo {
    @Field("id")
    Integer id;

    @Field("friends")
    List<Integer> friends;

    @Field("invit")
    List<Integer> invit;

    @Field("avatar")
    String avatar;
}
