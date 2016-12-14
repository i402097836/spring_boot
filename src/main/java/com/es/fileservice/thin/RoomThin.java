package com.es.fileservice.thin;

import com.es.fileservice.model.Room;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LHL on 2016/12/12.
 */
@Transactional //为此类的所有方法加入事务控制
public interface RoomThin {
    @Transactional(propagation = Propagation.NOT_SUPPORTED)//使此方法不支持事务
    List selectByHouseId(Long houseId);

    int insert(Room room);
}
