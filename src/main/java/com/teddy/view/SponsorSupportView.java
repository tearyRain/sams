package com.teddy.view;

import com.teddy.entity.Support;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class SponsorSupportView {
    private SponsorView sponsor;
    private boolean chosen;
    private String description;

    public static SponsorSupportView fromSupport(Support support) {
        if (support == null) {
            return null;
        }
        SponsorSupportView sponsorSupportView = new SponsorSupportView();
        BeanUtils.copyProperties(support, sponsorSupportView);
        sponsorSupportView.setSponsor(SponsorView.fromSponsor(support.getSponsor()));
        return sponsorSupportView;
    }
}
