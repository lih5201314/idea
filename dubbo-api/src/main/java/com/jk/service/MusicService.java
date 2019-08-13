package com.jk.service;

import com.jk.model.Music;
import com.jk.model.Tree;

import java.util.HashMap;
import java.util.List;

public interface MusicService {

    List<Music> queryMusic(HashMap map);



   void addMusic(Music music);

    void deleteMusic(String[] id);

    void updateMusic(Music music);

    Integer queryCount(HashMap map);


    /* List<Tree> queryTreeNode(Integer id);*/
}
