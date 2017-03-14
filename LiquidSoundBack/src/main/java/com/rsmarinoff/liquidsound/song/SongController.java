/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsmarinoff.liquidsound.song;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(
            @RequestParam MultipartFile file) throws IOException {

        Song song = new Song();

        String name = file.getOriginalFilename();
        song.setContentType(file.getContentType());
        song.setName(name);
        song.setContent(file.getBytes());
        song = songRepository.save(song);
        return "SONG SAVED WITH ID OF " + song.getId();
    }

    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("id") Long id,
            HttpServletResponse response) throws IOException {
        Song song = songRepository.findOne(id);
        // response.setContentType("audio/mpeg");
        response.setContentType(song.getContentType());
        response.addHeader("Content-Disposition", "attachment; filename=\"" + song.getName() + "\"");
        IOUtils.copy(new ByteArrayInputStream(song.getContent()), response.getOutputStream());
        response.flushBuffer();
    }

}
