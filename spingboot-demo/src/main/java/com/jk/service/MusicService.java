package com.jk.service;

import com.jk.model.Music;
import com.jk.model.Tree;

import java.util.List;

public interface MusicService {

    List<Music> queryMusic();

    void addMusic(Music music);

    void deleteMusic(String[] id);

    void updateMusic(Music music);


    List<Tree> queryTreeNode(Integer id);
}
