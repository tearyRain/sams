package com.teddy.view;

import com.teddy.entity.Support;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class SupportedActivityView {
    private ActivityView activity;
    private boolean chosen;
    private String description;

    public static SupportedActivityView fromSupport(Support support) {
        if (support == null) {
            return null;
        }
        SupportedActivityView supportedActivityView = new SupportedActivityView();
        BeanUtils.copyProperties(support, supportedActivityView);
        supportedActivityView.setActivity(ActivityView.fromActivity(support.getActivity()));
        return supportedActivityView;
    }
}
