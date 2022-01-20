package ducthang.service;

import ducthang.model.Staff;
import ducthang.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StaffService implements IStaffService{
    @Autowired
    StaffRepo staffRepo;

    @Override
    public Page<Staff> findAllStaff(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }

    @Override
    public List<Staff> findAllStaff() {
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public List<Staff> findAllByName(String name) {
        return staffRepo.findAllByName(name);
    }

    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(long id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Staff findById(long id) {
        return staffRepo.findById(id).get();
    }

//    @Override
//    public List<Staff> sort() {
//        List<Staff> staffList = findAllStaff();
//        staffList.sort(Comparator.comparing(Staff::getAgeStaff));
//        return staffList;
//    }
}
