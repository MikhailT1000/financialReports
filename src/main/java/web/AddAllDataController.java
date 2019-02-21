package web;

import DAO.AllDataDAO;
import DAO.UsersDAO;

import entity.Operator;
import entity.User;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.PassportVerificationService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AddAllDataController {
    @Autowired
    private UsersDAO users;

    @Autowired
    private AllDataDAO allData;

    @Autowired
    private List<PassportVerificationService> allVerificationServices;

    @Autowired
    @Qualifier("staff")
    private PassportVerificationService staffVerificationService;

    @GetMapping(path = "/add-allData")
//    = @RequestMapping(method = RequestMethod.GET, path = "/add-allData")
    public String addAllDataForm(@ModelAttribute(name = "allData") AddAllDataFormBean form) {
        return "add-allData";
    }

    @PostMapping(path = "/add-allData")
    @Transactional
    public String postForm(
            @Valid @ModelAttribute(name = "allData") AddAllDataFormBean form,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "add-allData";
        }

        boolean verified = false;

        for (PassportVerificationService service : allVerificationServices) {
            if (service.isValid(form.getName(), form.getPassportNumber())) {
                verified = true;
                break;
            }
        }

        if (!verified) {
            bindingResult.addError(new FieldError("allData", "name",
                    "Паспортные данные неверны."));
            return "add-allData";
        }

        Operator operator = null;

        for (User user : users.listUsers()) {
            if (user instanceof Operator) {
                operator = (Operator) user;
            }
        }

        if (operator == null) {
            bindingResult.addError(new ObjectError("allData", "Нет оператора."));
            return "add-allData";
        }

//        try {
//            AllData created = allData.createAllData(operator,
//                    form.getPurchaseDate(),
//                    form.getSaleDate(),
//                    form.getBrand(),
//                    form.getModel(),
//                    form.getPurchasePrice(),
//                    form.getSalePrice(),
//                    form.getDiscount(),
//                    form.getCostPrice(),
//                    form.getType(),
//                    form.getQuantity());
//
////            created.setTitle(form.getTitle());
//        } catch (Throwable t) {
//            if (isConstraintViolation(t)) {
//                bindingResult.addError(new FieldError("allData", "cadNumber",
//                        "Объект с таким кадастровым номером уже существует."));
//            } else {
//                bindingResult.addError(new ObjectError("allData",
//                        "Не удалось создать данные: " + t.getMessage() + "."));
//            }
//
//            return "add-allData";
//        }

        return "redirect:/";
    }

    private boolean isConstraintViolation(Throwable error) {
        if (error instanceof ConstraintViolationException) return true;
        if (error.getCause() == error) return false;
        return isConstraintViolation(error.getCause());
    }
}