package com.glcxw.base.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.base.domain.entity
 * @FileName:       AppSettingsEntity.java
 * @ClassName:      AppSettingsEntity
 * @Description:    APP设置表
 * @Author:         wuqiangfu
 * @CreateDate:     2021/3/15 17:28
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/3/15 17:28
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
@TableName("t_gl_test")
public class TestEntity extends Model<TestEntity> {

   @TableId(type = IdType.NONE)
   private Long orderNo;

   private String number;

   private String testName;

   private Integer testStatus;

   public TestEntity () {
//      this.orderNo = "522";
      this.number = UUID.randomUUID().toString();
      this.testName = "1234567";
      this.testStatus = 0;
   }


}
