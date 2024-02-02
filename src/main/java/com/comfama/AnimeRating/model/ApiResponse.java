/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comfama.AnimeRating.model;

import java.util.List;

/**
 *
 * @author SSSA
 */
public class ApiResponse {

    private List<AnimeModel> results;

    // otros campos y métodos según la estructura real de la respuesta

    public List<AnimeModel> getResults() {
        return results;
    }

    public void setResults(List<AnimeModel> results) {
        this.results = results;
    }
}
