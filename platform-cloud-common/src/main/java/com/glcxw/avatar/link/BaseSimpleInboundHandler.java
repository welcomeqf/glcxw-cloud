package com.glcxw.avatar.link;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.pay.chain
 * @FileName:       SimpleBaseInboundHandler.java
 * @ClassName:      SimpleBaseInboundHandler
 * @Description:    handler链路传递
 * @Author:         wuqiangfu
 * @CreateDate:     2021/12/15 14:36
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/12/15 14:36
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public abstract class BaseSimpleInboundHandler {

   /**
    * wuqiangfu special annotation
    *
    * @param ctx  上下文对象
    * @param obj  传输数据对象
    * @return v
    * @Description:  读取每个handler数据进行处理
    * @throws Exception 异常
    */
   protected abstract void channelRead0 (ChannelHandlerContext ctx, Object obj) throws Exception;
}
