package ducthang.model;

import javax.persistence.*;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idStaff;
    private String nameStaff;
    private int ageStaff;
    private String salary;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(String nameStaff, int ageStaff, String salary, Branch branch) {
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.salary = salary;
        this.branch = branch;
    }

    public Long getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Long idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(int ageStaff) {
        this.ageStaff = ageStaff;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
