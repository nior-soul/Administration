package cn.itcast.service.impl;

import cn.itcast.dao.UserLoginMapper;
import cn.itcast.entity.OrderForm;
import cn.itcast.entity.PageBean;
import cn.itcast.entity.User;
import cn.itcast.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author nior
 * @className UserServiceImpl
 * @vison 1.0.0
 * @date 2020/2/6 18:31
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private PageBean pageBean;

    @Override
    public User login(String email, String password) {
        return userLoginMapper.UserLogin(email,password);
    }

    @Override
    public void AddOrderForm(OrderForm orderForm) {
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
        orderForm.setOrder_time(SDF.format(new Date()));
        userLoginMapper.AddOrderForm(orderForm);
    }

    @Override
    public void DelOrderForm(int id) {
        userLoginMapper.DelOrderForm(id);
    }

    @Override
    public OrderForm UpdateOrderFormJSP(int id) {
       return userLoginMapper.UpdateOrderFormJSP(id);
    }

    @Override
    public void UpdateOrderForm(OrderForm orderForm) {
        userLoginMapper.UpdateOrderForm(orderForm);
    }

    @Override
    public void DelSelected(List uid) {
        userLoginMapper.DelSelected(uid);
    }

    @Override
    public PageBean FindUserByPage(int currentPage, int rows,String username) {
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //查询总记录数
        int totalCount = userLoginMapper.FindTotalCount(username);
        pageBean.setTotalCount(totalCount);
        //计算开始索引
        int start = (currentPage - 1) * rows;
        List list = userLoginMapper.FindByPage(start,rows,username);
        pageBean.setList(list);
        //计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }


}
