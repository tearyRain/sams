package com.teddy.view;

import com.teddy.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class AttendedActivityView {
    private ActivityView activity;
    private Byte score;
    private Boolean voluntary;

    public static AttendedActivityView fromAttendance(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        AttendedActivityView attendedActivityView = new AttendedActivityView();
        BeanUtils.copyProperties(attendance, attendedActivityView);
        attendedActivityView.setActivity(ActivityView.fromActivity(attendance.getActivity()));
        return attendedActivityView;
    }
}
