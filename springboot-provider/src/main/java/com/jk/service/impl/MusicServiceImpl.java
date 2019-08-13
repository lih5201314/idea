/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MusicServiceImpl
 * Author:   李辉
 * Date:     2019/8/7 17:32
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.MusicMapper;
import com.jk.dao.MusicMapper2;
import com.jk.model.Music;

import com.jk.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 李辉
 * @create 2019/8/7
 * @since 1.0.0
 */
@Service
public class MusicServiceImpl implements MusicService {

   @Autowired
    private MusicMapper2 musicMapper;


    @Override
    public List<Music> queryMusic(HashMap map) {
        List<Music> list=musicMapper.queryMusic(map);
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
    public Integer queryCount(HashMap map) {
        return musicMapper.queryCount(map);
    }

}



    /*@Override
    public List<Tree> queryTreeNode(Integer id) {
        return null;
    }*/

