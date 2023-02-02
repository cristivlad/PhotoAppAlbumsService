package com.example.photoappalbumsservice.service;

import com.example.photoappalbumsservice.model.Album;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumsService {
    @Override
    public List<Album> getAlbums(String userId) {
        List<Album> returnValue = new ArrayList<>();

        Album album = new Album();
        album.setUserId(userId);
        album.setAlbumId("albumId");
        album.setDescription("album1 description");
        album.setId(1L);
        album.setName("album1 name");

        Album album2 = new Album();
        album2.setUserId(userId);
        album2.setAlbumId("albumId");
        album2.setDescription("album2 description");
        album2.setId(1L);
        album2.setName("album2 name");

        returnValue.add(album);
        returnValue.add(album2);

        return returnValue;
    }
}
