package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; //templates 폴더에 있는 파일명 hello를 찾아서 실행시켜라. model이라는걸 hello에 넘기면서.
    }

    @GetMapping("/hello-mvc")
    //RequestParam에서 required를 false로 하면 꼭 파라미터를 넘기지 않아도됨. default 값은 true이므로 false로 설정하지않으면 파라미터를 꼭 넣어야함
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }

}
