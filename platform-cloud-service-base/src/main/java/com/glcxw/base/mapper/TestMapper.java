package com.glcxw.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glcxw.base.domain.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.base.mapper
 * @FileName:       TestMapper.java
 * @ClassName:      TestMapper
 * @Description:    测试mapper
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 9:39
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 9:39
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Mapper
@Component
public interface TestMapper extends BaseMapper<TestEntity> {


}
