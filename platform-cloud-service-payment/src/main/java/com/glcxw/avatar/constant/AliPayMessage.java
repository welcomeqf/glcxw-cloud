package com.glcxw.avatar.constant;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.master.pay.constant
 * @FileName:       AliPayMessage.java
 * @ClassName:      AliPayMessage
 * @Description:    支付宝支付类型列举
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/13 14:46
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/13 14:46
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public interface AliPayMessage {

   /**
    *  过期时间
    */
   String EXP_TIME = "30m";

   /**
    *  ---
    */
   String QUICK_PAY = "QUICK_MSECURITY_PAY";

   /**
    *  交易单号
    */
   String TRADE_NO = "trade_no";

   /**
    *  回调支付时间
    */
   String GMT_PAYMENT = "gmt_payment";

   /**
    *  回调支付金额
    */
   String BUYER_PAY_AMOUNT = "buyer_pay_amount";

   /**
    *  订单总金额, 支付金额
    */
   String TOTAL_MONEY = "total_amount";

   /**
    *  商户订单号
    */
   String OUT_TRADE_NO = "out_trade_no";

   /**
    *  交易状态
    */
   String TRADE_STATUS = "trade_status";

   /**
    *  交易成功
    */
   String TRADE_SUCCESS = "TRADE_SUCCESS";

   /**
    *  退款金额
    */
   String REFUND_AMOUNT = "refund_amount";

   /**
    *  退款理由
    */
   String REFUND_REASON = "refund_reason";

   /**
    *  请求号
    */
   String OUT_REQUEST_NO = "out_request_no";

   /**
    *  json
    */
   String JSON = "json";

   /**
    *  UTF-8
    */
   String UTF8 = "UTF-8";

   /**
    *  加密方式
    */
   String RSA2 = "RSA2";

   /**
    *  success
    */
   String SUCCESS = "success";

   /**
    *  失败
    */
   String FAILURE = "failure";

   /**
    *  协议签约场景
    */
   String SIGN_SCENE = "INDUSTRY|MULTIMEDIA";

   /**
    *  接入渠道，一般即支付宝钱包ALIPAYAPP
    */
   String CHANNEL = "ALIPAYAPP";
}
