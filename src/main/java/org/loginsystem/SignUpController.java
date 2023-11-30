package org.loginsystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private DatabaseHelper dbHelper;

    @RequestMapping("signup")
    public String displaySignUp(@NonNull Model theModel){
        Signup signup = new Signup();
//        theModel.addAttribute("signupData", new Signup());
        theModel.addAttribute("signupData", signup);
        return "signup";
    }

    @RequestMapping("processSignup")
    public String processSignup(@Valid @ModelAttribute("signupData")@NonNull Signup incomingData,
                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(incomingData.getPassword()+"\n"+incomingData.getConfirmPassword());
            return "signup";
        } else {
            SessionFactory factory = new Configuration().configure("hibernate.config.xml")
                    .addAnnotatedClass(DatabaseHelper.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            try{
                DatabaseHelper tempSignUp = new DatabaseHelper();
                tempSignUp.setEmail(incomingData.getEmail());
                tempSignUp.setPassword(incomingData.getPassword());

                session.beginTransaction();
                session.persist(tempSignUp);
                session.getTransaction().commit();

            }finally {
                factory.close();
            }

            return "index";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
