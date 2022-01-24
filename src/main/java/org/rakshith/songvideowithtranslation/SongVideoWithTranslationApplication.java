package org.rakshith.songvideowithtranslation;

import com.squareup.okhttp.*;
import org.json.JSONArray;
import org.rakshith.songvideowithtranslation.model.TextRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@SpringBootApplication
public class SongVideoWithTranslationApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SongVideoWithTranslationApplication.class, args);
        //new Helper().writeSongsToFile();
//        StructureOrganizer.copyFilesToFolders();
    }

}
