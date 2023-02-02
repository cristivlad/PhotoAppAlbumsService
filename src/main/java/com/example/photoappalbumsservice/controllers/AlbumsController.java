package com.example.photoappalbumsservice.controllers;

import com.example.photoappalbumsservice.model.Album;
import com.example.photoappalbumsservice.model.AlbumResponseModel;
import com.example.photoappalbumsservice.service.AlbumsService;
import com.google.common.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumsController {

    private final Logger log = LoggerFactory.getLogger(AlbumsController.class);
    private final AlbumsService albumsService;

    public AlbumsController(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }

    @GetMapping
    public List<AlbumResponseModel> userAlbums(@PathVariable String id) {
        List<AlbumResponseModel> returnValue = new ArrayList<>();
        List<Album> albumEntities = albumsService.getAlbums(id);

        if (albumEntities == null || albumEntities.isEmpty()) {
            return returnValue;
        }

        Type listType = new TypeToken<List<AlbumResponseModel>>(){}.getType();

        returnValue = new ModelMapper().map(albumEntities, listType);
        log.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }
}
