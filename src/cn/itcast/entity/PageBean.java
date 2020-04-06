package cn.itcast.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author nior
 * @className PageBean
 * @vison 1.0.0
 * @date 2020/3/6 19:45
 */

@Component
public class PageBean implements Serializable {
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private List list;//每页数据
    private int currentPage;//当前页面
    private int rows;//每页显示的记录

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
