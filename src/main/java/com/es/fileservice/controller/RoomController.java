package com.es.fileservice.controller;

import com.es.fileservice.dao.RoomMapper;
import com.es.fileservice.model.Room;
import com.es.fileservice.servcie.RoomService;
import com.es.fileservice.thin.RoomThin;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by LHL on 2016/12/12.
 */
@RestController
public class RoomController {
    private Logger logger = LoggerFactory.getLogger(Room.class);
    @Autowired
    private MongoClient mongoClient;


    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomThin roomThin;
    @Value(value = "${spring.data.mongodb.uri:127.0.0.1}")
    private String url;
    @RequestMapping("/room")
    public List<Room> getListRoom(){

        System.out.println("=======>url:"+url);
        List<Room> rooms = roomService.selectByHouseId(133L);
        System.out.println("==========>"+mongoClient.toString());
        MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
        GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDatabase);
        GridFSUploadOptions gridFSUploadOptions = new GridFSUploadOptions()
                .chunkSizeBytes(255 * 1024);
        ObjectId objectId =new ObjectId("58450f085b72a612c849c2b6");
        FileOutputStream fileOutputStream = null;
        String fileName=null;
        try {
            //得到输入流
            GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(objectId);
            if (gridFSDownloadStream != null) {
                //从流中取filename
                fileName = gridFSDownloadStream.getGridFSFile().getFilename();
            }
            String localFile = System.getProperty("java.io.tmpdir")+File.separator + fileName;

            fileOutputStream = new FileOutputStream(localFile);
            //download
            gridFSBucket.downloadToStream(objectId, fileOutputStream);
            System.out.println(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return rooms;
    }
    @RequestMapping("/insertRoom")
    public int addRoom(){

        Room room = new Room();
        room.setCreateTime(LocalDateTime.now());
        room.setImageId(1111);
        room.setHouseId(133L);
        room.setRoomName("spring-boot");
        int n= roomThin.insert(room);
        System.out.println(room.getId());
        return  n;
    }
}
