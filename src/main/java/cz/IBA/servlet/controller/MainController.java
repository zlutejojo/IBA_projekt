package cz.IBA.servlet.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cz.IBA.servlet.entity.Sex;
import cz.IBA.servlet.entity.Student;

/**
 * controller obsluhe dvě webové stránky: výchozí (index) a student
 * ve výchozí webové stránce lze nastavit paramter x, web student zobrazuje formulář
 *
 * @author Jana Čižiková
 */

@Controller
public class MainController {

    /**
     * parametr x určuje kolikrát se vypíše uvítací text,
     * pokud uživatel nezadá číslo, uvítací text se vypíše 1x
     * parametr x není povinný
     */
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

    /**
     * zobrazení formuláře s údaji k vyplnění
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView displayStudent(){
        ModelAndView modelAndViewStudent = new ModelAndView("student");

//        Student prazdnyFormular = new Student();
//        modelAndViewStudent.addObject("completedForm", prazdnyFormular);


        return modelAndViewStudent;
    }

    /**
     * zpracování formuláře
     * formulář obsahuje validace (viz třída Student), po zadaní nesprávných údajů,
     * se přezobrazí formulář: zobrazí se komentář chyb/y, vyplněná data zůstanou uložena
     * jestliže jsou pole vyplněna správně, zobrazí se uživateli stránka s výsledkem
     */
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView displayStudentResult(@Valid @ModelAttribute("completedForm") Student completedForm, Errors validationErrors) {

//        formátování tvaru Date (př. Tue Oct 10 00:00:00 CEST 2017) na tvar vyžadovaný formulářem (př. 10.10.2017)
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        String formatedBirthday;

        if(validationErrors.hasErrors()) {
            ModelAndView modelAndViewStudentError = new ModelAndView("student");
            String error = "Zadali jste nesprávné údaje, prosím opakujte.";
            modelAndViewStudentError.addObject("error", error);

//            pokud uživatel nevyplní pole datum narození, po přeozbrazení formuláře pole zůstane prázdné a nedojde k chybě
            try {
                formatedBirthday = formatter.format(completedForm.getBirthday());
            } catch (IllegalArgumentException ex) {
                formatedBirthday = "";
            }

            modelAndViewStudentError.addObject("formatedDate", formatedBirthday);
            return modelAndViewStudentError;
        }

        ModelAndView modelAndViewStudentResult = new ModelAndView("studentResult");

        String name = completedForm.getName();
        String surname = completedForm.getSurname();
        formatedBirthday = formatter.format(completedForm.getBirthday());
        Sex sex = completedForm.getSex();

        String formResult = "Vaše údaje byly uloženy do registru dlužníků: " + name + " " + surname + " " + formatedBirthday + " " +sex;
        modelAndViewStudentResult.addObject("formResult", formResult);

        return modelAndViewStudentResult;
    }
}