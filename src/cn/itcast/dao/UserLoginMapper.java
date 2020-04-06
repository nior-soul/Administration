package cn.itcast.dao;

import cn.itcast.entity.OrderForm;
import cn.itcast.entity.User;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * @author nior
 * @className UserLoginMapper
 * @vison 1.0.0
 * @date 2020/2/22 22:20
 */

public interface UserLoginMapper {
     /**
      * 登录验证
      * @param email
      * @param password
      * @return
      */
     User UserLogin(String email,String password);

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
     * 查询总记录数或搜索总记录数
     * @return
     * @param username
     */
    int FindTotalCount(String username);

    /**
     * 分页查询或搜索分页查询
     * @param start
     * @param rows
     * @param username
     * @return
     */
    List<OrderForm> FindByPage(int start, int rows,@Param("username")String username);

}
