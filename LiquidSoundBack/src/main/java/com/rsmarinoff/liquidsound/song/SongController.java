/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsmarinoff.liquidsound.song;

import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Song uploadFileHandler(
            HttpServletRequest httpServletRequest) throws IOException {
        InputStream stream = httpServletRequest.getInputStream();
        // String str_request = IOUtils.toString(httpServletRequest.getInputStream());
        byte[] attachement = ByteStreams.toByteArray(stream);
        String filename = httpServletRequest.getHeader("filename");
        String contentType = httpServletRequest.getHeader("Content-Type");

        Song song = new Song();
        song.setContentType(contentType);
        song.setName(filename);
        song.setContent(attachement);
        return songRepository.save(song);
    }

    @CrossOrigin
    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("id") Long id,
            HttpServletResponse response) throws IOException {
        Song song = songRepository.findOne(id);
        response.setContentType(song.getContentType());
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + song.getName() + "\"");
        response.setStatus(HttpServletResponse.SC_OK);
        StreamUtils.copy(new ByteArrayInputStream(song.getContent()), response.getOutputStream());
        response.flushBuffer();
    }

}
