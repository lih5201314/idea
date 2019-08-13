/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MusicController
 * Author:   李辉
 * Date:     2019/8/6 19:08
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Music;
import com.jk.model.Tree;
import com.jk.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 李辉
 * @create 2019/8/6
 * @since 1.0.0
 */

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;



@RequestMapping("query")
@ResponseBody
public Map queryMusic(Integer page, Integer rows){
    HashMap map = new HashMap();
    map.put("start",(page-1)*rows);
    map.put("end",rows);
    Integer count=musicService.queryCount(map);
    List<Music> list=musicService.queryMusic(map);

    Map  m = new HashMap<>();
    m.put("total",count);
    m.put("rows",list);
    return m;
    }

/*    @RequestMapping("uploadNewsImg")
    @ResponseBody
    public String uploadNewsImg(MultipartFile img, HttpServletRequest request){
        String path = FileUtil.upload(img, request);
        return path;
    }*/




//addMusic


  /* @RequestMapping("addMusic")
    @ResponseBody
    public void addMusic(Music music,Integer id){
        if(music.getId()==null){
            musicService.addMusic(music);
        }else {
            musicService.updateMusic(music);
        }


    }


    //deleteMusic
    @RequestMapping("deleteMusic")
    @ResponseBody
    public void deleteMusic(String[] id){
System.out.println(id);
        musicService.deleteMusic(id);

    }*/

    //treeList
/*
    @RequestMapping("treeList")
    public @ResponseBody List<Tree>getTreeAll(HttpServletRequest request){

        Integer id=0;
        List<Tree> treeNode=treeNode(id);
        return treeNode;
    }
*/

   /* private List<Tree> treeNode(Integer id) {
        // TODO Auto-generated method stub
        List<Tree> treeList=musicService.queryTreeNode(id);
        for (Tree tree : treeList) {
            Integer id2=tree.getId();

            List<Tree>treeNode=treeNode(id2);
            tree.setChildren(treeNode);
        }

        return treeList;
    }
*/

}