package com.teddy.service;

import com.teddy.dao.SponsorDao;
import com.teddy.entity.Sponsor;
import com.teddy.vo.SponsorVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SponsorService {
    @Autowired
    SponsorDao sponsorDao;

    public boolean checkPassword(String email, String password) {
        assert email != null;
        Sponsor sponsor = sponsorDao.findByEmail(email);
        if (sponsor == null) {
            return false;
        }
        return sponsor.getPassword().equals(password);
    }

    public Long login(String email, String password) {
        Sponsor sponsor = sponsorDao.findByEmail(email);
        if (sponsor != null && sponsor.getPassword().equals(password) && !sponsor.getBanned()) {
            return sponsor.getId();
        }
        return null;
    }

    public SponsorVo findById(Long id) {
        return SponsorVo.fromSponsor(sponsorDao.findById(id));
    }

    public SponsorVo findByEmail(String email) {
        return SponsorVo.fromSponsor(sponsorDao.findByEmail(email));
    }

    public boolean register(SponsorVo sponsorVo){
        if(sponsorVo == null)
            return false;

        Sponsor sponsor = sponsorDao.findByEmail(sponsorVo.getEmail());
        if(sponsor != null)
            return false;

        sponsorVo.setId(null);
        sponsorDao.save(sponsorVo.toSponsor(sponsorVo));
        return true;
    }

    public boolean update(SponsorVo sponsorVo){
        if(sponsorVo == null)
            return false;

        Sponsor sponsor = sponsorDao.findById(sponsorVo.getId());
        if(sponsor == null)
            return false;

        BeanUtils.copyProperties(sponsorVo, sponsor);
        sponsorDao.update(sponsor);
        return true;
    }

    public boolean modifyPassword(Long id, String password){
        Sponsor sponsor = sponsorDao.findById(id);
        sponsor.setPassword(password);
        sponsorDao.update(sponsor);
        return true;
    }
}
