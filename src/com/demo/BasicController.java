package com.demo;


import com.spring.*;

import java.util.List;
import java.util.Map;

@Controller
public class BasicController {

    private final MovieService service;

    public BasicController(MovieService service) {
        this.service = service;
    }

    public BasicController() {
        this.service = new MovieServiceImpl(); // MovieServiceImpl 객체를 생성하여 할당
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
    public String list(Map<String, String> param, Map<String, Object> model) {
        List<MovieDto> base = service.select();
        for(int i = 0; i < base.size(); i++) {
            model.put("idx" + i, base.get(i).getIdx());
            model.put("title" + i,base.get(i).getTeam());
            model.put("image" + i, base.get(i).getImage());
            model.put("member",base.get(i).getMember());
            model.put("bottom", base.get(i).getBottom());
        }
        return  "list";
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
        model.put("slogan", base.getSlogan());
        model.put("member",base.getMember());
        model.put("bottom", base.getBottom());
        return  "read";
    }

    @RequestMapping("/insertForm")
    public  String insertForm() {
        return "insertForm";
    }

    @RequestMapping("/insert")
    public  String insert(MovieDto base) {
        service.insert(base);
        return "redirect:/list";
    }


    @RequestMapping("/updateForm/{idx}")
    public String updateForm(@PathVariable int idx, Map<String, Object> model) {
        model.put("base", service.read(idx));
        return "updateForm";
    }


    @RequestMapping("/update")
    public  String update(MovieDto base) {

        service.update(base);
        return "redirect:/list";
    }

    @RequestMapping("/delete/{idx}")
    public  String delete(@PathVariable int idx) {
        service.delete(idx);
        return "redirect:/list";
    }

}
