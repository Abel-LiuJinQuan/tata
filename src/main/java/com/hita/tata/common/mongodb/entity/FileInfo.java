package com.hita.tata.common.mongodb.entity;

import java.io.Serializable;

/**
 * 文件保存信息基本类
 * Created by KennyLau on 2017-5-13.
 */
public class FileInfo implements Serializable {
//    private String id;
    private String fileName;
    private String path;
//    private String type;
    private Long size;
//    private Map<String,Object> metaData;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

//    public Map<String, Object> getMetaData() {
//        return metaData;
//    }
//
//    public void setMetaData(Map<String, Object> metaData) {
//        this.metaData = metaData;
//    }
}