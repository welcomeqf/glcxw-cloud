package com.glcxw.base.business.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glcxw.base.business.TestBusiness;
import com.glcxw.base.domain.entity.TestEntity;
import com.glcxw.base.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.base.business.impl
 * @FileName:       TestBusinessImpl.java
 * @ClassName:      TestBusinessImpl
 * @Description:    ....实现类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/20 15:00
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/20 15:00
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestBusinessImpl extends ServiceImpl<TestMapper, TestEntity> implements TestBusiness {

   @Override
   public void insert() {
      System.out.println(baseMapper.insert(new TestEntity()));
   }
}
