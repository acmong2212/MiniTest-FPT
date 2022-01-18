package ducthang.service;

import ducthang.model.Staff;

import java.util.List;

public interface IStaffService {
    public List<Staff> findAllStaff();
    public void save(Staff staff);
    public void delete(long id);
    public Staff findById(long id);
    public List<Staff> sort();
}
