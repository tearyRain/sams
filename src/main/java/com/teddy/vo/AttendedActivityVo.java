package com.teddy.vo;

import com.teddy.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class AttendedActivityVo {
    private ActivityVo activity;
    private Byte score;
    private Boolean voluntary;

    public static AttendedActivityVo fromAttendance(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        AttendedActivityVo attendedActivityView = new AttendedActivityVo();
        BeanUtils.copyProperties(attendance, attendedActivityView);
        attendedActivityView.setActivity(ActivityVo.fromActivity(attendance.getActivity()));
        return attendedActivityView;
    }
}
