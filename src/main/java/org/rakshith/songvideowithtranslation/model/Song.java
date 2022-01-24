package org.rakshith.songvideowithtranslation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private String lyrics;
    private String movie;
    private String yearOfRelease;
    private String musicDirector;
    private String singers;
    private String cast;
}
