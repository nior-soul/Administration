package cn.itcast.AOP;

import cn.itcast.entity.SysLog;
import cn.itcast.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @author nior
 * @className LogAop
 * @vison 1.0.0
 * @date 2020/3/14 0:13
 */
@Component("LogAop")
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService iSysLogService;

    private Date visitTime;//开始时间
    private  Class clazz;//访问的类
    private Method method;//访问的方法

        //前置通知 获取开始时间，执行哪个类和方法
    @Before("execution(* cn.itcast.Controller.*.*(..))")
    public void DoBefore(JoinPoint jp){
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
    }

    @After("execution(* cn.itcast.Controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        //获取方法
        method = ((MethodSignature) jp.getSignature()).getMethod();
        //获取访问时长
       long time = new Date().getTime()-visitTime.getTime();
       //获取URL
        String url = "";
        if(clazz != null &&method != null&& clazz != LogAop.class) {
            //  获取类上的@ReqestMapping(value="")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();

                RequestMapping metodAnnotation = method.getAnnotation(RequestMapping.class);
                if (metodAnnotation != null){
                    String[] metodValue = metodAnnotation.value();

                    url = classValue[0]+metodValue[0];

                    //获得访问IP
                    String ip = request.getRemoteAddr();

                    //获取当前用户名
                    //从上下文中获得当前登录的用户
//                    SecurityContext context = SecurityContextHolder.getContext();
//                    //自带User
//                    User user = (User) context.getAuthentication().getPrincipal();
//                    String username = user.getUsername();
                    String username = (String) request.getSession().getAttribute("LoginSuccess");
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    String uuid = String.valueOf(UUID.randomUUID());
                    sysLog.setId(uuid);
                    //调用service
                    iSysLogService.save(sysLog);
                }
            }
        }
    }
}
