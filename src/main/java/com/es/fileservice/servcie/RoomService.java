package com.es.fileservice.servcie;

import com.es.fileservice.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LHL on 2016/12/12.
 */

public interface RoomService {

    List selectByHouseId(Long houseId);
    int insert(Room room);

}
