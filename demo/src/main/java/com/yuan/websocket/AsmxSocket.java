package com.yuan.websocket;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

public class AsmxSocket {

    public static void main(String[] args) {
        Service service = new Service();
        String url = "http://47.102.138.10:8888/cc/AICThird.asmx";  //URL地址
        String namespace = "http://www.sdp.com.cn/schema/sag/sms/notification/v2_1/local";
        String actionUri = "QuerySocketMessage"; //Action路径
        String op = "QuerySocketMessage"; //要调用的方法名
        Call call = null;
        try {
            call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(namespace + actionUri); // action uri
            call.setOperationName(new QName(namespace, op));// 设置要调用哪个方法
// 设置参数名称，具体参照从浏览器中看到的
            call.addParameter(new QName(namespace, "StartID"), XMLType.XSD_STRING, ParameterMode.IN);  //设置请求参数及类型
            call.addParameter(new QName(namespace, "EndID"), XMLType.XSD_STRING, ParameterMode.IN);  //设置请求参数及类型
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置结果返回类型
            Object[] params = new Object[]{"1","2"};
            Object result =  call.invoke(params); //方法执行后的返回值
            System.out.println("==================" + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
