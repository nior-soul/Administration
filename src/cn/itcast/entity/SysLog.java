package cn.itcast.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author nior
 * @className sysLog
 * @vison 1.0.0
 * @date 2020/3/16 12:09
 */
public class SysLog implements Serializable {
    private String id;
    private Date visitTime;//访问时间
    private String username;//操作者用户名
    private String ip;//访问IP
    private String url;//访问路径
    private Long executionTime;//执行时长
    private String method;//执行方法

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", visitTime=" + visitTime +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
