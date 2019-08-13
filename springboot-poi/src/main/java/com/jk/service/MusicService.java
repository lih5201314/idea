package com.jk.service;

import com.jk.model.Music;

import java.util.HashMap;
import java.util.List;

public interface MusicService {

    List<Music> queryMusic(HashMap map);



   void addMusic(Music music);

    void deleteMusic(String[] id);

    void updateMusic(Music music);

    Integer queryCount(HashMap map);

    List<Music> queryMusic2(String name);

    void addMusicD(List<Music> list);


    /* List<Tree> queryTreeNode(Integer id);*/
}
