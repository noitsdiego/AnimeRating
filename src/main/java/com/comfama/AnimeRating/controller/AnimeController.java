/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comfama.AnimeRating.controller;

import com.comfama.AnimeRating.model.AnimeModel;
import com.comfama.AnimeRating.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SSSA
 */
@Controller
public class AnimeController {
    
    @Autowired
	private AnimeService animeService;
    
    @GetMapping("/api/anime/search")
    public ResponseEntity<AnimeModel> searchAnime(@RequestParam String title) {
        AnimeModel animeModel = animeService.searchAnime(title);

        // Verificar si se encontró un anime y retornar la respuesta correspondiente
        if (animeModel != null) {
            return ResponseEntity.ok(animeModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
