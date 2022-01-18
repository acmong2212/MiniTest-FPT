package ducthang.service;

import ducthang.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStaffService {
    public Page<Staff> findAllStaff(Pageable pageable);
    public List<Staff> findAllByName(String name);
    public void save(Staff staff);
    public void delete(long id);
    public Staff findById(long id);
//    public List<Staff> sort();
}
