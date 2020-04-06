package cn.itcast.interceptor;

/**
 * @author nior
 * @className LoginInterceptor
 * @vison 1.0.0
 * @date 2020/3/14 21:36
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;


/**
 * 配置拦截器，拦截未登录用户
 * @author nior
 * @version 2020年2月28日
 * @since 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        //执行完毕，返回前拦截
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
        //处理过程中执行拦截
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        //在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        //返回false则不执行拦截
        if(request.getSession().getAttribute("LoginSuccess") == null || request.getSession().getAttribute("LoginSuccess") == "") {
            //登录失败，跳转到登录页
            response.getWriter().print("请登录");

            response.sendRedirect(request.getContextPath()+("/login.jsp"));
            return false;
        }else{
            //登陆成功，不拦截
            return true;
        }
    }

}
