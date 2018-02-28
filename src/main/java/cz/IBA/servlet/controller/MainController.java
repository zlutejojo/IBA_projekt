package cz.IBA.servlet.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *  výchozí webová stránka
 *  do parametru x, lze nastavit číslo určující, kolikrát se vypíše uvítací text
 *  pokud uživatel nezadá číslo, uvítací text se vypíše 1x
 */

@Controller
public class MainController {

//    ahoj

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, @RequestParam(value = "x", required = false) String xReq) {

        Integer x = 1;

        try {
            if (xReq != null) x = Integer.parseInt(xReq);
        } catch (NumberFormatException ex) {
            x = 1;
        }

        model.addAttribute("paramX", x);
        return "index";
    }


    @GetMapping("/model")
    public String passParametersWithModel(Model model) {
        Map<String, String> map = new HashMap<>();
        String jmeno = "Jana";
        map.put("spring", "mvc");
        model.addAttribute("jmeno", jmeno);
        model.addAttribute("prijmeni", "Nova");
        model.mergeAttributes(map);
        return "modelPage";
    }

    @GetMapping("/modelMap")
    public String passParametersWithModelMap(ModelMap map) {
        String prijmeni = "Kucerova";
        map.addAttribute("jmeno", "Marta");
        map.addAttribute("prijmeni", prijmeni);
        return "modelMapPage";
    }


    @GetMapping("/modelAndView")
    public ModelAndView passParametersWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("modelAndViewPage");
        modelAndView.addObject("jmeno", "Simona");
        modelAndView.addObject("prijmeni", "Kulichova");
        return modelAndView;
    }




}