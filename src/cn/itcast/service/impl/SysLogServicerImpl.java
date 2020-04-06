package cn.itcast.service.impl;

import cn.itcast.dao.ISysLogDao;
import cn.itcast.entity.SysLog;
import cn.itcast.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nior
 * @className SysLogServicerImpl
 * @vison 1.0.0
 * @date 2020/3/16 16:45
 */

@Service("ISysLogService")
public class SysLogServicerImpl implements ISysLogService {
    @Autowired
    private ISysLogDao iSysLogDao;
    @Override
    public void save(SysLog sysLog) {
        iSysLogDao.save(sysLog);
    }
}
