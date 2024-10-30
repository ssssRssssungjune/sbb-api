package com.mysite.sbbshopapi.controller;

import com.mysite.sbbshopapi.dto.Favorite;
import com.mysite.sbbshopapi.dto.Product;
import com.mysite.sbbshopapi.service.FavoriteService;
import com.mysite.sbbshopapi.service.NaverShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FavoriteController {

    @Autowired
    private NaverShoppingService naverShoppingService;

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return naverShoppingService.searchProducts(query);
    }

    @PostMapping("/favorites")
    public ResponseEntity<String> addFavorite(@RequestBody Favorite favorite) {
        favoriteService.addFavorite(favorite);
        return ResponseEntity.ok("Added to favorites");
    }

    @GetMapping("/favorites")
    public List<Favorite> getFavorites(@RequestParam int userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }
}