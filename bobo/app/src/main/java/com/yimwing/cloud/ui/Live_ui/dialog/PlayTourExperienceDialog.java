package com.yimwing.cloud.ui.Live_ui.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.yimwing.cloud.R;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/10
 * Function  打赏成功
 */

public class PlayTourExperienceDialog extends OperateSelector {
    private String experience;//增加的经验值

    public PlayTourExperienceDialog(Activity activity) {
        super(activity, new Configuration());
    }

    public PlayTourExperienceDialog setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_playtour_experience;
    }

    @Override
    protected void preOnShow(CustomDialog dialog) {
        TextView experienceTv = dialog.findView(R.id.tv_playtour_experience);
        experienceTv.setText(experience);
    }

    @Override
    protected void postOnShow(final CustomDialog dialog) {
        dialog.findView(R.id.bt_playtour_experience_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

}
