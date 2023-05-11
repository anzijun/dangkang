package com.dangkang.examplecontext.client.dto.response;

/**
 *
 * ApplicationServiceResult是ddd定义的dto，用于applicationService处理结果的返回值给ApplicationServiceController(ddd定义的adapter)
 * @date 2022/12/18 17:36
 */
public class ExampleServiceResultDTO {

    //todo 定义返回属性
    private String Data;

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
