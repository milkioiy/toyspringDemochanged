package com.demo;


import com.spring.*;

import java.util.Map;


@Controller
public class BasicController {
 
    private final MovieService service;

    public BasicController() {
        this.service = null;
    }

    public BasicController(MovieService service) {
        this.service = service;
    }


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/count")
    @ResponseBody
    public String count(Map<String, String> param) {
        return "count=" + service.count();
    }

    @RequestMapping("/list")
    public String list(Map<String, Object> model, Map<String, String> param) {
        model.put("base", service.select());
        return "list.html";
    }

    @RequestMapping("/read/{idx}")
    public String read(@PathVariable int idx, Map<String, Object> model) {
        model.put("base", service.read(idx));
        return "read.html";
    }

    @RequestMapping("/read")
    public String read(Map<String, String> param, Map<String, Object> model) {
        int idx = Integer.parseInt(param.get("idx"));

        MovieDto base = service.read(idx);

        model.put("idx", base.getIdx());
        model.put("team", base.getTeam());
        model.put("image", base.getImage());
        model.put("member", base.getMember());
        model.put("slogan", base.getSlogan());

        return "read";
    }

}
