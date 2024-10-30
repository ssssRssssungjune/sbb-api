package com.mysite.sbbshopapi.mapper;

import com.mysite.sbbshopapi.dto.Favorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    void insertFavorite(Favorite favorite);
    List<Favorite> selectFavoritesByUserId(Long userId);
}