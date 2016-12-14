package com.es.fileservice.servcie.impl;

import com.es.fileservice.dao.RoomMapper;
import com.es.fileservice.model.Room;
import com.es.fileservice.servcie.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LHL on 2016/12/12.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List selectByHouseId(Long houseId) {
        return roomMapper.selectByHouseId(houseId);
    }

    @Override
    public int insert(Room room) {
        return roomMapper.insert(room);
    }


}
