package com.glcxw.avatar.security.context;

public interface SecurityContextHolderStrategy {

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  移除上下文对象
     */
    void clearContext();

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  得到上下文对象
     */
    SecurityContext getContext();

    /**
     * wuqiangfu special annotation
     *
     * @param  var1  需要保存的对象
     * @return v
     * @Description:  保存上下文对象
     */
    void setContext(SecurityContext var1);

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  得到保存token信息的对象
     */
    SecurityContext createEmptyContext();

}