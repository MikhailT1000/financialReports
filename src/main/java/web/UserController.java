package web;

import DAO.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UsersDAO users;

    @Autowired
    public UserController(UsersDAO users) {
        this.users = users;
    }

    @GetMapping(path = "/add-user")
    public String addUserForm(ModelMap modelMap) {
            AddUserPageBean bean = new AddUserPageBean("", "", "", "", "");
        modelMap.addAttribute("bean", bean);
        return "add-user";
    }

    @PostMapping(path = "/add-user")
    @Transactional
    public String postAddUserForm(@RequestParam String typeUser,
                                  @RequestParam String firstName,
                                  @RequestParam String secondName,
                                  @RequestParam String login,
                                  ModelMap model) {
        if (typeUser == null) {
            return "add-user";
        }

        if (login == null || login.isEmpty()) {
            AddUserPageBean bean = new AddUserPageBean(typeUser, firstName, secondName, login, "Login empty");
            model.addAttribute("bean", bean);
            return "add-user";
        }

        if (users.createUser(typeUser, firstName, secondName, login) == null) {
            // TODO error message
            return "add-user";
        }

        return "redirect:/";
    }

    @PostMapping(path = "/delete-user")
    public String delete(@RequestParam long id) {
        users.delete(id);
        return "redirect:/";
    }
}