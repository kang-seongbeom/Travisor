package kr.ac.jejunu.opensource.travisor.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.opensource.travisor.dto.Dto;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    @ResponseBody
    @PostMapping("/test")
    public HashMap<String,Object> test(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        JSONObject obj = new JSONObject();

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = mapper.writeValueAsString(params);
//        System.out.println(jsonInString);
//        HashMap<String,Object> userRequest =  (HashMap<String,Object>)params.get("userRequest");
//        String utter = userRequest.get("utterance").toString().replace("\n","");
//        System.out.println(utter);
//        obj.put("key",utter);
        //System.out.println(obj.get("action"));

//        System.out.println(jsonObject.toString());
        HashMap<String, Object> resultJson = new HashMap<>();
        HashMap<String,Object> userRequest =  (HashMap<String,Object>)params.get("userRequest");
        String utter = userRequest.get("utterance").toString().replace("\n","");

        String rtnStr = "";
        switch (utter){
            case "뭐야" : rtnStr = "코딩32 챗봇입니다.";
                break;
            case "ㅋㅋ" : rtnStr = "저도 기분이 좋네요";
                break;
            default: rtnStr = "안녕하세요 코딩 32 챗봇입니다.";
        }
        /* 발화 처리 끝*/

        List<HashMap<String,Object>> outputs = new ArrayList<>();
        HashMap<String,Object> template = new HashMap<>();
        HashMap<String, Object> simpleText = new HashMap<>();
        HashMap<String, Object> text = new HashMap<>();

        text.put("text",rtnStr);
        simpleText.put("simpleText",text);
        outputs.add(simpleText);

        template.put("outputs",outputs);

        resultJson.put("version","2.0");
        resultJson.put("template",template);
        return resultJson;
    }
}
