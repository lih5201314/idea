/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MusicServiceImpl
 * Author:   李辉
 * Date:     2019/8/6 19:41
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.dao.MusicMapper;
import com.jk.model.Music;
import com.jk.model.Tree;
import com.jk.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 李辉
 * @create 2019/8/6
 * @since 1.0.0
 */
@Service
public class MusicServiceImpl implements  MusicService {

    @Autowired
    private MusicMapper musicMapper;


    @Override
    public List<Music> queryMusic() {
        List<Music> list=musicMapper.queryMusic();
        return list;
    }

    @Override
    public void addMusic(Music music) {
        musicMapper.addMusic(music);
    }

    @Override
    public void deleteMusic(String[] id) {
        musicMapper.deleteMusic(id);
    }

    @Override
    public void updateMusic(Music music) {
        musicMapper.updateMusic(music);
    }

    @Override
    public List<Tree> queryTreeNode(Integer id) {
        return musicMapper.queryTreeNode(id);
    }
}