package cz.IBA.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cz.IBA.servlet.entity.Student;

/**
 *  výchozí webová stránka: do parametru x, lze nastavit číslo určující,
 *  kolikrát se vypíše uvítací text, pokud uživatel nezadá číslo, uvítací text se vypíše 1x
 *
 *  web student: zobrazení formuláře a zpracování výsledku
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

//    zobrazení formuláře k vyplnění
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView displayStudent(){
        ModelAndView modelAndViewStudent = new ModelAndView("student");
        return modelAndViewStudent;
    }
//   zpracování vyplněného formuláře
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView displayStudentResult(Student completedForm) {

        ModelAndView modelAndViewStudentResult = new ModelAndView("studentResult");

        String name = completedForm.getName();
        String surname = completedForm.getSurname();
        String birthday = completedForm.getBirthday();
        String sex = completedForm.getSex();

        String formResult = "Vaše údaje byly uloženy do registru dlužníků: " + name + " " + surname + " " + birthday + " " +sex;
        modelAndViewStudentResult.addObject("formResult", formResult);

        return modelAndViewStudentResult;
    }
}