package com.pclogo.demo.match;

import java.util.ArrayList;
import java.util.List;

public class RoomUtil {
    public List<Integer> users = new ArrayList<>();
    public long user1LastTime = System.currentTimeMillis();
    public long user2LastTime = System.currentTimeMillis();
    public List<String> user1Commands = new ArrayList<>();
    public List<String> user2Commands = new ArrayList<>();
}