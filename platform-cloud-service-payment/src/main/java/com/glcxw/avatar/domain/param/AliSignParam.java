package com.glcxw.avatar.domain.param;

import com.alipay.api.domain.AccessParams;
import com.alipay.api.domain.AlipayUserAgreementPageSignModel;
import com.alipay.api.request.AlipayUserAgreementPageSignRequest;
import com.glcxw.avatar.common.domain.BaseParam;
import com.glcxw.avatar.common.enums.pay.AliSignEnums;
import com.glcxw.avatar.constant.AliPayMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.domain.param
 * @FileName:       AliSignParam.java
 * @ClassName:      AliSignParam
 * @Description:    支付宝签约参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/27 14:01
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/27 14:01
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class AliSignParam extends BaseParam {

   /**
    *  业务类型
    */
   @NotNull(message = "业务类型不能为空")
   private Integer businessType;

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  得到支付宝签约请求参数
    */
   public AlipayUserAgreementPageSignRequest aliParamInit (String extAgreementNo, String notifyUrl) {
      AlipayUserAgreementPageSignModel bizModel = new AlipayUserAgreementPageSignModel();
      bizModel.setPersonalProductCode(AliSignEnums.getValue(this.businessType));
      bizModel.setSignScene(AliPayMessage.SIGN_SCENE);
      bizModel.setExternalAgreementNo(extAgreementNo);
      AccessParams accessParams = new AccessParams();
      accessParams.setChannel(AliPayMessage.CHANNEL);
      bizModel.setAccessParams(accessParams);
      AlipayUserAgreementPageSignRequest request = new AlipayUserAgreementPageSignRequest();
      request.setBizModel(bizModel);
      request.setNotifyUrl(notifyUrl);
      return request;
   }
}
