package com.teddy.vo;

import com.teddy.entity.Sponsor;
import com.teddy.entity.Support;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class SponsorSupportVo {
    private SponsorVo sponsor;
    private boolean chosen;
    private String description;

    public static SponsorSupportVo fromSupport(Support support) {
        if (support == null) {
            return null;
        }
        SponsorSupportVo sponsorSupportView = new SponsorSupportVo();
        BeanUtils.copyProperties(support, sponsorSupportView);
        sponsorSupportView.setSponsor(SponsorVo.fromSponsor(support.getSponsor()));
        return sponsorSupportView;
    }
}
