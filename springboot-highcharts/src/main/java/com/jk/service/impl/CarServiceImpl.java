/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CarServiceImpl
 * Author:   李辉
 * Date:     2019/8/12 19:34
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.dao.CarDao;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 李辉
 * @create 2019/8/12
 * @since 1.0.0
 */
@Service
public class CarServiceImpl  implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Map<String, Object>> querycar() {

        return carDao.querycar();
    }

    @Override
    public List<Map<String, Object>> queryZhuxing() {
        return carDao.queryZhuxing();    }

    @Override
    public List<Map<String, Object>> querybing() {
        return  carDao.querybing();
    }

    @Override
    public List<Map<String, Object>> queryzhe() {
        return carDao.queryzhe();
    }
}