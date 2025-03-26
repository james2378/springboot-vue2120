package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.CaikuaiDao;
import com.entity.CaikuaiEntity;
import com.service.CaikuaiService;
import com.entity.view.CaikuaiView;

/**
 * 财会审核人员 服务实现类
 */
@Service("caikuaiService")
@Transactional
public class CaikuaiServiceImpl extends ServiceImpl<CaikuaiDao, CaikuaiEntity> implements CaikuaiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CaikuaiView> page =new Query<CaikuaiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
