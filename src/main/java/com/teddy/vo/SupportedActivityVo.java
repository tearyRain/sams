package com.teddy.vo;

import com.teddy.entity.Support;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class SupportedActivityVo {
    private ActivityVo activity;
    private boolean chosen;
    private String description;

    public static SupportedActivityVo fromSupport(Support support) {
        if (support == null) {
            return null;
        }
        SupportedActivityVo supportedActivityView = new SupportedActivityVo();
        BeanUtils.copyProperties(support, supportedActivityView);
        supportedActivityView.setActivity(ActivityVo.fromActivity(support.getActivity()));
        return supportedActivityView;
    }
}
