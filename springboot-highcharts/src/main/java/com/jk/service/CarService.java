/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CarService
 * Author:   李辉
 * Date:     2019/8/12 19:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service;

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
public interface CarService {


    List<Map<String, Object>> querycar();

    List<Map<String, Object>> queryZhuxing();

    List<Map<String, Object>> querybing();

    List<Map<String, Object>> queryzhe();
}