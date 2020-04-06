package cn.itcast.service;


import cn.itcast.entity.OrderForm;
import cn.itcast.entity.PageBean;
import cn.itcast.entity.User;

import java.util.List;

/**
 *
 * @author nior
 * @className UserService
 * @vison 1.0.0
 * @date 2020/2/6 18:27
 */
public interface UserService {
    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    User login(String email, String password);

    /**
     * 手动添加订单
     */
   void AddOrderForm(OrderForm orderForm);
    /**
     * 取消订单
     */
    void DelOrderForm(int id);

    /**
     * 修改订单显示页面
     * @param id
     * @return
     */
    OrderForm UpdateOrderFormJSP(int id);

    /**
     * 修改订单内容
     * @param orderForm
     */
    void UpdateOrderForm(OrderForm orderForm);

    /**
     * 批量删除
     * @param uid
     */
    void DelSelected(List uid);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @param username
     * @return
     */
    PageBean FindUserByPage(int currentPage, int rows,String username);


}
