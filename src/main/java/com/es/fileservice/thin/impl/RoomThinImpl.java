package com.es.fileservice.thin.impl;

import com.es.fileservice.dao.RoomMapper;
import com.es.fileservice.model.Room;
import com.es.fileservice.servcie.RoomService;
import com.es.fileservice.thin.RoomThin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LHL on 2016/12/12.
 */
@Service

public class RoomThinImpl implements RoomThin{
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List selectByHouseId(Long houseId) {
         List  rooms=roomService.selectByHouseId(houseId);
        return rooms;
    }

    @Override
    public int insert(Room room) {
        int n=roomService.insert(room);
        try {
            if (1==1)
                //此异常如果被catch,则事务不会回滚
                throw  new RuntimeException("aaaaaa");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return n;
    }
}
