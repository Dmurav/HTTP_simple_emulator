package com.emulator.http_server.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
/*
Класс обрабатывает поступающие POST и GET запросы по url: "/"
 */
public class DataController {

    // Контроллер для отображения результата вычислений
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String dataForm(Model model) {
        model.addAttribute("data", new Data());
        return "startpage";
    }

    // Конроллер для получения данных из формы
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String dataSubmit(@ModelAttribute Data data, Model model) {
        model.addAttribute("startpage", data);
        return "result";
    }

}