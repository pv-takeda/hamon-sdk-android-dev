// Generated code from Butter Knife. Do not modify!
package com.crrepa.sdk.sample.device;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.crrepa.sdk.sample.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeviceActivity_ViewBinding implements Unbinder {
  private DeviceActivity target;

  private View view7f08005c;

  private View view7f080080;

  private View view7f080073;

  private View view7f0800cb;

  private View view7f0800b9;

  private View view7f0800ca;

  private View view7f0800c9;

  private View view7f0800ad;

  private View view7f0800b7;

  private View view7f0800b2;

  private View view7f0800ab;

  private View view7f080081;

  private View view7f08006e;

  private View view7f0800ac;

  private View view7f080094;

  private View view7f080087;

  private View view7f08008e;

  private View view7f0800a3;

  private View view7f080072;

  private View view7f0800b3;

  private View view7f08008f;

  private View view7f0800a7;

  private View view7f08007c;

  private View view7f080070;

  private View view7f0800ae;

  private View view7f080089;

  private View view7f0800b4;

  private View view7f080090;

  private View view7f0800a9;

  private View view7f08007f;

  private View view7f0800bf;

  private View view7f0800c4;

  private View view7f0800a8;

  private View view7f08007e;

  private View view7f0800bc;

  private View view7f0800c1;

  private View view7f0800c8;

  private View view7f0800c7;

  private View view7f0800c6;

  private View view7f08006f;

  private View view7f0800b8;

  private View view7f0800aa;

  private View view7f080071;

  private View view7f08005f;

  private View view7f080097;

  private View view7f08009f;

  private View view7f0800bb;

  private View view7f0800c0;

  private View view7f0800a6;

  private View view7f08007b;

  private View view7f080088;

  private View view7f0800a5;

  private View view7f080074;

  private View view7f0800c5;

  private View view7f0800ba;

  private View view7f08009b;

  private View view7f08005d;

  private View view7f0800be;

  private View view7f0800c3;

  private View view7f080086;

  private View view7f080098;

  private View view7f0800a0;

  private View view7f080093;

  private View view7f08009c;

  private View view7f080099;

  private View view7f08007d;

  private View view7f0800af;

  private View view7f08008a;

  private View view7f080091;

  private View view7f0800a4;

  private View view7f08008b;

  private View view7f0800b0;

  private View view7f080060;

  private View view7f08006b;

  private View view7f080065;

  private View view7f080084;

  private View view7f080083;

  private View view7f080085;

  private View view7f080069;

  private View view7f080063;

  private View view7f080078;

  private View view7f080077;

  private View view7f080068;

  private View view7f080062;

  private View view7f080076;

  private View view7f080075;

  private View view7f08006a;

  private View view7f080064;

  private View view7f08007a;

  private View view7f080079;

  private View view7f0800bd;

  private View view7f0800c2;

  private View view7f080082;

  private View view7f08006d;

  private View view7f080067;

  private View view7f080095;

  private View view7f080096;

  private View view7f08008d;

  private View view7f08006c;

  private View view7f080066;

  private View view7f08008c;

  private View view7f0800b1;

  private View view7f08009e;

  private View view7f08009d;

  private View view7f08009a;

  private View view7f080092;

  private View view7f0800b5;

  private View view7f0800b6;

  private View view7f080061;

  private View view7f08005e;

  private View view7f0800a1;

  @UiThread
  public DeviceActivity_ViewBinding(DeviceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DeviceActivity_ViewBinding(final DeviceActivity target, View source) {
    this.target = target;

    View view;
    target.tvConnectState = Utils.findRequiredViewAsType(source, R.id.tv_connect_state, "field 'tvConnectState'", TextView.class);
    target.tvFirmwareVersion = Utils.findRequiredViewAsType(source, R.id.tv_firmware_version, "field 'tvFirmwareVersion'", TextView.class);
    target.tvBattery = Utils.findRequiredViewAsType(source, R.id.tv_battery, "field 'tvBattery'", TextView.class);
    target.tvStep = Utils.findRequiredViewAsType(source, R.id.tv_step, "field 'tvStep'", TextView.class);
    target.tvDistance = Utils.findRequiredViewAsType(source, R.id.tv_distance, "field 'tvDistance'", TextView.class);
    target.tvCalorie = Utils.findRequiredViewAsType(source, R.id.tv_calorie, "field 'tvCalorie'", TextView.class);
    target.tvRestful = Utils.findRequiredViewAsType(source, R.id.tv_restful, "field 'tvRestful'", TextView.class);
    target.tvLight = Utils.findRequiredViewAsType(source, R.id.tv_light, "field 'tvLight'", TextView.class);
    target.tvHeartRate = Utils.findRequiredViewAsType(source, R.id.tv_heart_rate, "field 'tvHeartRate'", TextView.class);
    target.tvBloodPressure = Utils.findRequiredViewAsType(source, R.id.tv_blood_pressure, "field 'tvBloodPressure'", TextView.class);
    target.tvUpgradeState = Utils.findRequiredViewAsType(source, R.id.tv_upgrade_state, "field 'tvUpgradeState'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_ble_connect_state, "field 'btnBleDisconnect' and method 'onConnectStateClick'");
    target.btnBleDisconnect = Utils.castView(view, R.id.btn_ble_connect_state, "field 'btnBleDisconnect'", Button.class);
    view7f08005c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onConnectStateClick();
      }
    });
    target.tvBloodOxygen = Utils.findRequiredViewAsType(source, R.id.tv_blood_oxygen, "field 'tvBloodOxygen'", TextView.class);
    target.tvNewFirmwareVersion = Utils.findRequiredViewAsType(source, R.id.tv_new_firmware_version, "field 'tvNewFirmwareVersion'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_query_firmware, "method 'onViewClicked'");
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_battery, "method 'onViewClicked'");
    view7f080073 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sync_time, "method 'onViewClicked'");
    view7f0800cb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_user_info, "method 'onViewClicked'");
    view7f0800b9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sync_step, "method 'onViewClicked'");
    view7f0800ca = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sync_sleep, "method 'onViewClicked'");
    view7f0800c9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_metric_system, "method 'onViewClicked'");
    view7f0800ad = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_time_system, "method 'onViewClicked'");
    view7f0800b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_quick_view, "method 'onViewClicked'");
    view7f0800b2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_goal_step, "method 'onViewClicked'");
    view7f0800ab = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_goal_step, "method 'onViewClicked'");
    view7f080081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_find_band, "method 'onViewClicked'");
    view7f08006e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_message, "method 'onViewClicked'");
    view7f0800ac = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_time_system, "method 'onViewClicked'");
    view7f080094 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_metric_system, "method 'onViewClicked'");
    view7f080087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_quick_view, "method 'onViewClicked'");
    view7f08008e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_alarm_clock, "method 'onViewClicked'");
    view7f0800a3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_alarm_clock, "method 'onViewClicked'");
    view7f080072 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_quickview_time, "method 'onViewClicked'");
    view7f0800b3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_quickview_time, "method 'onViewClicked'");
    view7f08008f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_device_language, "method 'onViewClicked'");
    view7f0800a7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_device_language, "method 'onViewClicked'");
    view7f08007c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_music_control, "method 'onViewClicked'");
    view7f080070 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_other_message, "method 'onViewClicked'");
    view7f0800ae = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_other_message, "method 'onViewClicked'");
    view7f080089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_sedentary_reminder, "method 'onViewClicked'");
    view7f0800b4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_sedentary_reminder, "method 'onViewClicked'");
    view7f080090 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_display_watch_face, "method 'onViewClicked'");
    view7f0800a9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_display_watch_face, "method 'onViewClicked'");
    view7f08007f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_start_measure_heart_rate, "method 'onViewClicked'");
    view7f0800bf = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_stop_measure_heart_rate, "method 'onViewClicked'");
    view7f0800c4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_device_version, "method 'onViewClicked'");
    view7f0800a8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_device_version, "method 'onViewClicked'");
    view7f08007e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_start_measure_blood_pressure, "method 'onViewClicked'");
    view7f0800bc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_stop_measure_blood_pressure, "method 'onViewClicked'");
    view7f0800c1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sync_past_step, "method 'onViewClicked'");
    view7f0800c8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sync_past_sleep, "method 'onViewClicked'");
    view7f0800c7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sync_last_heart_rate, "method 'onViewClicked'");
    view7f0800c6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_firmware_upgrade, "method 'onViewClicked'");
    view7f08006f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_today_weather, "method 'onViewClicked'");
    view7f0800b8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_future_weather, "method 'onViewClicked'");
    view7f0800aa = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_open_24_hreat_rate, "method 'onViewClicked'");
    view7f080071 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_close_24_hreat_rate, "method 'onViewClicked'");
    view7f08005f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_today_hreat_rate, "method 'onViewClicked'");
    view7f080097 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_yesterday_hreat_rate, "method 'onViewClicked'");
    view7f08009f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_start_measure_blood_oxygen, "method 'onViewClicked'");
    view7f0800bb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_stop_measure_blood_oxygen, "method 'onViewClicked'");
    view7f0800c0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_device_function, "method 'onViewClicked'");
    view7f0800a6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_device_function, "method 'onViewClicked'");
    view7f08007b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_movement_hreat_rate, "method 'onViewClicked'");
    view7f080088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_breathing_light, "method 'onViewClicked'");
    view7f0800a5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_breathing_light, "method 'onViewClicked'");
    view7f080074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_switch_background, "method 'onViewClicked'");
    view7f0800c5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_watch_face_layout, "method 'onViewClicked'");
    view7f0800ba = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_watch_face_layout, "method 'onViewClicked'");
    view7f08009b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_check_firmware, "method 'onViewClicked'");
    view7f08005d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_start_measure_ecg, "method 'onViewClicked'");
    view7f0800be = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_stop_measure_ecg, "method 'onViewClicked'");
    view7f0800c3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_last_ecg, "method 'onViewClicked'");
    view7f080086 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_today_steps_category, "method 'onViewClicked'");
    view7f080098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_yesterday_steps_category, "method 'onViewClicked'");
    view7f0800a0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_support_watch_face, "method 'onViewClicked'");
    view7f080093 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_watch_face_store, "method 'onViewClicked'");
    view7f08009c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_watch_face, "method 'onViewClicked'");
    view7f080099 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_device_support_function, "method 'onViewClicked'");
    view7f08007d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_physiologcal_period, "method 'onViewClicked'");
    view7f0800af = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_physiologcal_period, "method 'onViewClicked'");
    view7f08008a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_sleep_action, "method 'onViewClicked'");
    view7f080091 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_band_ui, "method 'onViewClicked'");
    view7f0800a4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_quick_contacts, "method 'onViewClicked'");
    view7f08008b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_quick_contacts, "method 'onViewClicked'");
    view7f0800b0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_delete_quick_contacts, "method 'onViewClicked'");
    view7f080060 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_enable_hrv, "method 'onViewClicked'");
    view7f08006b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_disable_hrv, "method 'onViewClicked'");
    view7f080065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_hrv_measure_interval, "method 'onViewClicked'");
    view7f080084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_hrv_measure_count, "method 'onViewClicked'");
    view7f080083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_hrv_measure_result, "method 'onViewClicked'");
    view7f080085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_enable_continue_blood_pressure, "method 'onViewClicked'");
    view7f080069 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_disable_continue_blood_pressure, "method 'onViewClicked'");
    view7f080063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_continue_blood_pressure_state, "method 'onViewClicked'");
    view7f080078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_continue_blood_pressure, "method 'onViewClicked'");
    view7f080077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_enable_continue_blood_oxygen, "method 'onViewClicked'");
    view7f080068 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_disable_continue_blood_oxygen, "method 'onViewClicked'");
    view7f080062 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_continue_blood_oxygen_state, "method 'onViewClicked'");
    view7f080076 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_continue_blood_oxygen, "method 'onViewClicked'");
    view7f080075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_enable_continue_temp, "method 'onViewClicked'");
    view7f08006a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_disable_continue_temp, "method 'onViewClicked'");
    view7f080064 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_continue_temp_state, "method 'onViewClicked'");
    view7f08007a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_continue_temp, "method 'onViewClicked'");
    view7f080079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_start_measure_breath_rate, "method 'onViewClicked'");
    view7f0800bd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_stop_measure_breath_rate, "method 'onViewClicked'");
    view7f0800c2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_history_breath_rate, "method 'onViewClicked'");
    view7f080082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_enable_timing_breath_rate, "method 'onViewClicked'");
    view7f08006d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_disable_timing_breath_rate, "method 'onViewClicked'");
    view7f080067 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_timing_breath_rate, "method 'onViewClicked'");
    view7f080095 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_timing_breath_rate_state, "method 'onViewClicked'");
    view7f080096 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_quick_responses_count, "method 'onViewClicked'");
    view7f08008d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_enable_quick_responses, "method 'onViewClicked'");
    view7f08006c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_disable_quick_responses, "method 'onViewClicked'");
    view7f080066 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_quick_responses, "method 'onViewClicked'");
    view7f08008c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_quick_responses, "method 'onViewClicked'");
    view7f0800b1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_watch_face_store_tag, "method 'onViewClicked'");
    view7f08009e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_watch_face_store_list, "method 'onViewClicked'");
    view7f08009d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_watch_face_detail, "method 'onViewClicked'");
    view7f08009a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_support_stock, "method 'onViewClicked'");
    view7f080092 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_stock, "method 'onViewClicked'");
    view7f0800b5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_send_stock_price, "method 'onViewClicked'");
    view7f0800b6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_delete_stock, "method 'onViewClicked'");
    view7f080061 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_clear_stock, "method 'onViewClicked'");
    view7f08005e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_reset_stock_list, "method 'onViewClicked'");
    view7f0800a1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DeviceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvConnectState = null;
    target.tvFirmwareVersion = null;
    target.tvBattery = null;
    target.tvStep = null;
    target.tvDistance = null;
    target.tvCalorie = null;
    target.tvRestful = null;
    target.tvLight = null;
    target.tvHeartRate = null;
    target.tvBloodPressure = null;
    target.tvUpgradeState = null;
    target.btnBleDisconnect = null;
    target.tvBloodOxygen = null;
    target.tvNewFirmwareVersion = null;

    view7f08005c.setOnClickListener(null);
    view7f08005c = null;
    view7f080080.setOnClickListener(null);
    view7f080080 = null;
    view7f080073.setOnClickListener(null);
    view7f080073 = null;
    view7f0800cb.setOnClickListener(null);
    view7f0800cb = null;
    view7f0800b9.setOnClickListener(null);
    view7f0800b9 = null;
    view7f0800ca.setOnClickListener(null);
    view7f0800ca = null;
    view7f0800c9.setOnClickListener(null);
    view7f0800c9 = null;
    view7f0800ad.setOnClickListener(null);
    view7f0800ad = null;
    view7f0800b7.setOnClickListener(null);
    view7f0800b7 = null;
    view7f0800b2.setOnClickListener(null);
    view7f0800b2 = null;
    view7f0800ab.setOnClickListener(null);
    view7f0800ab = null;
    view7f080081.setOnClickListener(null);
    view7f080081 = null;
    view7f08006e.setOnClickListener(null);
    view7f08006e = null;
    view7f0800ac.setOnClickListener(null);
    view7f0800ac = null;
    view7f080094.setOnClickListener(null);
    view7f080094 = null;
    view7f080087.setOnClickListener(null);
    view7f080087 = null;
    view7f08008e.setOnClickListener(null);
    view7f08008e = null;
    view7f0800a3.setOnClickListener(null);
    view7f0800a3 = null;
    view7f080072.setOnClickListener(null);
    view7f080072 = null;
    view7f0800b3.setOnClickListener(null);
    view7f0800b3 = null;
    view7f08008f.setOnClickListener(null);
    view7f08008f = null;
    view7f0800a7.setOnClickListener(null);
    view7f0800a7 = null;
    view7f08007c.setOnClickListener(null);
    view7f08007c = null;
    view7f080070.setOnClickListener(null);
    view7f080070 = null;
    view7f0800ae.setOnClickListener(null);
    view7f0800ae = null;
    view7f080089.setOnClickListener(null);
    view7f080089 = null;
    view7f0800b4.setOnClickListener(null);
    view7f0800b4 = null;
    view7f080090.setOnClickListener(null);
    view7f080090 = null;
    view7f0800a9.setOnClickListener(null);
    view7f0800a9 = null;
    view7f08007f.setOnClickListener(null);
    view7f08007f = null;
    view7f0800bf.setOnClickListener(null);
    view7f0800bf = null;
    view7f0800c4.setOnClickListener(null);
    view7f0800c4 = null;
    view7f0800a8.setOnClickListener(null);
    view7f0800a8 = null;
    view7f08007e.setOnClickListener(null);
    view7f08007e = null;
    view7f0800bc.setOnClickListener(null);
    view7f0800bc = null;
    view7f0800c1.setOnClickListener(null);
    view7f0800c1 = null;
    view7f0800c8.setOnClickListener(null);
    view7f0800c8 = null;
    view7f0800c7.setOnClickListener(null);
    view7f0800c7 = null;
    view7f0800c6.setOnClickListener(null);
    view7f0800c6 = null;
    view7f08006f.setOnClickListener(null);
    view7f08006f = null;
    view7f0800b8.setOnClickListener(null);
    view7f0800b8 = null;
    view7f0800aa.setOnClickListener(null);
    view7f0800aa = null;
    view7f080071.setOnClickListener(null);
    view7f080071 = null;
    view7f08005f.setOnClickListener(null);
    view7f08005f = null;
    view7f080097.setOnClickListener(null);
    view7f080097 = null;
    view7f08009f.setOnClickListener(null);
    view7f08009f = null;
    view7f0800bb.setOnClickListener(null);
    view7f0800bb = null;
    view7f0800c0.setOnClickListener(null);
    view7f0800c0 = null;
    view7f0800a6.setOnClickListener(null);
    view7f0800a6 = null;
    view7f08007b.setOnClickListener(null);
    view7f08007b = null;
    view7f080088.setOnClickListener(null);
    view7f080088 = null;
    view7f0800a5.setOnClickListener(null);
    view7f0800a5 = null;
    view7f080074.setOnClickListener(null);
    view7f080074 = null;
    view7f0800c5.setOnClickListener(null);
    view7f0800c5 = null;
    view7f0800ba.setOnClickListener(null);
    view7f0800ba = null;
    view7f08009b.setOnClickListener(null);
    view7f08009b = null;
    view7f08005d.setOnClickListener(null);
    view7f08005d = null;
    view7f0800be.setOnClickListener(null);
    view7f0800be = null;
    view7f0800c3.setOnClickListener(null);
    view7f0800c3 = null;
    view7f080086.setOnClickListener(null);
    view7f080086 = null;
    view7f080098.setOnClickListener(null);
    view7f080098 = null;
    view7f0800a0.setOnClickListener(null);
    view7f0800a0 = null;
    view7f080093.setOnClickListener(null);
    view7f080093 = null;
    view7f08009c.setOnClickListener(null);
    view7f08009c = null;
    view7f080099.setOnClickListener(null);
    view7f080099 = null;
    view7f08007d.setOnClickListener(null);
    view7f08007d = null;
    view7f0800af.setOnClickListener(null);
    view7f0800af = null;
    view7f08008a.setOnClickListener(null);
    view7f08008a = null;
    view7f080091.setOnClickListener(null);
    view7f080091 = null;
    view7f0800a4.setOnClickListener(null);
    view7f0800a4 = null;
    view7f08008b.setOnClickListener(null);
    view7f08008b = null;
    view7f0800b0.setOnClickListener(null);
    view7f0800b0 = null;
    view7f080060.setOnClickListener(null);
    view7f080060 = null;
    view7f08006b.setOnClickListener(null);
    view7f08006b = null;
    view7f080065.setOnClickListener(null);
    view7f080065 = null;
    view7f080084.setOnClickListener(null);
    view7f080084 = null;
    view7f080083.setOnClickListener(null);
    view7f080083 = null;
    view7f080085.setOnClickListener(null);
    view7f080085 = null;
    view7f080069.setOnClickListener(null);
    view7f080069 = null;
    view7f080063.setOnClickListener(null);
    view7f080063 = null;
    view7f080078.setOnClickListener(null);
    view7f080078 = null;
    view7f080077.setOnClickListener(null);
    view7f080077 = null;
    view7f080068.setOnClickListener(null);
    view7f080068 = null;
    view7f080062.setOnClickListener(null);
    view7f080062 = null;
    view7f080076.setOnClickListener(null);
    view7f080076 = null;
    view7f080075.setOnClickListener(null);
    view7f080075 = null;
    view7f08006a.setOnClickListener(null);
    view7f08006a = null;
    view7f080064.setOnClickListener(null);
    view7f080064 = null;
    view7f08007a.setOnClickListener(null);
    view7f08007a = null;
    view7f080079.setOnClickListener(null);
    view7f080079 = null;
    view7f0800bd.setOnClickListener(null);
    view7f0800bd = null;
    view7f0800c2.setOnClickListener(null);
    view7f0800c2 = null;
    view7f080082.setOnClickListener(null);
    view7f080082 = null;
    view7f08006d.setOnClickListener(null);
    view7f08006d = null;
    view7f080067.setOnClickListener(null);
    view7f080067 = null;
    view7f080095.setOnClickListener(null);
    view7f080095 = null;
    view7f080096.setOnClickListener(null);
    view7f080096 = null;
    view7f08008d.setOnClickListener(null);
    view7f08008d = null;
    view7f08006c.setOnClickListener(null);
    view7f08006c = null;
    view7f080066.setOnClickListener(null);
    view7f080066 = null;
    view7f08008c.setOnClickListener(null);
    view7f08008c = null;
    view7f0800b1.setOnClickListener(null);
    view7f0800b1 = null;
    view7f08009e.setOnClickListener(null);
    view7f08009e = null;
    view7f08009d.setOnClickListener(null);
    view7f08009d = null;
    view7f08009a.setOnClickListener(null);
    view7f08009a = null;
    view7f080092.setOnClickListener(null);
    view7f080092 = null;
    view7f0800b5.setOnClickListener(null);
    view7f0800b5 = null;
    view7f0800b6.setOnClickListener(null);
    view7f0800b6 = null;
    view7f080061.setOnClickListener(null);
    view7f080061 = null;
    view7f08005e.setOnClickListener(null);
    view7f08005e = null;
    view7f0800a1.setOnClickListener(null);
    view7f0800a1 = null;
  }
}
