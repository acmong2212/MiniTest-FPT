package ducthang.controller;

import ducthang.model.Branch;
import ducthang.model.Staff;
import ducthang.service.IBranchService;
import ducthang.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {
    @Autowired
    IStaffService staffService;

    @Autowired
    IBranchService branchService;

    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffs", staffService.findAllStaff());
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
        modelAndView.addObject("staff", new Staff());
        modelAndView.addObject("branch", branchService.findAllBranch());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "staff") Staff staff, @RequestParam long idBranch) {
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
    public String edit(@ModelAttribute(value = "staff") Staff staff, @RequestParam long idBranch) {
        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        staff.setBranch(branch);

        staffService.save(staff);
        return "redirect:/";
    }

    @GetMapping("/sort")
    public ModelAndView sort() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffs", staffService.sort());
        return modelAndView;
    }
}
