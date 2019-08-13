/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestController
 * Author:   李辉
 * Date:     2019/8/6 21:50
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 李辉
 * @create 2019/8/6
 * @since 1.0.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("query")
    public String queryMusic(){
        return "list";
    }

}