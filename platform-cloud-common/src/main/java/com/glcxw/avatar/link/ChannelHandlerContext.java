package com.glcxw.avatar.link;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.pay.chain
 * @FileName:       ChannelHandlerContext.java
 * @ClassName:      ChannelHandlerContext
 * @Description:    上下文对象处理器
 * @Author:         wuqiangfu
 * @CreateDate:     2021/12/15 14:38
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/12/15 14:38
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class ChannelHandlerContext {

   /**
    *  下一个节点
    */
   ChannelHandlerContext next;

   private BaseSimpleInboundHandler handler;

   ChannelHandlerContext(BaseSimpleInboundHandler handler) {
      this.handler = handler;
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  执行当前节点
    */
   public void handler (Object t) throws Exception {
      this.handler.channelRead0(this, t);
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  继续下一个节点
    */
   public void findNextContext (Object t) throws Exception {
      if (next != null) {
         this.next.handler(t);
      }
   }
}
