package com.example.photoappalbumsservice.service;

import com.example.photoappalbumsservice.model.Album;

import java.util.List;

public interface AlbumsService {
    List<Album> getAlbums(String userId);
}
