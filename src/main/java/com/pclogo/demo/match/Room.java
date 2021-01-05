package com.pclogo.demo.match;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Room {
    public static Integer current_id;
    public static Map<Integer, RoomUtil> rooms;
    public Room()
    {
        current_id = 0;
        rooms = new HashMap<>();
    }
}
