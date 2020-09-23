package com.luis.essaydemo.factory;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/9/7  20:00
 * desc   : 简单工厂
 */
public class MaskFactory {

    public Mask creatMask(String type){
        Mask mask = null;
        if ("高端口罩".equals(type)) {
            mask = new HighMask();
        }else if("低端口罩".equals(type)){
            mask = new LowMask();
        }
        return mask;
    }

}
