/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comfama.AnimeRating.service;

import com.comfama.AnimeRating.model.ApiResponse;
import com.comfama.AnimeRating.model.AnimeModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author SSSA
 */
@Service
public class AnimeService {
    
    @Value("${jikan.url}") 
    private String jikanApiUrl;
    
    @Autowired
    private RestTemplate restTemplate;

    public AnimeModel searchAnime(String title) {
        try {
            // Construir la URL de la API de Jikan para buscar anime por título
            String apiUrl = jikanApiUrl + "/search/anime?q=" + URLEncoder.encode(title, StandardCharsets.UTF_8.toString());

            // Realizar la solicitud HTTP utilizando RestTemplate
            ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(apiUrl, ApiResponse.class);

            // Verificar si la respuesta es exitosa (código 2xx)
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                // Obtener el resultado del cuerpo de la respuesta
                ApiResponse apiResponse = responseEntity.getBody();

                // Verificar si hay resultados y devolver el primero (puedes adaptar según tus necesidades)
                if (apiResponse != null && apiResponse.getResults() != null && !apiResponse.getResults().isEmpty()) {
                    return apiResponse.getResults().get(0);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // En caso de error o falta de resultados, puedes devolver null o manejarlo de otra manera
        return null;
    }

    
}
