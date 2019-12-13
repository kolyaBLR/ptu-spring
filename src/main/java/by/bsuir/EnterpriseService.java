package by.bsuir;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.enterprise.Enterprise;
import by.bsuir.db.enterprise.EnterpriseDAO;
import by.bsuir.db.taggeditem.TaggedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnterpriseService {
    @Autowired
    private EnterpriseDAO enterpriseDAO;

    public List<Enterprise> getAll()
    {
        return enterpriseDAO.readAll(Enterprise.class);
    }

    public List<Enterprise> getAllFor(BaseUser baseUser)
    {
        return enterpriseDAO.getAllFor(baseUser);
    }

    public Enterprise getEnterprise(String regId)
    {
        return enterpriseDAO.read(regId, Enterprise.class);
    }

    public void createEnterprise(Enterprise enterprise, BaseUser baseUser)
    {
        enterprise.setOwner(baseUser);
        enterprise.setTaggedItem(new TaggedItem());
        enterpriseDAO.create(enterprise);
    }

    public List<Enterprise> getAllNotApproved()
    {
        return enterpriseDAO.getAllNotApproved();
    }

    public void updateEnterprise(Enterprise enterprise)
    {
        enterpriseDAO.update(enterprise);
    }

    public void deleteEnterprise(Enterprise enterprise)
    {
        enterpriseDAO.delete(enterprise.getRegistrationId(), Enterprise.class);
    }
}
