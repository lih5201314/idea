package com.jk.dao;

import com.jk.model.Music;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MusicMapper {
    @Select("select * from t_music m,t_type l where m.type=l.id")
    List<Music> queryMusic();
@Insert("insert into t_music (type,name,time) values(#{type},#{name},#{time})")
    void addMusic(Music music);

    void deleteMusic(@Param("id") String[] id);
@Update("update t_music set type=#{type},name=#{name},time=#{time} where id=#{id}")
    void updateMusic(Music music);
@Select("select * from t_tree where pid=#{id}")
    List<Tree> queryTreeNode(Integer id);
}
