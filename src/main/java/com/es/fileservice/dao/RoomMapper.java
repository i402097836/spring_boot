package com.es.fileservice.dao;

import com.es.fileservice.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
@Mapper
//@CacheConfig(cacheNames = "rooms")
public interface RoomMapper  {
    

//    @Cacheable
    List selectByHouseId(Long houseId);
    int insert(Room room);

}