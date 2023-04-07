package com.mysite.jts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/jts")
    @ResponseBody
    public String index() {
        return "index";
    }


//  forward:<URL>   : 기존 요청값들이 유지된 상태로 URL이 전환된다.
//  redirect:<URL>  : URL로 리다이렉트 (완전히 새로운 URL로 요청이된다.)
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
