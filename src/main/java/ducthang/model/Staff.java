package ducthang.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idStaff;

    @Pattern(regexp = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n" +
            "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n" +
            "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$", message = "Ho va ten khong bao gom` so va ki tu dac biet")
    private String nameStaff;

    @Min(value = 18, message = "Cong ty khong^ nhan tre vi thanh` nien^")
    @Max(value = 60, message = "Chu den tuoi nghi huu di lam` nua~ chi chu")
    private int ageStaff;

    @Email
    private String email;

    private String salary;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(String nameStaff, int ageStaff, String email, String salary, Branch branch) {
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.email = email;
        this.salary = salary;
        this.branch = branch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
