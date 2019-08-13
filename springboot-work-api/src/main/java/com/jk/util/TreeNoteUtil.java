package com.jk.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.model.Permission;


 

public class TreeNoteUtil {
    
    /**
     * 鑾峰彇鐖惰妭鐐硅彍鍗�
     * @param treesList 鎵�鏈夋爲鑿滃崟闆嗗悎
     * @return
     */
    public final static List<Permission> getFatherNode(List<Permission> treesList){
        List<Permission> newTrees = new ArrayList<Permission>();
        for (Permission mt : treesList) {
            if (mt.getPid() ==null || "".equals(mt.getPid()) || mt.getPid()==0 ) {//濡傛灉pId涓虹┖锛屽垯璇ヨ妭鐐逛负鐖惰妭鐐�
                //閫掑綊鑾峰彇鐖惰妭鐐逛笅鐨勫瓙鑺傜偣
                mt.setChildren(getChildrenNode(mt.getId().toString(), treesList));
                newTrees.add(mt);
            }
        }
        return newTrees;
    }
    
    /**
     * 閫掑綊鑾峰彇瀛愯妭鐐逛笅鐨勫瓙鑺傜偣
     * @param pId 鐖惰妭鐐圭殑ID
     * @param treesList 鎵�鏈夎彍鍗曟爲闆嗗悎
     * @return
     */
    private final static List<Permission> getChildrenNode(String pId, List<Permission> treesList){
        List<Permission> newTrees = new ArrayList<Permission>();
        for (Permission mt : treesList) {
            if (mt.getPid()==null || mt.getPid()==0) continue;
            if(mt.getPid() == Integer.valueOf(pId) ){
                //閫掑綊鑾峰彇瀛愯妭鐐逛笅鐨勫瓙鑺傜偣锛屽嵆璁剧疆鏍戞帶浠朵腑鐨刢hildren
                mt.setChildren(getChildrenNode(mt.getId().toString(), treesList));
                //璁剧疆鏍戞帶浠禷ttributes灞炴�х殑鏁版嵁
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url", mt.getUrl());
                mt.setAttributes(map);
                newTrees.add(mt);
            }
        }
        return newTrees;
    }
}
