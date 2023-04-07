package com.example.test;

import lombok.Getter;

@Getter
public class FileEntity {
    private String uuid;
    private String fileName;
    private String contentType;

    public FileEntity(){}

    public FileEntity(String uuid, String fileName, String contentType){
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;
    }

}
