package com.mysite.sbbshopapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mysite.sbbshopapi.dto.Favorite;

@Mapper
public interface FavoriteMapper {
    void insertFavorite(Favorite favorite);
    List<Favorite> selectFavoritesByUserId(int userId);
}