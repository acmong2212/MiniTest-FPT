package ducthang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idBranch;
    private String nameBranch;

    public Branch() {
    }

    public Branch(Long idBranch, String nameBranch) {
        this.idBranch = idBranch;
        this.nameBranch = nameBranch;
    }

    public Long getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Long idBranch) {
        this.idBranch = idBranch;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }
}
