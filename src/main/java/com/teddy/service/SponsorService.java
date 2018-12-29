package com.teddy.service;

import com.teddy.dao.SponsorDao;
import com.teddy.entity.Sponsor;
import com.teddy.vo.SponsorVo;
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

    public SponsorVo findById(Long id) {
        return SponsorVo.fromSponsor(sponsorDao.findById(id));
    }

    public SponsorVo findByEmail(String email) {
        return SponsorVo.fromSponsor(sponsorDao.findByEmail(email));
    }
}
