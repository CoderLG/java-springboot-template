package lg.controller.template;

import io.swagger.annotations.Api;
import lg.dto.req.ResultEntityVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有的返回 ResponseEntity
 *      都应该是状态码 加返回值
 */
@Slf4j
@Api(tags = "返回结果")
@Controller
public class ResultController {

    @GetMapping("getStr1")

    public ResponseEntity<String> getStr1(){
        return  ResponseEntity.ok("getStr1");
    }


    @GetMapping("getStr2")
    public String getStr2(){
        return "getStr2";
    }



    @GetMapping("getResponse")
    @ResponseBody
    public ResponseEntity getRes(){
        Map<String, Object> returnError = new HashMap();
        returnError.put("code", "200");
        returnError.put("message", "mess");
        log.info("info",returnError);
        log.warn("warn",returnError);
        log.error("error",returnError);
        return  new ResponseEntity(returnError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("getResponseEntity")
    @ResponseBody
    public ResponseEntity<ResultEntityVo> getResponseEntity(){
        ResultEntityVo result = new ResultEntityVo();
        result.setCode("200");
        result.setMessage("true");
        return  ResponseEntity.ok(result);
    }
}
