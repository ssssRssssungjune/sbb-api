package com.mysite.sbbshopapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.sbbshopapi.dto.Favorite;
import com.mysite.sbbshopapi.mapper.FavoriteMapper;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    public void addFavorite(Favorite favorite) {
        favoriteMapper.insertFavorite(favorite);
    }

    public List<Favorite> getFavoritesByUserId(int userId) {
        return favoriteMapper.selectFavoritesByUserId(userId);
    }
}
