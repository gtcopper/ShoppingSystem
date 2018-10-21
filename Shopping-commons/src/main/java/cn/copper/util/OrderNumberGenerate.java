package cn.copper.util;

import java.util.Date;
import java.util.UUID;

/**
 * 生成唯一订单号
 * @author haojie
 * @date 2018/10/17
 */
public class OrderNumberGenerate {
    public static String generateOrderNuber(){
        String orderNumber;
        //生成唯一订单号
        orderNumber = System.currentTimeMillis()+ UUID.randomUUID().toString().hashCode()+"";
        return orderNumber;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(OrderNumberGenerate.generateOrderNuber());
        }
    }
}
