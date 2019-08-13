package com.jk.log;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jk.model.LogModel;
import com.jk.model.User;

@Aspect
@Component
public class SysLogAspect {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Pointcut("execution(* com.jk.controller..*(..))")
	public void logPointcut(){}
	
	@AfterReturning(value="logPointcut()" ,returning="returningValue")
	public void myAfter(JoinPoint jp,Object returningValue) throws UnknownHostException{
//System.out.println("《注解形式-后置通知》：目标对象："+jp.getTarget()+",方法名："+jp.getSignature().getName() +",参数列表："+  jp.getArgs().length+",返回值："+returningValue );
	LogModel logModel = new LogModel();
	logModel.setLogip(getIp());
	logModel.setLogis("true");
	String className = jp.getTarget().getClass().toString().substring(jp.getTarget().getClass().toString().lastIndexOf(".")+1);
	if(className.equals("UserController")){
		logModel.setLogname("登陆日志");
	}
	if(className.equals("TreeController")){
		logModel.setLogname("菜单日志");
	}

	if(className.equals("UserListController")){
		logModel.setLogname("用户日志");
	}
	if(className.equals("RoleController")){
		logModel.setLogname("角色日志");
	}
	logModel.setLogtime(new Date());
	logModel.setRequerpath(jp.getTarget().getClass()+"/"+jp.getSignature().getName());
	logModel.setReturningValue(returningValue);
	/*Object[] args = jp.getArgs();
	if(args!=null){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
			stringBuffer.append("第"+i+"个参数=").append(args[i].toString());
		}
		logModel.setParame(stringBuffer.toString());
	}*/
	
	HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	
	User user = (User) request.getSession().getAttribute("user");
	
	if(user!=null){
		logModel.setUserId((user.getId().toString()));
		}
	if(logModel!=null){
		mongoTemplate.insert(logModel, "t_log");
	}
	
	}
	 /**
     * 获取  ip 地址
     * @return
     * @throws UnknownHostException
     */
    private String getIp() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr.getHostAddress();
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress.getHostAddress();
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
            }
            return jdkSuppliedAddress.getHostAddress();
        } catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException(
                    "Failed to determine LAN address: " + e);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
 
}
