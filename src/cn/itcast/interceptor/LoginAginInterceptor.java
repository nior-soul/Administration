package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nior
 * @className LoginAginInterceptor
 * @vison 1.0.0
 * @date 2020/3/16 20:46
 */
public class LoginAginInterceptor implements HandlerInterceptor {

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
        if(request.getSession().getAttribute("LoginSuccess") != null) {
            //已经登录，跳转到登录页
            response.getWriter().print("请不要重复登录");

            response.sendRedirect(request.getContextPath()+("/ReturnListJSP"));
            return false;
        }else{
            //未登陆，不拦截
            return true;
        }
    }
}
