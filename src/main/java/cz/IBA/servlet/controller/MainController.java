package cz.IBA.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *  výchozí webová stránka
 *  do parametru x, lze nastavit číslo určující, kolikrát se vypíše uvítací text
 *  pokud uživatel nezadá číslo, uvítací text se vypíše 1x
 */

@Controller
public class MainController {

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
}