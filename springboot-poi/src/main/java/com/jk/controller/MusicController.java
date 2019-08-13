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



import com.jk.model.Music;
import com.jk.service.MusicService;
import com.jk.util.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public Map queryMusic(Integer page,Integer rows){
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


   @RequestMapping("addMusic")
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

    }

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
   @RequestMapping("exportExcel")
   public void exportExcel(HttpServletResponse response,Integer page,Integer rows,String name){
       //导出的excel的标题
       String title = "1902B音乐管理";
       //导出excel的列名
       String[] rowName = {"编号","名称","类型","时间","图片"};
       //导出的excel数据
       List<Object[]>  dataList = new ArrayList<Object[]>();
       //查询的数据库的书籍信息


       List<Music> list=musicService.queryMusic2(name);
System.out.println(name);
       //循环书籍信息
       for(Music music:list){
           Object[] obj =new Object[rowName.length];
        if(name.equals("id") ){
               obj[0]=music.getId();
        }
        if(name.equals("name")){
                obj[1]=music.getName();
}
           if(name.equals("type")) {
               if (music.getType() == 1) {
                   obj[2] = "摇滚";
               } else {
                   obj[2] = "民谣";
               }
           }
        /*   SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
           String format = sdf.format(music.getTime());*/
        if(name.equals("time")){
            obj[3]=music.getTime();
        }
           if(name.equals("img")){
               obj[4]=music.getImg();
           }


           dataList.add(obj);
       }
       ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
       try {
           exportExcel.export();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file, HttpServletResponse response){
        //获得上传文件上传的类型
        String contentType = file.getContentType();
        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //获得文件的后缀名
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件的新的路径
        //生成新的文件名称
        String filePath = "./src/main/resources/templates/fileupload/";
        //创建list集合接收excel中读取的数据
        List<Music> list =new ArrayList<Music>();
        try {
            uploadFile(file.getBytes(), filePath, fileName);
           SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            //通过文件忽的WorkBook
            FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            //通过workbook对象获得sheet页 有可能不止一个sheet
            for(int i=0 ;i<workbook.getNumberOfSheets();i++){
                //获得里面的每一个sheet对象
                Sheet sheetAt = workbook.getSheetAt(i);
                //通过sheet对象获得每一行
                for(int j=3;j<sheetAt.getPhysicalNumberOfRows();j++){
                    //创建一个book对象接收excel的数据
                    Music music=new Music();
                    //获得每一行的数据
                    Row row = sheetAt.getRow(j);

                    //获得每一个单元格的数据
                    if(row.getCell(1)!=null && !"".equals(row.getCell(1))){
                        music.setName(this.getCellValue(row.getCell(1)));
                    }
                    if(row.getCell(2)!=null && !"".equals(row.getCell(2))){
                        String cellValue = this.getCellValue(row.getCell(2));
                        if("摇滚".equals(cellValue)){
                            music.setType(1);
                        }else{
                            music.setType(2);
                        }

                    }


                    if(row.getCell(3)!=null && !"".equals(row.getCell(3))){




                        music.setTime(sdf.parse(this.getCellValue(row.getCell(3))));
                    }
                    if(row.getCell(4)!=null && !"".equals(row.getCell(4))){

                        music.setImg(this.getCellValue(row.getCell(4)));
                    }
                    list.add(music);
                }
            }
            musicService.addMusicD(list);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "list";
    }

    //上传文件的方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(Cell cell){
        String value = null;
        //简单的查检列类型
        switch(cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC://数字
                long dd = (long)cell.getNumericCellValue();
                value = dd+"";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }
    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(XSSFCell cell){
        String value = null;
        //简单的查检列类型
        switch(cell.getCellType())
        {
            case HSSFCell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC://数字
                long dd = (long)cell.getNumericCellValue();
                value = dd+"";
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                value = "";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }

}