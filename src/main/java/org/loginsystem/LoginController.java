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
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String displayLogin(@NonNull Model theModel){
        Login login = new Login();
        theModel.addAttribute("loginData", login);
        return "login";
    }

    @RequestMapping("processLogin")
    public String processLogin(@Valid @ModelAttribute("loginData")@NonNull Login incomingData,
                               BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "login";
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
                List<DatabaseHelper> tempQueryResult = session.createQuery("from DatabaseHelper dbh where dbh.email="+"'"+tempSignUp.getEmail()+"'"+" AND dbh.password="+"'"+tempSignUp.getPassword()+"'").getResultList();

                session.getTransaction().commit();

                if (tempQueryResult.isEmpty()){
                    return "login";
                } else {
                    return "index";
                }

            }finally {
                factory.close();
            }
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
