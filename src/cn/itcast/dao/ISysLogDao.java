package cn.itcast.dao;

import cn.itcast.entity.SysLog;
import org.apache.ibatis.annotations.Insert;

/**
 * @author nior
 * @className ISysLogDao
 * @vison 1.0.0
 * @date 2020/3/16 16:47
 */
public interface ISysLogDao {
    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values (#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog);
}
