package org.harvestdiaryserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//响应码，1 代表成功; 0 代表失败
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据

    //增删改 成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    /**
     * 失败响应
     * @param msg
     * @return
     * error1：用户账号已存在
     * error2：电话已被注册
     * error3：用户名密码错误
     * error4：昵称或2电话号码错误
     * error5：添加日记失败
     */
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
