package com.jk.action;

import java.io.File;
import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.jk.util.FileUtil;



@ParentPackage("struts-default")
@Namespace("/")
@Action("upFile")
public class UpFileAction  extends BaseAction {
	private static final long serialVersionUID = 6025923213261706934L;
	//上传的文件
	private File image;
	//上传的文件名称
	private String imageFileName;

	public void upFile(){
	//	System.out.println(image);
		//System.out.println(imageFileName);
		String newName = UUID.randomUUID()+imageFileName;
		String fileUpPath=FileUtil.upLoadFile(image, newName, "image");
		super.outString("{'imagePath':'"+fileUpPath+"'}");
	}
	public File getImage() {
			return image;
	}
	public void setImage(File image) {
		
			this.image = image;
			
	}
	public String getImageFileName() {
		
			return imageFileName;
			
	}
	public void setImageFileName(String imageFileName) {
		
			this.imageFileName = imageFileName;
			
	}
	

}
