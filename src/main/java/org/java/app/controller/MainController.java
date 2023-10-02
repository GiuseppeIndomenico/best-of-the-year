package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.Movie;
import org.java.app.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

	
	
	@GetMapping("/")
	@ResponseBody
	public String test() {
		return "ciao mondo";
	}
	
	@GetMapping("/welcome")
	
	public String welcome() {
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getBestMovies(Model model) {
		List<Movie> bestMovies = getBestMovies();
			
		
		model.addAttribute("bestMovies", bestMovies);
        return "movies";
		
	}
    @GetMapping("/movies/{id}")
    @ResponseBody
    public String getMovieTitleById(@PathVariable int id) {
        List<Movie> movies = getBestMovies(); 

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie.getTitolo(); 
            }
        }


        return "Film non trovato";
    }
    
    @GetMapping("/songs/{id}")
    @ResponseBody
    public String getSongTitleById(@PathVariable int id) {
        List<Song> songs = getBestSongs(); 

        for (Song song : songs) {
            if (song.getId() == id) {
                return song.getTitolo(); 
            }
        }


        return "Canzone non trovata";
    }



	@GetMapping("/songs")
	public String getBestSongs(Model model) {
	    List<Song> bestSongs = getBestSongs();
	    model.addAttribute("bestSongs", bestSongs);
	    return "songs";
	}

	
	
	 private List<Movie> getBestMovies() {
	        List<Movie> movies = new ArrayList<>();
	        movies.add(new Movie(1, "Ritorno al futuro"));
	        movies.add(new Movie(2, "Indiana Jones"));
	        movies.add(new Movie(3, "Jurassic park"));
	        
	        return movies;
	    }

	    private List<Song> getBestSongs() {
	        List<Song> songs = new ArrayList<>();
	        songs.add(new Song(1, "Back in black"));
	        songs.add(new Song(2, "You give love a bad name"));
	        songs.add(new Song(3, "Bohemian Rapsody"));
	
	        return songs;
	    }
	    
	    
	
}
