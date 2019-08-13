/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CarDao
 * Author:   李辉
 * Date:     2019/8/12 19:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 李辉
 * @create 2019/8/12
 * @since 1.0.0
 */
public interface CarDao {
    @Select("select   DATE_FORMAT(carTime,'%d') 日,count(color)  总个数,color 颜色   from t_car  t  GROUP  BY color")
    List<Map<String, Object>> querycar();
    @Select("select   DATE_FORMAT(carTime,'%y') 时间,count(color)  个数,color 颜色   from t_car  t  GROUP  BY color")
    List<Map<String, Object>> queryZhuxing();
    @Select("select   DATE_FORMAT(carTime,'%m') 月,count(color)  个数,color 颜色   from t_car  t  GROUP  BY color")
    List<Map<String, Object>> querybing();
    @Select(" SELECT count(*) 数量,DATE_FORMAT(carTime,'%w')  月份 from t_car b GROUP BY DATE_FORMAT(carTime,'%w')")
    List<Map<String, Object>> queryzhe();
}