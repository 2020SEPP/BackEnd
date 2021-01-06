package com.pclogo.demo.schedule;

import com.pclogo.demo.match.Room;

import com.pclogo.demo.match.RoomUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ScheduleCheck {
    @Scheduled(fixedRate = 5 * 60 * 1000)
    void test()
    {
        long current_time = System.currentTimeMillis();
        for(Map.Entry<Integer, RoomUtil> entry : Room.rooms.entrySet())
        {
            if(current_time - entry.getValue().user1LastTime > 5000 && current_time - entry.getValue().user2LastTime > 5000)
            {
//                System.out.println("抹除了" + entry.getKey());
                Room.rooms.remove(entry.getKey());
            }
        }
    }
}
