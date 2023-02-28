package org.youe.mytry;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class TryTest {
    
    @Test
    public void testFieldsJSONArray() {
        // List<String> fieldsList = Arrays.asList("{\"type\":\"\",\"level\":\"\",\"accountNo\":\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}","{}");
        // List<String> fieldsList = new ArrayList<>(); // []
        // List<String> fieldsList = Collections.EMPTY_LIST;// []
        // List<String> fieldsList = null; // Cannot invoke "com.alibaba.fastjson.JSONArray.stream()" because "fieldsJSONArray" is null
        List<String> fieldsList = Arrays.asList("{\"type\":\"\",\"level\":\"\",\"accountNo\":\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}",null);// Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.alibaba.fastjson.JSONObject.get(Object)" because the return value of "com.alibaba.fastjson.JSON.parseObject(String)" is null
        // List<String> fieldsList = Arrays.asList("{\"type\":\"\",\"level\":\"\",null:\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}");//[] 
        // List<String> fieldsList = Arrays.asList("");//  java.lang.NullPointerException

        //JSONArray fieldsJSONArray = JSONArray.parseArray(JSON.toJSONString(fieldsList));
        //List<String> bankAccountNoList = fieldsJSONArray.stream().filter(b -> JSON.parseObject((String)b).get("accountNo") != null).map(b -> JSON.parseObject((String)b).getString("accountNo")).collect(Collectors.toList());
        //System.out.println(JSON.toJSONString(bankAccountNoList)); 
        
        
    }

    @Test
    public void testFieldsJSONArrayFix() {
        // List<String> fieldsList = Arrays.asList("{\"type\":\"\",\"level\":\"\",\"accountNo\":\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}","{}");
        // List<String> fieldsList = new ArrayList<>(); // []
        // List<String> fieldsList = Collections.EMPTY_LIST;// []
        // List<String> fieldsList = null; // Cannot invoke "com.alibaba.fastjson.JSONArray.stream()" because "fieldsJSONArray" is null
        // List<String> fieldsList = Arrays.asList("{\"type\":\"\",\"level\":\"\",\"accountNo\":\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}",null);// Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.alibaba.fastjson.JSONObject.get(Object)" because the return value of "com.alibaba.fastjson.JSON.parseObject(String)" is null
        // List<String> fieldsList = Arrays.asList("{\"type\":\"\",\"level\":\"\",null:\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}");//[] 
        // List<String> fieldsList = Arrays.asList("");//  java.lang.NullPointerException
        List<String> fieldsList = Arrays.asList("dd",null,"{\"type\":\"\",\"level\":\"\",\"accountNo\":\"Suning\",\"chainName\":\"\",\"customerBusinessType\":\"\"}","{\"type\":\"\",\"level\":\"\",\"accountNo\":null,\"chainName\":\"\",\"customerBusinessType\":\"\"}");
        System.out.println(JSON.toJSONString(null));
        JSONArray fieldsJSONArray = JSONArray.parseArray(JSON.toJSONString(fieldsList));
        if(null != fieldsJSONArray){
            List<String> bankAccountNoList = fieldsJSONArray.stream().filter(b -> !CommonUtil.isEmpty(CommonUtil.getJsonString(b, "accountNo"))).map(b -> CommonUtil.getJsonString(b, "accountNo")).collect(Collectors.toList());
            System.out.println(JSON.toJSONString(bankAccountNoList));
            //Assert.assertThat(bankAccountNoList).hasSize(1); 
        }
        System.out.println("end");    
    }


}
