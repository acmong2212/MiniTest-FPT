package ducthang.repository;

import ducthang.model.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface StaffRepo extends PagingAndSortingRepository<Staff, Long> {
    //Search
    @Query(value = "select s from Staff s where s.nameStaff like concat('%',:name,'%')")
    ArrayList<Staff> findAllByName(@Param("name") String name);

}
