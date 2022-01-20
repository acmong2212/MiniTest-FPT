package ducthang.service;

import ducthang.model.Branch;
import ducthang.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService{
    @Autowired
    BranchRepo branchRepo;

    @Override
    public List<Branch> findAllBranch() {
        return (List<Branch>) branchRepo.findAll();
    }

    @Override
    public Branch finById(long id) {
        return branchRepo.findById(id).get();
    }
}
