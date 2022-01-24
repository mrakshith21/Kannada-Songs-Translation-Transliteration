# Kannada-Songs-Translation-Transliteration-
A spring boot application to watch YouTube videos of Kannada songs, their lyrics,  translation and transliteration

## Prerequisites
1. Java (8 or higher version) [Download](https://www.oracle.com/java/technologies/downloads/archive/)
2. Maven [Download](https://maven.apache.org/download.cgi)
## Set up
Clone this repository or download the zip file and extract into a folder
```
    cd Kannada-Songs-Translation-Transliteration
    mvn compile
    mvn package 
```
### Run
  ```
    java -jar target/SongVideoWithTranslation-0.0.1-SNAPSHOT.jar
  ```
* Go to **http://localhost:8080/** on your browser

### Note
* Currently, the application supports translation and transliteration to English only
* Around 40 songs are available
* Songs are translated and transliterated using Microsoft Azure services, planning to switch to Google Cloud services