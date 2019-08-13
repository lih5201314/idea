/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CarController
 * Author:   李辉
 * Date:     2019/8/12 19:02
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.resources.cldr.ee.FormatData_ee;

import java.util.ArrayList;
import java.util.HashMap;
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
@Controller
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("toShow")
    public String toShow(){
        return "show";
    }

    @RequestMapping("querycar")
    @ResponseBody
    public List<Map<String,Object>>querycar(){
        List<Map<String,Object>> list= carService.querycar();
     List<Map<String,Object>> list1=new ArrayList<>();
        for(Map<String,Object>map1:list){
            Map<String,Object> map=new HashMap<>();
            Integer  object = Integer.parseInt(map1.get("颜色").toString());
            if(object==1){
                map.put("name","蓝色") ;
            }else if(object==2){
                map.put("name","白色");
            }else if (object==3){
                map.put("name","黑色");
            }else{
                map.put("name","红色");
            }
           /* map.put("x",map1.get("日"));
            map.put("y",map1.get("总个数"));*/


            Integer  x = Integer.parseInt(map1.get("日").toString());
            Integer  y = Integer.parseInt(map1.get("总个数").toString());
         /*   int aa= (int) map1.get("日");
            int bb= (int) map1.get("总个数");*/
            System.out.println(x);
            System.out.println(y);
               int [] data =new int[]{y,x};
                map.put("data",data);


            list1.add(map);

        }

        return list1;


    }
    @RequestMapping("queryZhuxing")
    @ResponseBody
    public List<Map<String, Object>> queryZhuxing(){

        List<Map<String,Object>> list= carService.queryZhuxing();
        List<Map<String,Object>> list1=new ArrayList<>();

        for (Map<String,Object> map1:list){
            Map<String,Object> map=new HashMap<>();

            Integer  object = Integer.parseInt(map1.get("颜色").toString());
            //Integer  nian = Integer.parseInt(map1.get("月").toString());
            if(object==1){
                map.put("name","蓝色") ;
            }else if(object==2){
                map.put("name","白色");
            }else if (object==3){
                map.put("name","黑色");
            }else{
                map.put("name","红色");
            }
            Integer count = Integer.parseInt(map1.get("个数").toString());
            //String sj = (map1.get("时间").toString());
            map.put("name",map1.get("时间"));
            int[] bb = new int[]{count};
            map.put("data",bb);

            list1.add(map);
        }
        return list1;
    }

    @RequestMapping("querybing")
    @ResponseBody
    public List<Map<String,Object>> queryCar(){
        List<Map<String,Object>> list= carService.querybing();
        List<Map<String,Object>> list1 =new ArrayList<>();
        for(Map<String,Object> map1 :list){
            Map<String,Object> map=new HashMap<>();
            Integer  object = Integer.parseInt(map1.get("颜色").toString());
            Integer  nian = Integer.parseInt(map1.get("月").toString());
            if(object==1){
                map.put("name",nian+"月"+"蓝色") ;
            }else if(object==2){
                map.put("name",nian+"月"+"白色");
            }else if (object==3){
                map.put("name",nian+"月"+"黑色");
            }else{
                map.put("name",nian+"月"+"红色");
            }
            //map.put("name",map1.get("日期"));
            map.put("y",map1.get("个数"));
            map.put("sliced","true");
            map.put("selected","true");
            list1.add(map);
        }



        return list1;
    }



    @RequestMapping("queryzhe")
    @ResponseBody
    public List<Map<String,Object>> queryzhe(){
        List<Map<String,Object>> list= carService.queryzhe();
        List<Map<String,Object>> list1=new ArrayList<>();

        for (Map<String,Object> map1:list) {
            Map<String,Object> map=new HashMap<>();
            map.put("name",map1.get("月份"));
            map.put("y",map1.get("数量"));
            list1.add(map);
        }
        return list1;



    }


}