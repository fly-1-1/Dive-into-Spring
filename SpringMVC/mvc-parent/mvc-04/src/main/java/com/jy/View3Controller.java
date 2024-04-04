package com.jy;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/view3")
@SessionAttributes(value={"name","address"})
public class View3Controller {

    @RequestMapping("/view1")
    public String view1(Model model) {
        model.addAttribute("age", 10);
        model.addAttribute("name", "xiaojr");
        return "result2";
    }

    @RequestMapping("/view2")
    public String view2(SessionStatus sessionStatus) {
        if (!sessionStatus.isComplete()){
            sessionStatus.setComplete();
        }
        return "result2";
    }
}
