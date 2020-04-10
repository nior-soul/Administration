package cn.itcast.Controller;


import cn.itcast.entity.OrderForm;
import cn.itcast.entity.PageBean;
import cn.itcast.entity.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller

@RequestMapping(value = "/")
public class Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private  HttpServletRequest request;

    @RequestMapping(value = "/login")
    public String login(User user){
        User loginuser = userService.login(user.getEmail(), user.getPassword());
        if (loginuser == null){
            request.getSession().setAttribute("LoginAuthentication",false);
            return "redirect:/login.jsp";
        }
        else {
            request.getSession().setAttribute("LoginSuccess",loginuser.getUsername());
            return "list";

        }
    }

    @RequestMapping(value = "/addorderformJSP")
    public String AddOrderFormJSP(){
        return "addorderform";
    }

    @RequestMapping(value = "/ReturnListJSP")
    public String ReturnListJSP(){
        return "list";
    }

    @RequestMapping(value = "/AddOrderForm")
    public String AddOrderForm(OrderForm orderForm){
        userService.AddOrderForm(orderForm);
        return "list";
    }

    @RequestMapping(value = "/DelOrderForm")
    public String DelOrderForm(int id){
        userService.DelOrderForm(id);
        return "list";
    }

    @RequestMapping(value = "/UpdateOrderFormJSP")
    public String UpdateOrderFormJSP(int id,Model model){
        OrderForm UOF = userService.UpdateOrderFormJSP(id);
        UOF.setOrder_number(id);
        model.addAttribute("UOF",UOF);
        return "updateorderform";
    }

    @RequestMapping(value = "/UpdateOrderForm")
    public String UpdateOrderForm(OrderForm orderForm){
        userService.UpdateOrderForm(orderForm);
        return "list";
    }
    @RequestMapping(value = "/DelSelected")
    public String DelSelected(String[] uid){
       List list = Arrays.asList(uid);
        userService.DelSelected(list);
        return "list";

    }
    @RequestMapping(value = "/FindUserByPage")
    public String FindUserByPage(Integer currentPage,Integer rows,String username){
        PageBean PB = userService.FindUserByPage(currentPage,rows,username);
//        model.addAttribute("PB",PB);
        request.setAttribute("PB",PB);
        return "list";
    }

}
