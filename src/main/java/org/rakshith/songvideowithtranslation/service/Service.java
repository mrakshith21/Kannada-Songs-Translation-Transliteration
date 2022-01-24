package org.rakshith.songvideowithtranslation.service;

import org.rakshith.songvideowithtranslation.model.Song;
import org.rakshith.songvideowithtranslation.model.SongList;

import com.squareup.okhttp.*;
import org.rakshith.songvideowithtranslation.model.TextRequest;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {

    final String youTubeEmbedUrl = "https://www.youtube.com/embed/";

    @Autowired
    ResourceLoader resourceLoader;

    final Map<String, String> languageCode = new HashMap<>() {
        {
            put("kannada", "kn");
            put("hindi", "hi");
            put("english", "en");
        }
    };

    final Map<String, String> languageScript = new HashMap<>() {
        {
            put("kannada", "Knda");
            put("hindi", "Deva");
            put("english", "Latn");
        }
    };

    final Map<String, String> myLanguageCode = new HashMap<>() {
        {
            put("kannada", "kn");
            put("hindi", "hi");
            put("english", "en");
        }
    };
    Map<String, String> songToVideoId = new HashMap<>();
    Map<String, String> songToMovieName = new HashMap<>();

    public InputStream getInputStream(String path) throws IOException {
        return resourceLoader.getResource("classpath:" + path + ".txt").getInputStream();
    }

    public Song getSong(String songName) throws IOException {
        InputStream songStream = getInputStream("Kannada/" + songToMovieName.get(songName) + "/" + songName);
        return new Song(readInputStream(songStream), "", "", "", "", "");

    }

    public String readInputStream(InputStream inputStream) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        String line = "";
        String s = "";
        while ((line = br.readLine()) != null){
            s += line + '\n';
        }
        return s;
    }

    public SongList getSongs() throws Exception{
        List<String> songList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(resourceLoader.getResource("classpath:songs_id.txt").getInputStream(), StandardCharsets.UTF_8));
        String line = "";
        while ((line = br.readLine()) != null){
            String[] arr = line.split(",");
            String name = arr[0].trim(), id = arr[1].trim();
            songToVideoId.put(name, id);
            songList.add(name);
        }
        final String LYRICS_DIRECTORY = "Kannada";
        File folder = new File("src\\main\\resources\\" + LYRICS_DIRECTORY);
        for(File movie : folder.listFiles()) {
            for (File song : movie.listFiles()) {
                songToMovieName.put(song.getName().substring(0, song.getName().lastIndexOf('.')), movie.getName());
            }
        }
        return new SongList(songList);
    }



    public String getVideoId(String songName){
        return youTubeEmbedUrl + songToVideoId.get(songName);
    }

    public String getTranslation(String songName, String language) throws IOException {

        InputStream inputStream = getInputStream("translations/" + songToMovieName.get(songName) + "/" + songName + "." + myLanguageCode.get(language.toLowerCase()));
        return readInputStream(inputStream);
    }

    public String getTransliteration(String songName, String language) throws IOException {

        InputStream inputStream = getInputStream("transliterations/" + songToMovieName.get(songName)+  "/" + songName  + "." + myLanguageCode.get(language.toLowerCase()));
        return readInputStream(inputStream);
    }

}
