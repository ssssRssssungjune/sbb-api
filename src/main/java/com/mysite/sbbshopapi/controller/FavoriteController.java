package com.mysite.sbbshopapi.controller;

import com.mysite.sbbshopapi.dto.Favorite;
import com.mysite.sbbshopapi.dto.Product;
import com.mysite.sbbshopapi.service.FavoriteService;
import com.mysite.sbbshopapi.service.NaverShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FavoriteController {

    private final NaverShoppingService naverShoppingService;
    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(NaverShoppingService naverShoppingService, FavoriteService favoriteService) {
        this.naverShoppingService = naverShoppingService;
        this.favoriteService = favoriteService;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return naverShoppingService.searchProducts(query);
    }

    @PostMapping("/favorites")
    public ResponseEntity<String> addFavorite(@RequestBody Favorite favorite) {
        favoriteService.addFavorite(favorite);
        return new ResponseEntity<>("Added to favorites", HttpStatus.CREATED);
    }

    @GetMapping("/favorites")
    public List<Favorite> getFavorites(@RequestParam Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }
}
