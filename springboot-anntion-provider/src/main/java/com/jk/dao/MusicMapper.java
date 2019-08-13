/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MusicMapper2
 * Author:   李辉
 * Date:     2019/8/7 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.dao;

import com.jk.model.Music;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 李辉
 * @create 2019/8/7
 * @since 1.0.0
 */
public interface MusicMapper {

    @Select("select * from t_music m,t_type l where m.type=l.id")
    List<Music> queryMusic();
    @Insert("insert into t_music (type,name,time) values(#{type},#{name},#{time})")
    void addMusic(Music music);


    @Update("update t_music set type=#{type},name=#{name},time=#{time} where id=#{id}")
    void updateMusic(Music music);

    void deleteMusic(String[] id);
}