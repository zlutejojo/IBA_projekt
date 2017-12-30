package cz.IBA.servlet.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cz.IBA.servlet.entity.Sex;
import cz.IBA.servlet.entity.Student;
import cz.IBA.servlet.service.StudentServiceListImp;


/**
 * controller obsluhuje pět webových stránek(výchozí, /studentCreate, /studentDetail, /studentEdit, /studentList)
 * todo dodělat odkazy na všechny webové stránky
 *
 * @author Jana Čižiková
 */

@Controller
public class MainController {

    StudentServiceListImp studentService = new StudentServiceListImp();

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
     * zobrazení formuláře s údaji k vytvoření nového studenta
     */
    @RequestMapping(value = "/studentCreate", method = RequestMethod.GET)
    public ModelAndView displayStudent(){
        ModelAndView modelAndViewStudent = new ModelAndView("studentCreate");

        return modelAndViewStudent;
    }

    /**
     * zpracování formuláře pro studentCreate nebo studentEdit + přidání studenta do seznamu studentů nebo upravení údajů studenta
     * formulář obsahuje validace (viz třída Student),
     * po zadaní nesprávných údajů, se přezobrazí formulář: zobrazí se komentář chyb/y, vyplněná data zůstanou uložena
     * todo zachovat i původní data (při editaci studenta - zobrazit předvyplněné údaje
     * jestliže jsou pole vyplněna správně, zobrazí se uživateli stránka s výsledkem
     */

//    mapping pro studentCreate nebo studentEdit
    @RequestMapping(value = {"/{path:student(?:Create|Edit){1}}"}, method = RequestMethod.POST)
    public ModelAndView displayStudentResult(@RequestParam(value = "index", required = false) Integer index,
                                             @Valid @ModelAttribute("completedForm") Student completedForm,
                                             Errors validationErrors,
                                             @PathVariable String path) {

        String formattedBirthday = studentService.formatDate(completedForm.getBirthday());

        if(validationErrors.hasErrors()) {
            ModelAndView modelAndViewStudentError = new ModelAndView("studentCreate");
            String error = "Zadali jste nesprávné údaje, prosím opakujte.";
            modelAndViewStudentError.addObject("error", error);

            modelAndViewStudentError.addObject("formattedDate", formattedBirthday);
            return modelAndViewStudentError;
        }

//        z URl zjistím, zda je voláno studentCreate nebo studentEdit
        Pattern p = Pattern.compile("Create");
        Matcher m = p.matcher(path);
        if(m.find()) { //studentCreate
            //        přidání studenta do seznamu
//        todo ošetřit, aby se mi při resendu neuložil záznam 2x
            studentService.create(completedForm);
            System.out.println("completedForm" + completedForm.getName());
            List<Student> studentList = studentService.readAll();
            System.out.println("studentLst " + studentList.get(0).getName());

        } else {       //studentEdit
            studentService.update(index,completedForm);
        }


        ModelAndView modelAndViewStudentResult = new ModelAndView("studentResult");

        String name = completedForm.getName();
        String surname = completedForm.getSurname();
        Sex sex = completedForm.getSex();

        String formResult = "Vaše údaje byly uloženy do seznamu studentů: " + name + " " + surname + " " + formattedBirthday + " " +sex;
        modelAndViewStudentResult.addObject("formResult", formResult);

        return modelAndViewStudentResult;
    }

    /**
     * vypsání studentů (příjmení) ze seznamu
     * web obsahuje odkaz na otevření detailu studenta a editaci studenta
     */
    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public ModelAndView displayStudentList(){
        ModelAndView modelAndViewStudent = new ModelAndView("studentList");
        modelAndViewStudent.addObject("studentList", studentService.readAll());

        return modelAndViewStudent;
    }

    /**
     * vypsání detailu studenta, zformátování Date
     * vyžaduje parametr index (předpokládá, že v seznamu máme uloženého alespoň jednoho studenta)
     */
    @RequestMapping(value = "/studentDetail", method = RequestMethod.GET)
    public ModelAndView displayStudentDetail(@RequestParam(value = "index") int indexStudent){

        ModelAndView modelAndViewStudent = new ModelAndView("studentDetail");

        String formattedDate = studentService.formatDate(studentService.readAll().get(indexStudent).getBirthday());

        modelAndViewStudent.addObject("formattedDate", formattedDate);
        modelAndViewStudent.addObject("studentDetail", studentService.readAll().get(indexStudent));

        return modelAndViewStudent;
    }

    /**
     * zobrazí formulář s předvyplněnými údaji vybraného studenta
     * údaje lze editovat
     * vyžaduje parametr index (předpokládá, že v seznamu máme uloženého alespoň jednoho studenta)
     */
    @RequestMapping(value = "/studentEdit", method = RequestMethod.GET)
    public ModelAndView displayStudentEdit(@RequestParam(value = "index") int indexStudent){

        ModelAndView modelAndViewStudentEdit = displayStudent();

// todo odstranit duplicitu
        String formattedDate = studentService.formatDate(studentService.readAll().get(indexStudent).getBirthday());

        modelAndViewStudentEdit.addObject("formattedDate", formattedDate);
        modelAndViewStudentEdit.addObject("completedForm", studentService.readAll().get(indexStudent));

        return modelAndViewStudentEdit;
    }


    
}