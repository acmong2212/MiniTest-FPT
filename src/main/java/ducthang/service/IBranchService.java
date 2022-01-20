package ducthang.service;

import ducthang.model.Branch;

import java.util.List;

public interface IBranchService {
    public List<Branch> findAllBranch();

    public Branch finById(long id);
}
