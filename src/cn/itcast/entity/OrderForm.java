package cn.itcast.entity;

import java.io.Serializable;

/**
 * @author nior
 * @className OrderForm
 * @vison 1.0.0
 * @date 2020/2/26 0:21
 */
public class OrderForm implements Serializable {
    private int order_number;
    private String order_time;
    private String username;
    private int number;
    private String address;

    @Override
    public String toString() {
        return "OrderForm{" +
                "order_number=" + order_number +
                ", order_time='" + order_time + '\'' +
                ", username='" + username + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                '}';
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}