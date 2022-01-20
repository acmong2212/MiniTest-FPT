package ducthang.controller;

import ducthang.model.Branch;
import ducthang.model.Staff;
import ducthang.service.IBranchService;
import ducthang.service.IStaffService;
import ducthang.validate.Repeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    IStaffService staffService;

    @Autowired
    IBranchService branchService;

    @Autowired
    Repeat repeat;

    @GetMapping("")
    public ModelAndView showAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "nameStaff") String option) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffs", staffService.findAllStaff(PageRequest.of(page, 4, Sort.by(option))));
        modelAndView.addObject("option", option);
        return modelAndView;
    }

    @GetMapping("/staffInformation")
    public ModelAndView infoStaff(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("staffInformation");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("createStaff");
        return modelAndView;
    }

    @ModelAttribute("staff")
    public Staff staff(){
        return new Staff();
    }

    @ModelAttribute("branch")
    public List<Branch> branch(){
        return branchService.findAllBranch();
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(value = "staff") Staff staff, BindingResult bindingResult, @RequestParam long idBranch) {
        repeat.validate(staff, bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "createStaff";
        }

        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        staff.setBranch(branch);

        staffService.save(staff);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        staffService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/editStaff");
        modelAndView.addObject("staff", staffService.findById(id));
        modelAndView.addObject("branch", branchService.findAllBranch());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute(value = "staff") Staff staff, BindingResult bindingResult, @RequestParam long idBranch) {
        repeat.validate(staff, bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "editStaff";
        }

        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        staff.setBranch(branch);

        staffService.save(staff);
        return "redirect:/";
    }

//    @GetMapping("/sort")
//    public ModelAndView sort() {
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("staffs", staffService.sort());
//        return modelAndView;
//    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffs", staffService.findAllByName(findName));
        return modelAndView;
    }
}
