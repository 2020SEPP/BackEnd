package com.pclogo.demo.serviceImpl;

import com.pclogo.demo.match.Room;
import com.pclogo.demo.match.RoomUtil;
import com.pclogo.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MatchServiceImpl implements MatchService {
//    static Room room;

    @Override
    public Integer createRoom(Integer uid) {
        System.out.println(Room.current_id);
        Room.current_id++;
        RoomUtil roomUtil = new RoomUtil();
        roomUtil.users.add(uid);
        Room.rooms.put(Room.current_id, roomUtil);
        return Room.current_id;
    }

    @Override
    public Boolean joinById(Integer uid, Integer rid) {
        RoomUtil roomUtil = Room.rooms.get(rid);
        if(roomUtil == null) return false;
        else if(roomUtil.users.size() >= 2) return false;
        roomUtil.users.add(uid);
        Room.rooms.put(rid, roomUtil);
        return true;
    }

    @Override
    public Integer joinSrand(Integer uid) {
        if(Room.rooms.size() == 0) return -1;
        for(Map.Entry<Integer, RoomUtil> entry : Room.rooms.entrySet())
        {
            if(entry.getValue().users.size() == 1)
            {
                RoomUtil roomUtil = entry.getValue();
                roomUtil.users.add(uid);
                Integer rid = entry.getKey();
                Room.rooms.put(rid, roomUtil);
                return rid;
            }
        }
        return -1;
    }

    @Override
    public Boolean sendCommand(Integer uid, Integer rid, String command) {
        for(Map.Entry<Integer, RoomUtil> entry : Room.rooms.entrySet())
        {
            if(entry.getKey().equals(rid))
            {
                if(entry.getValue().users.get(0).equals(uid))
                {
                    entry.getValue().user1Commands.add(command);
                    entry.getValue().user1LastTime = System.currentTimeMillis();
                }
                else
                {
                    entry.getValue().user2Commands.add(command);
                    entry.getValue().user2LastTime = System.currentTimeMillis();
                }
                Room.rooms.put(entry.getKey(), entry.getValue());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getCommand(Integer uid, Integer rid) {
        return null;
    }
}
