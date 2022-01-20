package ducthang.validate;

import ducthang.model.Staff;
import ducthang.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class Repeat implements Validator {
    @Autowired
    IStaffService staffService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Staff staff = (Staff) target;
        List<Staff> staffList = staffService.findAllStaff();
        for (Staff s : staffList) {
            if (s.getNameStaff().equals(staff.getNameStaff())) {
                errors.rejectValue("nameStaff", "", "Ten^ nay` da~ ton^` tai.");
                return;
            }

            if (s.getEmail().equals(staff.getEmail())) {
                errors.rejectValue("email", "", "Email nay` da~ ton^` tai.");
                return;
            }
        }
    }
}
