package com.glcxw.avatar.constant;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.master.pay.constant
 * @FileName:       WxPayMessage.java
 * @ClassName:      WxPayMessage
 * @Description:    微信支付参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/6 14:57
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/6 14:57
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public interface WxPayMessage {

   /**
    *  APPId
    */
   String APP_ID = "appid";

   /**
    *  mchId
    */
   String MCH_ID = "mch_id";

   /**
    *
    */
   String TRADE_TYPE = "trade_type";

   /**
    *  微信回调地址
    */
   String NOTIFY_URL = "notify_url";

   /**
    *  ip地址
    */
   String IP = "spbill_create_ip";

   /**
    *  支付金额
    */
   String TOTAL_FEE = "total_fee";

   /**
    *  金币类型
    */
   String FEE_TYPE = "fee_type";

   /**
    *  订单号
    */
   String OUT_TRADE_NO = "out_trade_no";

   /**
    *  微信支付流水号
    */
   String TRANSACTION_ID = "transaction_id";

   /**
    *  微信退款单号
    */
   String REFUND_ID = "refund_id";

   /**
    *  订单描述
    */
   String BODY = "body";

   /**
    *  随机数
    */
   String NONCE_STR = "nonce_str";

   /**
    *  商户退款单号
    */
   String OUT_REFUND_NO = "out_refund_no";

   /**
    *  退款金额
    */
   String REFUND_FEE = "refund_fee";

   /**
    *   jsApi支付  openId
    */
   String OPEN_ID = "openid";

   /**
    *  签名
    */
   String SIGN = "sign";

   /**
    *  返回code
    */
   String RETURN_CODE = "return_code";

   /**
    *  退款返回状态
    */
   String RESULT_CODE = "result_code";

   /**
    *  退款回调加密字段
    */
   String REQ_INFO = "req_info";

   /**
    *  返回错误信息
    */
   String RETURN_MSG = "return_msg";

   /**
    *  错误信息
    */
   String ERR_CODE_DES = "err_code_des";

   /**
    *  操作失败
    */
   String FAIL = "FAIL";

   /**
    *  成功
    */
   String SUCCESS = "SUCCESS";

   /**
    *  关闭
    */
   String REFUND_CLOSE = "REFUNDCLOSE";

   /**
    * APP
    */
   String APP = "APP";

   /**
    *  localhost
    */
   String LOCALHOST = "127.0.0.1";

   /**
    *  预支付id
    */
   String PREPAY_ID = "prepay_id";

   /**
    *  拓展字段
    */
   String PACKAGES = "Sign=WXPay";

   /**
    *  返回签名
    */
   String RESULT_SIGN = "MD5";

   /**
    *  人民币
    */
   String CNY = "CNY";

   /**
    *  支付状态
    */
   String TRADE_STATE = "trade_state";

   /**
    *  支付完成时间
    */
   String TIME_END = "time_end";

   /**
    *  实际支付金额
    */
   String CASH_FEE = "cash_fee";

   /**
    *  退款渠道
    */
   String REFUND_CHANNEL = "refund_channel_";

   /**
    *  退款次数
    */
   String REFUND_COUNT = "refund_count";

   /**
    *  退款成功时间
    */
   String REFUND_SUCCESS_TIME = "refund_success_time_";

   /**
    *  退款状态
    */
   String REFUND_STATUS = "refund_status_";

   /**
    *  退款金额
    */
   String REFUND_FEE$ = "refund_fee_";

   /**
    *  退款入账账户
    */
   String REFUND_RECV_ACCOUNT = "refund_recv_accout_";

   /**
    *  回调退款状态
    */
   String CALL_REFUND_STATUS = "refund_status";

   /**
    *  资金退款至用户账号的时间，格式2017-12-15 09:46:01
    */
   String SUCCESS_TIME = "success_time";

   /**
    *  退款入账账户
    */
   String REFUND_ACCOUNT = "refund_recv_accout";

   /**
    *  退款金额
    */
   String SETTLEMENT_REFUND_FEE = "settlement_refund_fee";
}
