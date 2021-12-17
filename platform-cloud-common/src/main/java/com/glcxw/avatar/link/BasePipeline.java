package com.glcxw.avatar.link;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.pay.chain
 * @FileName:       Pipeline.java
 * @ClassName:      Pipeline
 * @Description:    构造链路通道
 * @Author:         wuqiangfu
 * @CreateDate:     2021/12/15 16:37
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/12/15 16:37
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public abstract class BasePipeline {

   private ChannelHandlerContext context;

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  构建头节点
    */
   public BasePipeline () {
      context = new ChannelHandlerContext(new BaseSimpleInboundHandler() {
         @Override
         protected void channelRead0(ChannelHandlerContext ctx, Object var2) throws Exception {
            ctx.findNextContext(var2);
         }
      });
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  执行开始
    */
   public void execute (Object t) throws Exception {
      this.context.handler(t);
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  将handler添加到尾部
    */
   public void addLast (BaseSimpleInboundHandler handler) {
      ChannelHandlerContext handlerContext = this.context;
      while (handlerContext.next != null) {
         handlerContext = handlerContext.next;
      }
      handlerContext.next = new ChannelHandlerContext(handler);
   }
}
