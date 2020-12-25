package com.mot.wappmot.service;

import com.mot.wappmot.Exceptions.FileStorageException;
import com.mot.wappmot.Exceptions.MyFileNotFoundException;
import com.mot.wappmot.model.DBFile;
import com.mot.wappmot.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) throws Exception {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {

            if (fileName.contains("..")) {

                throw new FileStorageException("Filename contains invalid path sequence"+fileName);

            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);

        }catch (IOException exception){

            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", exception);

        }


    }

    public DBFile getFile(String fileId){

        return dbFileRepository.findById(fileId).orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));

    }

}
