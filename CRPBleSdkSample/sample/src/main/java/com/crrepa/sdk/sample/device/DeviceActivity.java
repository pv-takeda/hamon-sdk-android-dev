package com.crrepa.sdk.sample.device;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.crrepa.ble.CRPBleClient;
import com.crrepa.ble.conn.CRPBleConnection;
import com.crrepa.ble.conn.CRPBleDevice;
import com.crrepa.ble.conn.bean.CRPAlarmInfo;
import com.crrepa.ble.conn.bean.CRPBloodOxygenInfo;
import com.crrepa.ble.conn.bean.CRPBloodPressureInfo;
import com.crrepa.ble.conn.bean.CRPBreathRateInfo;
import com.crrepa.ble.conn.bean.CRPContactConfigInfo;
import com.crrepa.ble.conn.bean.CRPContactInfo;
import com.crrepa.ble.conn.bean.CRPFunctionInfo;
import com.crrepa.ble.conn.bean.CRPFutureWeatherInfo;
import com.crrepa.ble.conn.bean.CRPHeartRateInfo;
import com.crrepa.ble.conn.bean.CRPHisiliconWatchFaceInfo;
import com.crrepa.ble.conn.bean.CRPHistoryBloodOxygenInfo;
import com.crrepa.ble.conn.bean.CRPHistoryBloodPressureInfo;
import com.crrepa.ble.conn.bean.CRPHistoryBreathRateInfo;
import com.crrepa.ble.conn.bean.CRPHistoryHeartRateInfo;
import com.crrepa.ble.conn.bean.CRPHistoryTrainingInfo;
import com.crrepa.ble.conn.bean.CRPHrvInfo;
import com.crrepa.ble.conn.bean.CRPJieliSupportWatchFaceInfo;
import com.crrepa.ble.conn.bean.CRPJieliWatchFaceInfo;
import com.crrepa.ble.conn.bean.CRPMessageInfo;
import com.crrepa.ble.conn.bean.CRPMovementHeartRateInfo;
import com.crrepa.ble.conn.bean.CRPNapSleepInfo;
import com.crrepa.ble.conn.bean.CRPPerformanceInsightsInfo;
import com.crrepa.ble.conn.bean.CRPPeriodTimeInfo;
import com.crrepa.ble.conn.bean.CRPDeviceSNInfo;
import com.crrepa.ble.conn.bean.CRPPhysiologcalPeriodInfo;
import com.crrepa.ble.conn.bean.CRPQuickResponsesCountInfo;
import com.crrepa.ble.conn.bean.CRPQuickResponsesDetailInfo;
import com.crrepa.ble.conn.bean.CRPSifliSupportWatchFaceInfo;
import com.crrepa.ble.conn.bean.CRPSleepActionInfo;
import com.crrepa.ble.conn.bean.CRPSleepInfo;
import com.crrepa.ble.conn.bean.CRPStepInfo;
import com.crrepa.ble.conn.bean.CRPStepsCategoryInfo;
import com.crrepa.ble.conn.bean.CRPStockInfo;
import com.crrepa.ble.conn.bean.CRPStockPriceInfo;
import com.crrepa.ble.conn.bean.CRPSupportWatchFaceInfo;
import com.crrepa.ble.conn.bean.CRPTempInfo;
import com.crrepa.ble.conn.bean.CRPTodayWeatherInfo;
import com.crrepa.ble.conn.bean.CRPTrainingInfo;
import com.crrepa.ble.conn.bean.CRPTrainingRealtimeInfo;
import com.crrepa.ble.conn.bean.CRPUserInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceBackgroundInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceDetailsInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceDetailsRequestInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceLayoutInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceStoreInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceStoreRequestInfo;
import com.crrepa.ble.conn.bean.CRPWatchFaceStoreTagInfo;
import com.crrepa.ble.conn.bond.CRPBluetoothManager;
import com.crrepa.ble.conn.callback.CRPAlarmCallback;
import com.crrepa.ble.conn.callback.CRPAvailableStorageCallback;
import com.crrepa.ble.conn.callback.CRPBtAddressCallback;
import com.crrepa.ble.conn.callback.CRPContactConfigCallback;
import com.crrepa.ble.conn.callback.CRPDeviceBreathingLightCallback;
import com.crrepa.ble.conn.callback.CRPDeviceDisplayWatchFaceCallback;
import com.crrepa.ble.conn.callback.CRPDeviceFirmwareVersionCallback;
import com.crrepa.ble.conn.callback.CRPDeviceFunctionCallback;
import com.crrepa.ble.conn.callback.CRPDeviceGoalStepCallback;
import com.crrepa.ble.conn.callback.CRPDeviceLanguageCallback;
import com.crrepa.ble.conn.callback.CRPDeviceMetricSystemCallback;
import com.crrepa.ble.conn.callback.CRPDevicePeriodTimeCallback;
import com.crrepa.ble.conn.callback.CRPDevicePhysiologcalPeriodCallback;
import com.crrepa.ble.conn.callback.CRPDeviceQuickViewCallback;
import com.crrepa.ble.conn.callback.CRPDeviceSedentaryReminderCallback;
import com.crrepa.ble.conn.callback.CRPDeviceSupportWatchFaceCallback;
import com.crrepa.ble.conn.callback.CRPDeviceTimeSystemCallback;
import com.crrepa.ble.conn.callback.CRPDeviceVersionCallback;
import com.crrepa.ble.conn.callback.CRPDeviceWatchFaceLayoutCallback;
import com.crrepa.ble.conn.callback.CRPDeviceSNCallback;
import com.crrepa.ble.conn.callback.CRPJieliWatchFaceCallback;
import com.crrepa.ble.conn.callback.CRPMessageListCallback;
import com.crrepa.ble.conn.callback.CRPWatchFaceDetailsCallback;
import com.crrepa.ble.conn.callback.CRPWatchFaceStoreCallback;
import com.crrepa.ble.conn.callback.CRPWatchFaceStoreTagCallback;
import com.crrepa.ble.conn.listener.CRPBleConnectionStateListener;
import com.crrepa.ble.conn.listener.CRPBleECGChangeListener;
import com.crrepa.ble.conn.listener.CRPBleFirmwareUpgradeListener;
import com.crrepa.ble.conn.listener.CRPBloodOxygenChangeListener;
import com.crrepa.ble.conn.listener.CRPBloodPressureChangeListener;
import com.crrepa.ble.conn.listener.CRPBreathRateChangeListener;
import com.crrepa.ble.conn.listener.CRPContactListener;
import com.crrepa.ble.conn.listener.CRPDeviceBatteryListener;
import com.crrepa.ble.conn.listener.CRPFileTransListener;
import com.crrepa.ble.conn.listener.CRPFindPhoneListener;
import com.crrepa.ble.conn.listener.CRPHeartRateChangeListener;
import com.crrepa.ble.conn.listener.CRPHrvChangeListener;
import com.crrepa.ble.conn.listener.CRPMovementStateListener;
import com.crrepa.ble.conn.listener.CRPPhoneOperationListener;
import com.crrepa.ble.conn.listener.CRPQuickResponsesChangeListener;
import com.crrepa.ble.conn.listener.CRPSleepActionChangeListener;
import com.crrepa.ble.conn.listener.CRPSleepChangeListener;
import com.crrepa.ble.conn.listener.CRPStepChangeListener;
import com.crrepa.ble.conn.listener.CRPStepsCategoryChangeListener;
import com.crrepa.ble.conn.listener.CRPStockChangeListener;
import com.crrepa.ble.conn.listener.CRPTempChangeListener;
import com.crrepa.ble.conn.listener.CRPTrainingChangeListener;
import com.crrepa.ble.conn.listener.CRPWatchFaceTransListener;
import com.crrepa.ble.conn.type.CRPBleMessageType;
import com.crrepa.ble.conn.type.CRPDeviceLanguageType;
import com.crrepa.ble.conn.type.CRPDeviceVersionType;
import com.crrepa.ble.conn.type.CRPEcgMeasureType;
import com.crrepa.ble.conn.type.CRPEpoType;
import com.crrepa.ble.conn.type.CRPHeartRateType;
import com.crrepa.ble.conn.type.CRPHistoryDay;
import com.crrepa.ble.conn.type.CRPHistoryDynamicRateType;
import com.crrepa.ble.conn.type.CRPMetricSystemType;
import com.crrepa.ble.conn.type.CRPTimeSystemType;
import com.crrepa.ble.conn.type.CRPWatchFaceLayoutType;
import com.crrepa.ble.conn.type.CRPWatchFaceStoreType;
import com.crrepa.ble.conn.type.CRPWeatherId;
import com.crrepa.ble.scan.bean.CRPScanRecordInfo;
import com.crrepa.ble.trans.tp.CRPTpInfo;
import com.crrepa.sdk.sample.R;
import com.crrepa.sdk.sample.SampleApplication;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bill on 2017/5/15.
 */

public class DeviceActivity extends AppCompatActivity {
    private static final String TAG = "DeviceActivity";
    public static final String DEVICE_ADDRESS = "device_address";
    public static final String DEVICE_MCU_PLATFORM = "device_mcu_platform";

    private static final String UI_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "crrepa" + File.separator + "ota" + File.separator
            + "eaf49ccb4dbe5df51af35803662867d5.bin";

    private static final String WATCH_FACE_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "crrepa"
            + File.separator + "band" + File.separator + "wf" + File.separator
            + "ceed6330a10d2312e28067a4c5776d03.bin";

    private static final String EPO_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "crrepa"
            + File.separator + "epo" + File.separator + "EPO_GR_3_1.DAT";

    ProgressDialog mProgressDialog;
    CRPBleClient mBleClient;
    CRPBleDevice mBleDevice;
    CRPBleConnection mBleConnection;
    boolean isUpgrade = false;

    @BindView(R.id.tv_connect_state)
    TextView tvConnectState;
    @BindView(R.id.tv_firmware_version)
    TextView tvFirmwareVersion;
    @BindView(R.id.tv_battery)
    TextView tvBattery;
    @BindView(R.id.tv_step)
    TextView tvStep;
    @BindView(R.id.tv_distance)
    TextView tvDistance;
    @BindView(R.id.tv_calorie)
    TextView tvCalorie;
    @BindView(R.id.tv_restful)
    TextView tvRestful;
    @BindView(R.id.tv_light)
    TextView tvLight;
    @BindView(R.id.tv_heart_rate)
    TextView tvHeartRate;
    @BindView(R.id.tv_blood_pressure)
    TextView tvBloodPressure;
    @BindView(R.id.tv_upgrade_state)
    TextView tvUpgradeState;
    @BindView(R.id.btn_ble_connect_state)
    Button btnBleDisconnect;
    @BindView(R.id.tv_blood_oxygen)
    TextView tvBloodOxygen;
    @BindView(R.id.tv_new_firmware_version)
    TextView tvNewFirmwareVersion;
    @BindView(R.id.tv_serial_number)
    TextView tvSerialNumber;
    @BindView(R.id.btn_query_serial_number)
    Button btnQuerySerialNumber;

    private String mFirmwareVersion;

    private List<Integer> mSupportWatchFaceList;
    private CRPWatchFaceLayoutInfo mWatchFaceLayoutInfo;

    private CRPScanRecordInfo.McuPlatform mcuPlatform;
    private CRPDeviceSNCallback mDeviceSNCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        ButterKnife.bind(this);

        FileDownloader.setup(this);

        initView();
        mProgressDialog = new ProgressDialog(this);
        String address = getIntent().getStringExtra(DEVICE_ADDRESS);
        if (TextUtils.isEmpty(address)) {
            finish();
            return;
        }

        mcuPlatform = CRPScanRecordInfo.McuPlatform.getInstance(getIntent().getIntExtra(DEVICE_MCU_PLATFORM,
                CRPScanRecordInfo.McuPlatform.PLATFORM_NONE.getValue()));
        Log.d(TAG, "mcuPlatform: " + mcuPlatform);

        mBleClient = SampleApplication.getBleClient(this);
        mBleDevice = mBleClient.getBleDevice(address);
        if (mBleDevice != null && !mBleDevice.isConnected()) {
            connect();
        }
    }

    @OnClick(R.id.btn_query_serial_number)
    public void onQuerySerialNumberClick() {
        if (!mBleDevice.isConnected()) {
            return;
        }
        mBleConnection.queryDeviceSNInfo(mDeviceSNCallback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBleDevice != null) {
            mBleDevice.disconnect();
        }
    }

    void initView() {
        updateStepInfo(0, 0, 0);
        updateSleepInfo(0, 0);
    }

    void connect() {
        mProgressDialog.show();
        mBleConnection = mBleDevice.connect();
        mBleConnection.setConnectionStateListener(new CRPBleConnectionStateListener() {
            @Override
            public void onConnectionStateChange(int newState) {
                Log.d(TAG, "onConnectionStateChange: " + newState);
                int state = -1;
                switch (newState) {
                    case CRPBleConnectionStateListener.STATE_CONNECTED:
                        state = R.string.state_connected;
                        mProgressDialog.dismiss();
                        updateTextView(btnBleDisconnect, getString(R.string.disconnect));
                        testSet();
                        break;
                    case CRPBleConnectionStateListener.STATE_CONNECTING:
                        state = R.string.state_connecting;
                        break;
                    case CRPBleConnectionStateListener.STATE_DISCONNECTED:
                        closeGatt();
                        state = R.string.state_disconnected;
                        mProgressDialog.dismiss();
                        updateTextView(btnBleDisconnect, getString(R.string.connect));

                        if (unBond) {
                            CRPBluetoothManager.getInstance(DeviceActivity.this).unBondDevice(btBluetoothDevice);
                        }

                        break;
                }
                updateConnectState(state);
            }
        });

        mBleConnection.setStepChangeListener(mStepChangeListener);
        mBleConnection.setSleepChangeListener(mSleepChangeListener);
        mBleConnection.setHeartRateChangeListener(mHeartRateChangListener);
        mBleConnection.setBloodPressureChangeListener(mBloodPressureChangeListener);
        mBleConnection.setBloodOxygenChangeListener(mBloodOxygenChangeListener);
        mBleConnection.setFindPhoneListener(mFindPhoneListener);
        mBleConnection.setECGChangeListener(mECGChangeListener, CRPEcgMeasureType.TI);
        mBleConnection.setStepsCategoryListener(mStepsCategoryChangeListener);
        mBleConnection.setSleepActionChangeListener(mSleepActionChangeListener);
        mBleConnection.setMovementStateListener(mMovementStateListener);
        mBleConnection.setTempChangeListener(mTempChangeListener);
        mBleConnection.setContactListener(mContactListener);
        mBleConnection.setHrvChangeListener(mHrvChangeListener);
        mBleConnection.setBreathRateListener(mBreathRateChangeListener);
        mBleConnection.setTrainingListener(mTrainingChangeListener);
        mBleConnection.setStockListener(mStockChangeListener);

        mDeviceSNCallback = new CRPDeviceSNCallback() {
            @Override
            public void onDeviceSN(CRPDeviceSNInfo info) {
                Log.d(TAG, "onDeviceSN: " + info.getSn());
                updateTextView(tvSerialNumber, info.getSn());
            }
        };
    }

    private void closeGatt() {
        if (mBleConnection != null) {
            mBleConnection.close();
        }
    }

    BluetoothDevice btBluetoothDevice;
    boolean unBond = true;

    private void testSet() {
        Log.d(TAG, "testSet");

        mBleConnection.queryBtAddress(new CRPBtAddressCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onAddress(String address) {
                btBluetoothDevice = mBleClient.getBleDevice(address).getBluetoothDevice();
                int bondState = btBluetoothDevice.getBondState();
                Log.d(TAG, "bondState: " + bondState);
            }
        });

//        mBleConnection.queryHistoryHeartRate();
//        mBleConnection.queryHistoryBloodPressure();
//        mBleConnection.queryHistoryBloodOxygen();

//        mBleConnection.queryTimingMeasureTemp(CRPTempTimeType.TODAY);
//        mBleConnection.queryTimingMeasureTemp(CRPTempTimeType.YESTERDAY);

//        mBleConnection.queryTodayHeartRate(CRPHeartRateType.ALL_DAY_HEART_RATE);
//
//        mBleConnection.syncTime();
//        mBleConnection.queryPastHeartRate();
//        mBleConnection.syncStep();
//        mBleConnection.syncSleep();
//        mBleConnection.syncPastStep(CRPPastTimeType.YESTERDAY_STEPS);
//        mBleConnection.syncPastStep(CRPPastTimeType.DAY_BEFORE_YESTERDAY_STEPS);
//        mBleConnection.syncPastSleep(CRPPastTimeType.YESTERDAY_SLEEP);
//        mBleConnection.syncPastSleep(CRPPastTimeType.DAY_BEFORE_YESTERDAY_SLEEP);
//        mBleConnection.queryStepsCategory(CRPStepsCategoryDateType.TODAY_STEPS_CATEGORY);

//        sendFindBandMessage();
    }

    private void sendFindBandMessage() {
        handler.sendEmptyMessageDelayed(1, 5000);
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mBleConnection.findDevice();
                sendFindBandMessage();
            }
        }
    };


    @OnClick(R.id.btn_ble_connect_state)
    public void onConnectStateClick() {
        if (mBleDevice.isConnected()) {
            mBleDevice.disconnect();
        } else {
            connect();
        }
    }

    CRPWatchFaceStoreType mWatchFaceStoreType;
    int mWatchFaceMaxSize;
    int mWatchFaceApiVersion = -1;
    int mWatchFaceFeature = -1;

    List<CRPWatchFaceStoreTagInfo> mWatchFaceStoreTagInfoList;
    CRPWatchFaceStoreInfo mWatchFaceStoreInfo;

    String watchfaceUrl;
    int watchfaceId;

    @OnClick({R.id.btn_query_firmware, R.id.btn_query_battery, R.id.btn_sync_time,
            R.id.btn_send_user_info, R.id.btn_sync_step,
            R.id.btn_sync_sleep, R.id.btn_send_metric_system, R.id.btn_send_time_system,
            R.id.btn_send_quick_view, R.id.btn_send_goal_step, R.id.btn_query_goal_step,
            R.id.btn_find_band, R.id.btn_send_message, R.id.btn_query_time_system,
            R.id.btn_query_metric_system, R.id.btn_query_quick_view, R.id.btn_send_alarm_clock,
            R.id.btn_query_alarm_clock, R.id.btn_send_quickview_time,
            R.id.btn_query_quickview_time, R.id.btn_send_device_language,
            R.id.btn_query_device_language, R.id.btn_music_control,
            R.id.btn_send_other_message, R.id.btn_query_other_message,
            R.id.btn_send_sedentary_reminder, R.id.btn_query_sedentary_reminder,
            R.id.btn_send_display_watch_face, R.id.btn_query_display_watch_face,
            R.id.btn_start_measure_heart_rate, R.id.btn_stop_measure_heart_rate,
            R.id.btn_send_device_version, R.id.btn_query_device_version,
            R.id.btn_start_measure_blood_pressure, R.id.btn_stop_measure_blood_pressure,
            R.id.btn_sync_past_step, R.id.btn_sync_past_sleep, R.id.btn_sync_last_heart_rate,
            R.id.btn_firmware_upgrade, R.id.btn_send_today_weather, R.id.btn_send_future_weather,
            R.id.btn_open_24_hreat_rate, R.id.btn_close_24_hreat_rate,
            R.id.btn_query_today_hreat_rate, R.id.btn_query_yesterday_hreat_rate,
            R.id.btn_start_measure_blood_oxygen, R.id.btn_stop_measure_blood_oxygen,
            R.id.btn_send_device_function, R.id.btn_query_device_function,
            R.id.btn_query_movement_hreat_rate, R.id.btn_send_breathing_light,
            R.id.btn_query_breathing_light, R.id.btn_switch_background,
            R.id.btn_send_watch_face_layout, R.id.btn_query_watch_face_layout,
            R.id.btn_check_firmware, R.id.btn_start_measure_ecg, R.id.btn_stop_measure_ecg,
            R.id.btn_query_last_ecg, R.id.btn_query_today_steps_category,
            R.id.btn_query_yesterday_steps_category, R.id.btn_query_support_watch_face,
            R.id.btn_query_watch_face_store, R.id.btn_query_watch_face,
            R.id.btn_query_device_support_function, R.id.btn_send_physiologcal_period,
            R.id.btn_query_physiologcal_period, R.id.btn_query_sleep_action, R.id.btn_send_band_ui,
            R.id.btn_query_quick_contacts, R.id.btn_send_quick_contacts,
            R.id.btn_delete_quick_contacts, R.id.btn_enable_hrv, R.id.btn_disable_hrv,
            R.id.btn_query_hrv_measure_interval, R.id.btn_query_hrv_measure_count,
            R.id.btn_query_hrv_measure_result, R.id.btn_enable_continue_blood_pressure,
            R.id.btn_disable_continue_blood_pressure, R.id.btn_query_continue_blood_pressure_state,
            R.id.btn_query_continue_blood_pressure, R.id.btn_enable_continue_blood_oxygen,
            R.id.btn_disable_continue_blood_oxygen, R.id.btn_query_continue_blood_oxygen_state,
            R.id.btn_query_continue_blood_oxygen, R.id.btn_enable_continue_temp,
            R.id.btn_disable_continue_temp, R.id.btn_query_continue_temp_state,
            R.id.btn_query_continue_temp, R.id.btn_start_measure_breath_rate,
            R.id.btn_stop_measure_breath_rate, R.id.btn_query_history_breath_rate,
            R.id.btn_enable_timing_breath_rate, R.id.btn_disable_timing_breath_rate,
            R.id.btn_query_timing_breath_rate, R.id.btn_query_timing_breath_rate_state,
            R.id.btn_query_quick_responses_count, R.id.btn_enable_quick_responses,
            R.id.btn_disable_quick_responses, R.id.btn_query_quick_responses, R.id.btn_send_quick_responses,
            R.id.btn_query_watch_face_store_tag, R.id.btn_query_watch_face_store_list, R.id.btn_query_watch_face_detail,
            R.id.btn_query_support_stock, R.id.btn_send_stock, R.id.btn_send_stock_price,
            R.id.btn_delete_stock, R.id.btn_clear_stock, R.id.btn_reset_stock_list})
    public void onViewClicked(View view) {
        if (!mBleDevice.isConnected()) {
            return;
        }
        switch (view.getId()) {
            case R.id.btn_query_physiologcal_period:
                mBleConnection.queryPhysiologcalPeriod(new CRPDevicePhysiologcalPeriodCallback() {
                    @Override
                    public void onPhysiologcalPeriod(CRPPhysiologcalPeriodInfo info) {
                        Log.d(TAG, "isMenstrualReminder: " + info.isMenstrualReminder());
                        Log.d(TAG, "isOvulationEndReminder: " + info.isOvulationEndReminder());
                        Log.d(TAG, "isOvulationDayReminder: " + info.isOvulationDayReminder());
                        Log.d(TAG, "isOvulationReminder: " + info.isOvulationReminder());
                        Log.d(TAG, "physiologcalPeriod: " + info.getPhysiologcalPeriod());
                        Log.d(TAG, "startDate: " + info.getStartDate());
                        Log.d(TAG, "hour: " + info.getReminderHour());
                        Log.d(TAG, "minute: " + info.getReminderMinute());
                    }
                });
                break;
            case R.id.btn_send_physiologcal_period:
                CRPPhysiologcalPeriodInfo physiologcalPeriodInfo = new CRPPhysiologcalPeriodInfo();
                physiologcalPeriodInfo.setReminderHour(10);
                physiologcalPeriodInfo.setReminderMinute(0);
                physiologcalPeriodInfo.setStartDate(new Date());
                physiologcalPeriodInfo.setMenstrualPeriod(5);
                physiologcalPeriodInfo.setPhysiologcalPeriod(28);
                physiologcalPeriodInfo.setOvulationEndReminder(true);
                physiologcalPeriodInfo.setMenstrualReminder(true);
                physiologcalPeriodInfo.setOvulationReminder(true);
                physiologcalPeriodInfo.setOvulationDayReminder(true);
                mBleConnection.sendPhysiologcalPeriod(physiologcalPeriodInfo);
                break;
            case R.id.btn_query_device_support_function:
                mBleConnection.queryDeviceSupportFunction(new CRPDeviceFunctionCallback() {
                    @Override
                    public void onFunctionChenge(CRPFunctionInfo info) {
                        for (Integer integer : info.getFunctionList()) {
                            Log.d(TAG, "function: " + integer.intValue());
                        }
                    }
                });
                break;
            case R.id.btn_send_device_function:
                List<Integer> functionList = new ArrayList<>();
                functionList.add(CRPFunctionInfo.TIME_VIEW);
                functionList.add(CRPFunctionInfo.STEP_VIEW);
                functionList.add(CRPFunctionInfo.SLEEP_VIEW);
                functionList.add(CRPFunctionInfo.HR_VIEW);
                functionList.add(CRPFunctionInfo.TRAINING_VIEW);
                functionList.add(CRPFunctionInfo.BP_VIEW);
                functionList.add(CRPFunctionInfo.BO_VIEW);
                functionList.add(CRPFunctionInfo.WEATHER_VIEW);
                functionList.add(CRPFunctionInfo.MSG_LIST_VIEW);
                functionList.add(CRPFunctionInfo.MUSIC_PLAYER_VIEW);
                functionList.add(CRPFunctionInfo.CAMERA_VIEW);
                functionList.add(CRPFunctionInfo.OTHER_VIEW);
                CRPFunctionInfo functionInfo = new CRPFunctionInfo();
                functionInfo.setFunctionList(functionList);
                mBleConnection.sendDislpayDeviceFunction(functionInfo);
                break;
            case R.id.btn_query_device_function:
                mBleConnection.queryDisplayDeviceFunction(new CRPDeviceFunctionCallback() {
                    @Override
                    public void onFunctionChenge(CRPFunctionInfo info) {
                        for (Integer integer : info.getFunctionList()) {
                            Log.d(TAG, "function: " + integer);
                        }
                    }
                });

                mBleConnection.queryMessageList(new CRPMessageListCallback() {
                    @Override
                    public void onMessageList(List<Integer> list) {
                        showToast("支持消息列表：" + list);
                    }
                });
                break;
            case R.id.btn_query_firmware:
                mBleConnection.queryFrimwareVersion(new CRPDeviceFirmwareVersionCallback() {
                    @Override
                    public void onDeviceFirmwareVersion(String version) {
                        mFirmwareVersion = version;
                        updateTextView(tvFirmwareVersion, version);
                    }
                });
                break;
            case R.id.btn_check_firmware:
//                mBleConnection.queryTraining(9);
                break;
            case R.id.btn_firmware_upgrade:
//                if (isUpgrade) {
//                    mBleConnection.startFirmwareUpgrade(true, mFirmwareUpgradeListener);
//                }

//                SifliDfuController sifliDfuController = new SifliDfuController();
//                sifliDfuController.setUpgradeListener(mFirmwareUpgradeListener);
//                sifliDfuController.start(mBleDevice.getMacAddress());

//                RtkDfuController rtkDfuController = new RtkDfuController();
//                rtkDfuController.setUpgradeListener(mFirmwareUpgradeListener);
//                rtkDfuController.start(mBleDevice.getMacAddress());

//                JieliDfuController jieliDfuController = new JieliDfuController();
//                jieliDfuController.setUpgradeListener(mFirmwareUpgradeListener);
//                jieliDfuController.start();

                break;
            case R.id.btn_switch_background:
                if (mWatchFaceLayoutInfo == null) {
                    return;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;

                Bitmap bitmap = BitmapFactory.decodeResource(
                        getResources(), R.drawable.color_wheel, options);
                Bitmap changeBitmap = changeBitmapSize(bitmap, mWatchFaceLayoutInfo.getWidth(), mWatchFaceLayoutInfo.getHeight());
                Log.d(TAG, "changeBitmap width: " + changeBitmap.getWidth() + ", height: " + mWatchFaceLayoutInfo.getHeight());
                CRPWatchFaceBackgroundInfo watchFaceBackgroundInfo = new CRPWatchFaceBackgroundInfo(changeBitmap,
                        mWatchFaceLayoutInfo.getCompressionType());

                mBleConnection.sendWatchFaceBackground(watchFaceBackgroundInfo, new CRPFileTransListener() {
                    @Override
                    public void onTransProgressStarting() {
                        Log.d(TAG, "onTransProgressStarting");
                    }

                    @Override
                    public void onTransProgressChanged(int percent) {
                        Log.d(TAG, "percent: " + percent);
                    }

                    @Override
                    public void onTransCompleted() {
                        Log.d(TAG, "onTransCompleted");
                    }

                    @Override
                    public void onError(int type) {

                    }
                });
                break;
            case R.id.btn_query_battery:
                mBleConnection.subscribeDeviceBattery();
                mBleConnection.setDeviceBatteryListener(new CRPDeviceBatteryListener() {
                    @Override
                    public void onSubscribe(boolean success) {
                        Log.d(TAG, " battery subscribed: " + success);
                    }

                    @Override
                    public void onDeviceBattery(int battery) {
                        updateTextView(tvBattery, battery + "%");
                    }
                });
                mBleConnection.queryDeviceBattery();
                break;
            case R.id.btn_sync_time:
                mBleConnection.syncTime();
                break;
            case R.id.btn_music_control:
                mBleConnection.setPhoneOperationListener(new CRPPhoneOperationListener() {
                    @Override
                    public void onOperationChange(int type) {
                        Log.d(TAG, "onOperationChange: " + type);
                    }
                });
                break;
            case R.id.btn_send_user_info:
                CRPUserInfo userInfo = new CRPUserInfo(75, 178, CRPUserInfo.MALE, 24);
                mBleConnection.sendUserInfo(userInfo);
                break;
            case R.id.btn_sync_step:
                mBleConnection.syncStep();
                break;
            case R.id.btn_sync_past_step:
                mBleConnection.queryHistoryStep(CRPHistoryDay.YESTERDAY);
                mBleConnection.queryHistoryStep(CRPHistoryDay.THE_DAY_BEFORE_YESTERDAY);
                mBleConnection.queryHistoryStep(CRPHistoryDay.THREE_DAYS_AGO);
                break;
            case R.id.btn_sync_sleep:
                mBleConnection.syncSleep();
                break;
            case R.id.btn_sync_past_sleep:
                mBleConnection.syncRemSleep();
                mBleConnection.queryHistorySleep(CRPHistoryDay.YESTERDAY);
                mBleConnection.queryHistorySleep(CRPHistoryDay.THE_DAY_BEFORE_YESTERDAY);
                mBleConnection.queryHistorySleep(CRPHistoryDay.THREE_DAYS_AGO);

//                String EPO_FILE_PATH = getFilesDir() + File.separator + "crp"
//                        + File.separator + "epo" + File.separator + "EPO_GR_3_1.DAT";

//                sendEpoFile(CRPEpoType.GPS);
                break;
            case R.id.btn_send_metric_system:
//                List<Integer> savedTimeList = new ArrayList<>();
//                mBleConnection.setGpsChangeListener(new CRPGpsChangeListener() {
//                    @Override
//                    public void onHistoryGpsPathChange(List<Integer> timeList) {
//                        if (timeList != null) {
//                            Log.d(TAG, "onHistoryGpsChange: " + timeList.toString());
////                            for (Integer time : timeList) {
////                                mBleConnection.queryGpsDetail(time);
////                            }
//                            savedTimeList.addAll(timeList);
//                            mBleConnection.queryGpsDetail(savedTimeList.remove(0));
//                        }
//                    }
//
//                    @Override
//                    public void onGpsPathChange(CRPGpsPathInfo info) {
//                        Log.d(TAG, "onGpsPathChange: " + info.toString());
//                        if (!savedTimeList.isEmpty()) {
//                            mBleConnection.queryGpsDetail(savedTimeList.remove(0));
//                        }
//                    }
//
//                    @Override
//                    public void onLocationChanged(CRPGpsPathInfo.Location location) {
//                        Log.d(TAG, "onLocationChanged: " + location.toString());
//                    }
//
//                    @Override
//                    public void onUpdateEpoChange(CRPEpoType type) {
//                        sendEpoFile(type);
//                    }
//
//                });
//
//                mBleConnection.queryHistoryGps();

                mBleConnection.sendMetricSystem(CRPMetricSystemType.METRIC_SYSTEM);
                break;
            case R.id.btn_query_metric_system:
                mBleConnection.queryMetricSystem(new CRPDeviceMetricSystemCallback() {
                    @Override
                    public void onMetricSystem(int type) {
                        Log.d(TAG, "onMetricSystem: " + type);
                    }
                });
                break;
            case R.id.btn_send_time_system:
                mBleConnection.sendTimeSystem(CRPTimeSystemType.TIME_SYSTEM_12);
                break;
            case R.id.btn_query_time_system:
                mBleConnection.queryTimeSystem(new CRPDeviceTimeSystemCallback() {
                    @Override
                    public void onTimeSystem(int type) {
                        Log.d(TAG, "onTimeSystem: " + type);
                    }
                });
                break;
            case R.id.btn_send_quick_view:
                mBleConnection.sendQuickView(false);
                break;
            case R.id.btn_query_quick_view:
                mBleConnection.queryQuickView(new CRPDeviceQuickViewCallback() {
                    @Override
                    public void onQuickView(boolean state) {
                        Log.d(TAG, "onQuickView: " + state);
                    }
                });
                break;
            case R.id.btn_send_goal_step:
                mBleConnection.sendGoalSteps(10000);
                break;
            case R.id.btn_query_goal_step:
                mBleConnection.queryGoalStep(new CRPDeviceGoalStepCallback() {
                    @Override
                    public void onGoalStep(int steps) {
                        Log.d(TAG, "onGoalStep: " + steps);
                    }
                });
                break;
            case R.id.btn_find_band:
//                mBleConnection.querySupportStress();
                mBleConnection.findDevice();
//                mBleConnection.stopFindPhond();
                break;
            case R.id.btn_send_message:
                CRPMessageInfo messageInfo = new CRPMessageInfo();
                messageInfo.setMessage("test: Incoming video call");
                messageInfo.setType(CRPBleMessageType.MESSAGE_WHATSAPP);
                messageInfo.setVersionCode(207);
                messageInfo.setHs(false);
                messageInfo.setSmallScreen(true);
                mBleConnection.sendMessage(messageInfo);
                break;
            case R.id.btn_send_alarm_clock:
                CRPAlarmInfo alarmInfo = new CRPAlarmInfo();
                alarmInfo.setId(CRPAlarmInfo.FIRST_ALARM);
                alarmInfo.setHour(14);
                alarmInfo.setMinute(24);
                alarmInfo.setRepeatMode(CRPAlarmInfo.SINGLE);
                alarmInfo.setDate(new Date());
                alarmInfo.setEnable(true);
                mBleConnection.sendNewAlarm(alarmInfo);

//                mBleConnection.deleteNewAlarm(0);

//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(new Date());
//
//                for (int i = 0; i < 12; i++) {
//                    CRPCalendarEventInfo eventInfo = new CRPCalendarEventInfo();
//                    eventInfo.setId(i);
//                    calendar.add(Calendar.DAY_OF_MONTH, i);
//                    eventInfo.setTime(calendar.getTimeInMillis() / 1000);
//                    eventInfo.setEndHour(9);
//                    eventInfo.setEndMinute(0);
//                    eventInfo.setTitle("把你的计算机");
//                    eventInfo.setStartHour(8);
//                    eventInfo.setStartMinute(10);
//                    mBleConnection.sendCalendarEvent(eventInfo);
//                }
                break;
            case R.id.btn_query_alarm_clock:
                CRPAlarmCallback alarmCallback = new CRPAlarmCallback() {
                    @Override
                    public void onAlarmList(List<CRPAlarmInfo> list) {
                        for (CRPAlarmInfo info : list) {
                            Log.d(TAG, info.toString());
                        }
                    }

                    @Override
                    public void onNewAlarmList(List<CRPAlarmInfo> list) {
                        for (CRPAlarmInfo info : list) {
                            Log.d(TAG, info.toString());
                        }
                    }
                };
                mBleConnection.queryAllAlarm(alarmCallback);
//
//                mBleConnection.queryAllNewAlarm(alarmCallback);

//                mBleConnection.setCalendarEventListener(new CRPCalendarEventListener() {
//                    @Override
//                    public void onSupportEvent(int maxEventCount, List<CRPSavedCalendarEventInfo> savedEventList) {
//                        Log.d(TAG, "maxEventCount: " + maxEventCount);
//                        for (CRPSavedCalendarEventInfo calendarEventInfo : savedEventList) {
//                            Log.d(TAG, calendarEventInfo.toString());
//                        }
//                    }
//
//                    @Override
//                    public void onEvent(CRPCalendarEventInfo info) {
//                        Log.d(TAG, info.toString());
//                    }
//
//                    @Override
//                    public void onEventReminderTime(boolean enable, int minutes) {
//                        Log.d(TAG, enable + ": " + minutes);
//                    }
//                });
//                mBleConnection.querySupportCalendarEvent();
                break;
            case R.id.btn_send_quickview_time:
                final CRPPeriodTimeInfo info = new CRPPeriodTimeInfo();
                info.setStartHour(8);
                info.setStartMinute(0);
                info.setEndHour(20);
                info.setEndMinute(0);
                mBleConnection.sendQuickViewTime(info);

//                mBleConnection.queryHistoryBloodOxygen();

//                mBleConnection.queryHistoryHeartRate();
//
//                mBleConnection.queryHistoryBloodPressure();

                break;
            case R.id.btn_query_quickview_time:
                mBleConnection.queryQuickViewTime(new CRPDevicePeriodTimeCallback() {
                    @Override
                    public void onPeriodTime(int type, CRPPeriodTimeInfo periodTimeInfo) {
                        int startHour = periodTimeInfo.getStartHour();
                        int startMinute = periodTimeInfo.getStartMinute();
                        int endHour = periodTimeInfo.getEndHour();
                        int endMinute = periodTimeInfo.getEndMinute();
                        Log.d(TAG, "startTime: " + startHour + ":" + startMinute);
                        Log.d(TAG, "endTime: " + endHour + ":" + endMinute);
                    }
                });
                break;
            case R.id.btn_send_device_language:
                mBleConnection.sendDeviceVersion(CRPDeviceVersionType.INTERNATIONAL_EDITION);
                mBleConnection.sendDeviceLanguage(CRPDeviceLanguageType.LANGUAGE_UKRAINIAN);

//                mBleConnection.sendTapToWakeState(true);
                break;
            case R.id.btn_query_device_language:
//                mBleConnection.queryTapToWakeState(new CRPTapToWakeCallback() {
//                    @Override
//                    public void onWakeState(boolean enable) {
//                        Log.d(TAG, "onWakeState: " + enable);
//                    }
//                });

                mBleConnection.queryDeviceLanguage(new CRPDeviceLanguageCallback() {
                    @Override
                    public void onDeviceLanguage(int type, int[] languageArray) {
                        Log.d(TAG, "onDeviceLanguage display language: " + type);
                        for (int i : languageArray) {
                            Log.d(TAG, "onDeviceLanguage languageArray " + i);
                        }
                    }
                });
                break;
            case R.id.btn_send_other_message:
//                mBleConnection.sendOtherMessageState(true);
                mBleConnection.enterCameraView();
                break;
            case R.id.btn_query_other_message:
                mBleConnection.exitCameraView();
//                mBleConnection.queryOtherMessageState(new CRPDeviceOtherMessageCallback() {
//                    @Override
//                    public void onOtherMessage(boolean state) {
//                        Log.d(TAG, "onOtherMessage: " + state);
//                    }
//                });
                break;
            case R.id.btn_send_sedentary_reminder:
                mBleConnection.sendSedentaryReminder(true);
//                mBleConnection.setCallNumberListener(new CRPCallNumberListener() {
//                    @Override
//                    public void onCallNumber(String number) {
//                        mBleConnection.sendCallContactName("zhanghao");
//                    }
//                });
                break;
            case R.id.btn_query_sedentary_reminder:
                mBleConnection.querySedentaryReminder(new CRPDeviceSedentaryReminderCallback() {
                    @Override
                    public void onSedentaryReminder(boolean state) {
                        Log.d(TAG, "onSedentaryReminder: " + state);
                    }
                });
                break;
            case R.id.btn_send_display_watch_face:
                mBleConnection.sendDisplayWatchFace((byte) 1);
                break;
            case R.id.btn_query_display_watch_face:
                mBleConnection.queryDisplayWatchFace(new CRPDeviceDisplayWatchFaceCallback() {
                    @Override
                    public void onDisplayWatchFace(int type) {
                        Log.d(TAG, "onDisplayWatchFace: " + type);
                    }
                });
                break;
            case R.id.btn_start_measure_heart_rate:
                mBleConnection.startMeasureOnceHeartRate();
                break;
            case R.id.btn_stop_measure_heart_rate:
                mBleConnection.stopMeasureOnceHeartRate();
                break;
            case R.id.btn_sync_last_heart_rate:
                mBleConnection.queryLastDynamicRate(CRPHistoryDynamicRateType.FIRST_HEART_RATE);
//                mBleConnection.queryLastDynamicRate(CRPHistoryDynamicRateType.SECOND_HEART_RATE);
//                mBleConnection.queryLastDynamicRate(CRPHistoryDynamicRateType.THIRD_HEART_RATE);
//                mBleConnection.queryMovementHeartRate();
                break;
            case R.id.btn_open_24_hreat_rate:
                mBleConnection.enableTimingMeasureHeartRate(1);
//                byte[] bondBytes = {0x01, 0x03, 0x03, 0x04, 0x06, 0x06};
//                mBleConnection.createBond(bondBytes, new CRPDeviceBondStateCallback() {
//                    @Override
//                    public void onBondState(int bondState) {
//                        Log.d(TAG, "onBondState: " + bondState);
//                    }
//                });
                break;
            case R.id.btn_close_24_hreat_rate:
                mBleConnection.disableTimingMeasureHeartRate();
                break;
            case R.id.btn_query_today_hreat_rate:
                mBleConnection.queryTodayHeartRate(CRPHeartRateType.TIMING_MEASURE_HEART_RATE);
                break;
            case R.id.btn_query_yesterday_hreat_rate:
                mBleConnection.queryHistoryTimingHeartRate(CRPHistoryDay.TODAY);
                mBleConnection.queryHistoryTimingHeartRate(CRPHistoryDay.YESTERDAY);
                mBleConnection.queryHistoryTimingHeartRate(CRPHistoryDay.THE_DAY_BEFORE_YESTERDAY);
                break;
            case R.id.btn_query_movement_hreat_rate:

                mBleConnection.startMovement(CRPMovementHeartRateInfo.WALK_TYPE);

//                mBleConnection.queryMovementHeartRate();
//                mBleConnection.queryPillReminder(new CRPPillReminderCallback() {
//                    @Override
//                    public void onPillReminder(int supportCount, List<CRPPillReminderInfo> list) {
//                        Log.d(TAG, "onPillReminder: " + list.size());
//                    }
//                });
                break;
            case R.id.btn_send_device_version:
                mBleConnection.sendDeviceVersion(CRPDeviceVersionType.INTERNATIONAL_EDITION);

//                mBleConnection.setStressListener(new CRPStressListener() {
//                    @Override
//                    public void onSupportStress(boolean supported) {
//
//                    }
//
//                    @Override
//                    public void onStressChange(int stress) {
//
//                    }
//
//                    @Override
//                    public void onHistoryStressChange(List<CRPHistoryStressInfo> list) {
//
//                    }
//
//                    @Override
//                    public void onTimingStressStateChange(boolean enable) {
//
//                    }
//
//                    @Override
//                    public void onTimingStressChange(CRPTimingStressInfo info) {
//                        Log.d(TAG, "onTimingStressChange: " + info);
//                    }
//                });
//
//                mBleConnection.queryTimingStress(CRPStressDate.TODAY);

                break;
            case R.id.btn_query_device_version:
                mBleConnection.queryDeviceVersion(new CRPDeviceVersionCallback() {
                    @Override
                    public void onDeviceVersion(int version) {
                        Log.d(TAG, "onDeviceVersion: " + version);
                    }
                });
                break;
            case R.id.btn_start_measure_blood_pressure:
                mBleConnection.startMeasureBloodPressure();
                break;
            case R.id.btn_stop_measure_blood_pressure:
                mBleConnection.stopMeasureBloodPressure();
                break;
            case R.id.btn_send_today_weather:
                CRPTodayWeatherInfo todayWeatherInfo = new CRPTodayWeatherInfo();
                todayWeatherInfo.setCity("深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳深圳");
//                todayWeatherInfo.setFestival(" ");
                todayWeatherInfo.setLunar("六月十四");
                todayWeatherInfo.setPm25(10);
                todayWeatherInfo.setTemp(38);
                todayWeatherInfo.setWeatherId(CRPWeatherId.RAINY);
                mBleConnection.sendTodayWeather(todayWeatherInfo);
                break;
            case R.id.btn_send_future_weather:
                CRPFutureWeatherInfo futureWeatherInfo = new CRPFutureWeatherInfo();
                List<CRPFutureWeatherInfo.FutureBean> list = new ArrayList<>();

                for (int i = 0; i < 7; i++) {
                    CRPFutureWeatherInfo.FutureBean bean = new CRPFutureWeatherInfo.FutureBean();
                    bean.setWeatherId(300);
                    bean.setLowTemperature(20 + i);
                    bean.setHighTemperature(30 + i);
                    list.add(bean);
                }
                futureWeatherInfo.setFuture(list);
                mBleConnection.sendFutureWeather(futureWeatherInfo);
                break;
            case R.id.btn_start_measure_blood_oxygen:
                mBleConnection.startMeasureBloodOxygen();
//                mBleConnection.startMeasureStress();
                break;
            case R.id.btn_stop_measure_blood_oxygen:
                mBleConnection.stopMeasureBloodOxygen();
//                mBleConnection.stopMeasureStress();
                break;
            case R.id.btn_send_breathing_light:
                mBleConnection.sendBreathingLight(true);
                break;
            case R.id.btn_query_breathing_light:
                mBleConnection.queryBreathingLight(new CRPDeviceBreathingLightCallback() {
                    @Override
                    public void onBreathingLight(boolean enable) {
                        Log.d(TAG, "onBreathingLight: " + enable);
                    }
                });
                break;
            case R.id.btn_send_watch_face_layout:
                CRPWatchFaceLayoutInfo watchFaceLayoutInfo = new CRPWatchFaceLayoutInfo();
                watchFaceLayoutInfo.setTimePosition(CRPWatchFaceLayoutType.WATCH_FACE_TIME_BOTTOM);
                watchFaceLayoutInfo.setTimeTopContent(CRPWatchFaceLayoutType.WATCH_FACE_CONTENT_SLEEP);
                watchFaceLayoutInfo.setTimeBottomContent(CRPWatchFaceLayoutType.WATCH_FACE_CONTENT_STEP);
                int color = ContextCompat.getColor(this, R.color.color_watch_face_text_blue);
                watchFaceLayoutInfo.setTextColor(color);
                watchFaceLayoutInfo.setBackgroundPictureMd5(CRPWatchFaceLayoutType.DEFAULT_WATCH_FACE_BG_MD5);

                mBleConnection.sendWatchFaceLayout(watchFaceLayoutInfo);
                break;
            case R.id.btn_query_watch_face_layout:
                mBleConnection.queryWatchFaceLayout(new CRPDeviceWatchFaceLayoutCallback() {
                    @Override
                    public void onWatchFaceLayoutChange(CRPWatchFaceLayoutInfo info) {
                        Log.d(TAG, "onWatchFaceLayoutChange: " + info.toString());
                        mWatchFaceLayoutInfo = info;
                    }
                });
                break;
            case R.id.btn_start_measure_ecg:
                mBleConnection.startECGMeasure();
                mBleConnection.sendBatterySaving(true);
                break;
            case R.id.btn_stop_measure_ecg:
//                mBleConnection.stopECGMeasure();
                mBleConnection.queryBatterySaving();
                break;
            case R.id.btn_query_last_ecg:
                mBleConnection.queryLastMeasureECGData();
                break;
            case R.id.btn_query_today_steps_category:
//                mBleConnection.queryStepsCategory(CRPStepsCategoryDateType.TODAY_STEPS_CATEGORY);
                mBleConnection.sendSongTitle("hello");
                break;
            case R.id.btn_query_yesterday_steps_category:
//                mBleConnection.queryStepsCategory(CRPStepsCategoryDateType.YESTERDAY_STEPS_CATEGORY);
                mBleConnection.closeMusicControl();
                break;
            case R.id.btn_query_support_watch_face:
                mBleConnection.querySupportWatchFace(new CRPDeviceSupportWatchFaceCallback() {
                    @Override
                    public void onSupportWatchFace(CRPSupportWatchFaceInfo info) {
                        Log.d(TAG, "onSupportWatchFace: " + info.toString());
                        mWatchFaceStoreType = CRPWatchFaceStoreType.DEFAULT;
                        mSupportWatchFaceList = info.getSupportWatchFaceList();
                    }

                    @Override
                    public void onSifliSupportWatchFace(CRPSifliSupportWatchFaceInfo info) {
                        Log.d(TAG, "onSifliSupportWatchFace: " + info.toString());
                        mWatchFaceStoreType = CRPWatchFaceStoreType.SIFLI;
                        mSupportWatchFaceList = new ArrayList<>();
                        mSupportWatchFaceList.add(info.getType());
                    }

                    @Override
                    public void onJieliSupportWatchFace(CRPJieliSupportWatchFaceInfo info) {
                        Log.d(TAG, "onJieliSupportWatchFace: " + info.toString());
                        mWatchFaceStoreType = CRPWatchFaceStoreType.JIELI;
                        mSupportWatchFaceList = info.getSupportTypeList();

                        mWatchFaceMaxSize = info.getWatchFaceMaxSize();
                    }

                    @Override
                    public void onJieliDownloadWatchFaceList(List<Integer> list) {

                    }

                    @Override
                    public void onHisiliconSupportWatchFace(CRPHisiliconWatchFaceInfo info) {

                    }
                });

                mBleConnection.queryAvailableStorage(new CRPAvailableStorageCallback() {
                    @Override
                    public void onAvailableSize(int size) {
                        Log.d(TAG, "onAvailableSize: " + size);

                        mWatchFaceMaxSize = size * 1024;
                    }
                });
                break;
            case R.id.btn_query_watch_face_store:
                mBleConnection.queryWatchFaceStore(mSupportWatchFaceList, mFirmwareVersion, 20, 0,
                        new CRPWatchFaceStoreCallback() {

                            @Override
                            public void onWatchFaceStoreChange(CRPWatchFaceStoreInfo info) {
                                Log.d(TAG, "onWatchFaceStoreChange: " + info.getList().size());
                            }

                            @Override
                            public void onError(String msg) {

                            }
                        });
                break;
            case R.id.btn_query_watch_face_store_tag:
                // 1
                if (mWatchFaceStoreType == null) {
                    Log.e(TAG, "mWatchFaceStoreType is null!");
                    return;
                }

                if (mSupportWatchFaceList == null || mSupportWatchFaceList.isEmpty()) {
                    Log.e(TAG, "mSupportWatchFaceList is null!");
                    return;
                }

                if (TextUtils.isEmpty(mFirmwareVersion)) {
                    Log.e(TAG, "mFirmwareVersion is null!");
                    return;
                }

                CRPWatchFaceStoreRequestInfo watchFaceStoreRequestInfo = new CRPWatchFaceStoreRequestInfo(mWatchFaceStoreType, mSupportWatchFaceList, mFirmwareVersion, 20, 1, mWatchFaceMaxSize);
                if (mcuPlatform == CRPScanRecordInfo.McuPlatform.PLATFORM_JIELI) {
                    if (mWatchFaceApiVersion < 0 || mWatchFaceFeature < 0) {
                        mBleConnection.queryJieliWatchFaceInfo(new CRPJieliWatchFaceCallback() {
                            @Override
                            public void onWatchFaceInfo(CRPJieliWatchFaceInfo info) {
                                Log.d(TAG, "onWatchFaceInfo: " + info.toString());
                                mWatchFaceApiVersion = info.getApiVersion();
                                mWatchFaceFeature = info.getFeature();
                            }
                        });
                        return;
                    }

                    watchFaceStoreRequestInfo.setFeature(mWatchFaceFeature);
                    watchFaceStoreRequestInfo.setApiVersion(mWatchFaceApiVersion);
                }

                mBleConnection.queryWatchFaceStoreTagList(watchFaceStoreRequestInfo, new CRPWatchFaceStoreTagCallback() {
                    @Override
                    public void onWatchFaceStoreTagChange(List<CRPWatchFaceStoreTagInfo> list) {
                        Log.d(TAG, "onWatchFaceStoreTagChange: " + list.size());
                        mWatchFaceStoreTagInfoList = list;
                    }

                    @Override
                    public void onError(String s) {

                    }
                });

                break;
            case R.id.btn_query_watch_face_store_list:
                if (mWatchFaceStoreTagInfoList == null || mWatchFaceStoreTagInfoList.isEmpty()) {
                    Log.e(TAG, "mWatchFaceStoreTagInfoList is null!");
                    return;
                }
                CRPWatchFaceStoreRequestInfo watchFaceStoreListRequestInfo = new CRPWatchFaceStoreRequestInfo(mWatchFaceStoreType, mSupportWatchFaceList, mFirmwareVersion, 20, 1, mWatchFaceMaxSize);
                if (mcuPlatform == CRPScanRecordInfo.McuPlatform.PLATFORM_JIELI) {
                    if (mWatchFaceApiVersion < 0 || mWatchFaceFeature < 0) {
                        mBleConnection.queryJieliWatchFaceInfo(new CRPJieliWatchFaceCallback() {
                            @Override
                            public void onWatchFaceInfo(CRPJieliWatchFaceInfo info) {
                                Log.d(TAG, "onWatchFaceInfo: " + info.toString());
                                mWatchFaceApiVersion = info.getApiVersion();
                                mWatchFaceFeature = info.getFeature();
                            }
                        });
                        return;
                    }

                    watchFaceStoreListRequestInfo.setFeature(mWatchFaceFeature);
                    watchFaceStoreListRequestInfo.setApiVersion(mWatchFaceApiVersion);
                }
                mBleConnection.queryWatchFaceStoreList(watchFaceStoreListRequestInfo, mWatchFaceStoreTagInfoList.get(0).getTagId(), new CRPWatchFaceStoreCallback() {
                    @Override
                    public void onWatchFaceStoreChange(CRPWatchFaceStoreInfo info) {
                        Log.d(TAG, "onWatchFaceStoreChange: " + info);
                        mWatchFaceStoreInfo = info;
                    }

                    @Override
                    public void onError(String s) {
                        Log.d(TAG, "onError: " + s);
                    }
                });

                break;
            case R.id.btn_query_watch_face_detail:
                if (mWatchFaceStoreInfo == null) {
                    Log.e(TAG, "mWatchFaceStoreInfo is null!");
                    return;
                }

                List<CRPWatchFaceStoreInfo.WatchFaceBean> watchfaceList = mWatchFaceStoreInfo.getList();
                if (watchfaceList == null || watchfaceList.isEmpty()) {
                    Log.e(TAG, "watchfaceList is null!");
                    return;
                }

                watchfaceId = watchfaceList.get(0).getId();
                CRPWatchFaceDetailsRequestInfo watchFaceDetailsRequestInfo = new CRPWatchFaceDetailsRequestInfo(mWatchFaceStoreType, watchfaceId);
                watchFaceDetailsRequestInfo.setFirmwareVersion(mFirmwareVersion);
                watchFaceDetailsRequestInfo.setMaxSize(mWatchFaceMaxSize);
                if (mcuPlatform == CRPScanRecordInfo.McuPlatform.PLATFORM_JIELI) {
                    if (mWatchFaceApiVersion < 0 || mWatchFaceFeature < 0) {
                        mBleConnection.queryJieliWatchFaceInfo(new CRPJieliWatchFaceCallback() {
                            @Override
                            public void onWatchFaceInfo(CRPJieliWatchFaceInfo info) {
                                Log.d(TAG, "onWatchFaceInfo: " + info.toString());
                                mWatchFaceApiVersion = info.getApiVersion();
                                mWatchFaceFeature = info.getFeature();
                            }
                        });
                        return;
                    }

                    watchFaceDetailsRequestInfo.setFeature(mWatchFaceFeature);
                    watchFaceDetailsRequestInfo.setApiVersion(mWatchFaceApiVersion);
                }

                mBleConnection.queryWatchFaceDetail(watchFaceDetailsRequestInfo, new CRPWatchFaceDetailsCallback() {
                    @Override
                    public void onWatchFaceChange(CRPWatchFaceStoreInfo.WatchFaceBean watchFaceBean) {
                        Log.d(TAG, "onWatchFaceChange: " + watchFaceBean.toString());
                        watchfaceUrl = watchFaceBean.getFile();
                    }

                    @Override
                    public void onNewWatchFaceChange(CRPWatchFaceDetailsInfo info) {
                        Log.d(TAG, "onNewWatchFaceChange: " + info);
                        watchfaceUrl = info.getFile();
                    }

                    @Override
                    public void onError(String s) {
                        Log.e(TAG, "onError: " + s);
                    }
                });
                break;
            case R.id.btn_query_watch_face:
                if (TextUtils.isEmpty(watchfaceUrl)) {
                    Log.e(TAG, "watchfaceUrl is null!");
                    return;
                }

                Log.d(TAG, "watchfaceUrl: " + watchfaceUrl);

                String watchfacePath = new File(getFilesDir(), "moyoung" + File.separator +
                        "watchface" + File.separator +
                        "2023-10-09.bin").getPath();

                FileDownloader.getImpl()
                        .create(watchfaceUrl)
                        .setPath(watchfacePath)
                        .setListener(new FileDownloadListener() {
                            @Override
                            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                            }

                            @Override
                            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                Log.d(TAG, "progress soFarBytes: " + soFarBytes);
                            }

                            @Override
                            protected void completed(BaseDownloadTask task) {
                                Log.d(TAG, "completed path: " + task.getPath());
                                CRPWatchFaceInfo watchFaceInfo = new CRPWatchFaceInfo(new File(task.getPath()), CRPWatchFaceInfo.WacthFaceType.JIELI);
                                mBleConnection.sendWatchFace(watchFaceInfo, new CRPWatchFaceTransListener() {
                                    @Override
                                    public void onInstallStateChange(boolean success) {
                                        Log.d(TAG, "onInstallStateChange: " + success);
                                    }

                                    @Override
                                    public void onTransProgressStarting() {
                                        Log.d(TAG, "onTransProgressStarting");
                                    }

                                    @Override
                                    public void onTransProgressChanged(int percent) {
                                        Log.d(TAG, "onTransProgressChanged: " + percent);
                                    }

                                    @Override
                                    public void onTransCompleted() {
                                        Log.d(TAG, "onTransCompleted");

                                        mBleConnection.sendJieliWatchFaceId(watchfaceId, false);
                                    }

                                    @Override
                                    public void onError(int type) {
                                        Log.d(TAG, "onError: " + type);
                                    }
                                }, 30);
                            }

                            @Override
                            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                            }

                            @Override
                            protected void error(BaseDownloadTask task, Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            protected void warn(BaseDownloadTask task) {

                            }
                        })
                        .start();
                break;
            case R.id.btn_query_sleep_action:
                mBleConnection.querySleepAction(0);
                mBleConnection.querySleepAction(1);
                mBleConnection.querySleepAction(2);
                mBleConnection.querySleepAction(3);
                mBleConnection.querySleepAction(4);
                mBleConnection.querySleepAction(5);
                mBleConnection.querySleepAction(6);
                mBleConnection.querySleepAction(7);
                mBleConnection.querySleepAction(8);
                break;
            case R.id.btn_send_band_ui:
                File file = new File(UI_FILE_PATH);
                Log.d(TAG, "file exist: " + file.exists());
                int startIndex = 0x86000;
                int length = 0xa000;
                int deviceStartIndex = 0x886000;

                CRPTpInfo tpInfo = new CRPTpInfo();
                tpInfo.setFile(file);
                tpInfo.setDeviceStartIndex(deviceStartIndex);
                tpInfo.setFirmwareVersion("MOY-NAA3-2.0.0");
                tpInfo.setLength(length);
                tpInfo.setStartIndex(startIndex);

                break;
            case R.id.btn_query_quick_contacts:
                mBleConnection.checkSupportQuickContact(new CRPContactConfigCallback() {
                    @Override
                    public void onContactConfig(CRPContactConfigInfo info) {
                        mQuickContactConfigInfo = info;
                    }
                });
                break;
            case R.id.btn_send_quick_contacts:
                if (mQuickContactConfigInfo == null || !mQuickContactConfigInfo.isSupported()) {
                    return;
                }

                int avatarHeight = mQuickContactConfigInfo.getHeight();
                int avatarWidth = mQuickContactConfigInfo.getWidth();

                Log.d(TAG, "avatarHeight: " + avatarHeight);
                Log.d(TAG, "avatarWidth: " + avatarWidth);

                for (int i = 0; i < mQuickContactConfigInfo.getCount(); i++) {
                    CRPContactInfo contactInfo = new CRPContactInfo();
                    contactInfo.setAddress(0);
                    contactInfo.setHeight(avatarHeight);
                    contactInfo.setWidth(avatarWidth);
                    contactInfo.setId(i);
                    contactInfo.setNumber("11113333");
                    contactInfo.setName("AAA" + i);
                    mBleConnection.sendContact(contactInfo);
                }

                BitmapFactory.Options avatarOptions = new BitmapFactory.Options();
                avatarOptions.inScaled = false;

                Bitmap avatarBitmap = BitmapFactory.decodeResource(
                        getResources(), R.drawable.abbreviated, avatarOptions);
                avatarBitmap = changeBitmapSize(avatarBitmap, avatarWidth, avatarHeight);

                mBleConnection.sendContactAvatar(1, avatarBitmap, 30, new CRPFileTransListener() {
                    @Override
                    public void onTransProgressStarting() {

                    }

                    @Override
                    public void onTransProgressChanged(int percent) {
                        Log.d(TAG, "onTransProgressChanged: " + percent);
                    }

                    @Override
                    public void onTransCompleted() {
                        Log.d(TAG, "onTransCompleted");
                    }

                    @Override
                    public void onError(int type) {
                        Log.d(TAG, "onError: " + type);
                    }
                });
                break;
            case R.id.btn_delete_quick_contacts:
                // Delete a contact
                mBleConnection.deleteContact(0);
                mBleConnection.deleteContactAvatar(0);
                // Clear contact
                mBleConnection.clearContact();
                break;
            case R.id.btn_enable_hrv:
                mBleConnection.enableHrvMeasure(1);
                break;
            case R.id.btn_disable_hrv:
                mBleConnection.disableHrvMeasure();
                break;
            case R.id.btn_query_hrv_measure_interval:
                mBleConnection.queryHrvMeasureInterval();
                break;
            case R.id.btn_query_hrv_measure_count:
//                mBleConnection.queryHrvMeasureCount(0);
                mBleConnection.startMeasureHrv();
                break;
            case R.id.btn_query_hrv_measure_result:
//                mBleConnection.queryHrv(0, 1);
                mBleConnection.stopMeasureHrv();
                break;
            case R.id.btn_enable_continue_blood_pressure:
                mBleConnection.enableContinueBloodPressure();
                break;
            case R.id.btn_disable_continue_blood_pressure:
                mBleConnection.disableContinueBloodPressure();
                break;
            case R.id.btn_query_continue_blood_pressure_state:
                mBleConnection.queryContinueBloodPressureState();
                break;
            case R.id.btn_query_continue_blood_pressure:
                mBleConnection.queryLast24HourBloodPressure();
                break;
            case R.id.btn_enable_continue_blood_oxygen:
                mBleConnection.enableContinueBloodOxygen();
                break;
            case R.id.btn_disable_continue_blood_oxygen:
                mBleConnection.disableContinueBloodOxygen();
                break;
            case R.id.btn_query_continue_blood_oxygen_state:
                mBleConnection.queryContinueBloodOxygenState();
                break;
            case R.id.btn_query_continue_blood_oxygen:
                mBleConnection.queryLast24HourBloodOxygen();
                break;
            case R.id.btn_enable_continue_temp:
                mBleConnection.enableContinueTemp();
//                mBleConnection.setNewHrvListener(new CRPNewHrvChangeListener() {
//                    @Override
//                    public void onSupportHrv(boolean supported) {
//
//                    }
//
//                    @Override
//                    public void onHrv(int hrv) {
//                        Log.d(TAG, "onHrv: " + hrv);
//                    }
//
//                    @Override
//                    public void onHistoryHrv(List<CRPHistoryHrvInfo> list) {
//                        for (CRPHistoryHrvInfo info : list) {
//                            Log.d(TAG, "onHrv: " + info.getDate().toString());
//                        }
//                    }
//                });
//                mBleConnection.querySupportNewHrv();
                break;
            case R.id.btn_disable_continue_temp:
                mBleConnection.disableContinueTemp();
//                mBleConnection.startMeasureNewHrv();
                break;
            case R.id.btn_query_continue_temp_state:
                mBleConnection.queryContinueTempState();
//                mBleConnection.stopMeasureNewHrv();
                break;
            case R.id.btn_query_continue_temp:
                mBleConnection.queryLast24HourTemp();
//                mBleConnection.queryHistoryNewHrv();
                break;
            case R.id.btn_start_measure_breath_rate:
                mBleConnection.startMeatureBreathRate();
                break;
            case R.id.btn_stop_measure_breath_rate:
                mBleConnection.stopMeatureBreathRate();
                break;
            case R.id.btn_query_history_breath_rate:
                mBleConnection.queryHistoryBreathRate();
                break;
            case R.id.btn_enable_timing_breath_rate:
                mBleConnection.enableTimingBreathRate();
                break;
            case R.id.btn_disable_timing_breath_rate:
                mBleConnection.disableTimingBreathRate();
                break;
            case R.id.btn_query_timing_breath_rate:
                mBleConnection.queryTimingBreathRate(CRPHistoryDay.TODAY);
                break;
            case R.id.btn_query_timing_breath_rate_state:
                mBleConnection.queryTimingBreathRateState();
                break;
            case R.id.btn_query_quick_responses_count:
                mBleConnection.queryQuickResponsesCount();
                break;
            case R.id.btn_enable_quick_responses:
                mBleConnection.enableQuickResponses();
                break;
            case R.id.btn_disable_quick_responses:
                mBleConnection.disableQuickResponses();
                break;
            case R.id.btn_query_quick_responses:
                mBleConnection.queryQuickResponses((byte) 1);
                break;
            case R.id.btn_send_quick_responses:
                CRPQuickResponsesDetailInfo quickResponsesDetailInfo = new CRPQuickResponsesDetailInfo((byte) 1, "稍后再打给你");
                mBleConnection.sendQuickResponses(quickResponsesDetailInfo);
                break;
            case R.id.btn_query_support_stock:
                mBleConnection.querySupportStock();
                break;
            case R.id.btn_send_stock:
                CRPStockInfo stockInfo = new CRPStockInfo();
                stockInfo.setId((byte) 1);
                stockInfo.setAbbreviation("AMZN");
                stockInfo.setCode("000000");
                stockInfo.setCurrency("U.S");
                stockInfo.setExchange("1.0");
                mBleConnection.sendStock(stockInfo);

                CRPStockInfo stockInfo1 = new CRPStockInfo();
                stockInfo1.setId((byte) 2);
                stockInfo1.setAbbreviation("AM");
                stockInfo1.setCode("000001");
                stockInfo1.setCurrency("U.S");
                stockInfo1.setExchange("1.1");
                mBleConnection.sendStock(stockInfo1);
                break;
            case R.id.btn_send_stock_price:
                CRPStockPriceInfo stockPriceInfo = new CRPStockPriceInfo();
                stockPriceInfo.setId((byte) 1);
                stockPriceInfo.setMarketValue(10000000000L);
                stockPriceInfo.setHighestPrice(100f);
                stockPriceInfo.setLowestPrice(10f);
                stockPriceInfo.setChange(898777789f);
                stockPriceInfo.setAverage(9980008l);
                stockPriceInfo.setEnable(true);
                stockPriceInfo.setChangePercent(1);
                stockPriceInfo.setOpeningPrice(99887898f);
                stockPriceInfo.setPe(23);
                stockPriceInfo.setPrice(87f);
                stockPriceInfo.setTurnover(123398676);
                stockPriceInfo.setYearHighestPrice(120f);
                stockPriceInfo.setYearLowestPrice(9f);
                mBleConnection.sendStockPrice(stockPriceInfo);

                CRPStockPriceInfo stockPriceInfo1 = new CRPStockPriceInfo();
                stockPriceInfo1.setId((byte) 2);
                stockPriceInfo1.setMarketValue(10000002300L);
                stockPriceInfo1.setHighestPrice(100f);
                stockPriceInfo1.setLowestPrice(10f);
                stockPriceInfo1.setChange(898777789f);
                stockPriceInfo1.setAverage(9980008l);
                stockPriceInfo1.setEnable(true);
                stockPriceInfo1.setChangePercent(1);
                stockPriceInfo1.setOpeningPrice(99887898f);
                stockPriceInfo1.setPe(23);
                stockPriceInfo1.setPrice(87f);
                stockPriceInfo1.setTurnover(123398676);
                stockPriceInfo1.setYearHighestPrice(120f);
                stockPriceInfo1.setYearLowestPrice(9f);
                mBleConnection.sendStockPrice(stockPriceInfo1);
                break;
            case R.id.btn_delete_stock:
                mBleConnection.deleteStock((byte) 1);
                break;
            case R.id.btn_clear_stock:
                mBleConnection.clearStock();
                break;
            case R.id.btn_reset_stock_list:
                byte[] stockArray = {2, 1};
                mBleConnection.resetStockList(stockArray);
                break;
            default:
                break;
        }
    }

    private void sendEpoFile(CRPEpoType type) {
        Log.d(TAG, "sendEpoFile: " + type);
        String epoFileName = null;
        switch (type) {
            case GPS:
                epoFileName = "EPO_GR_3_1.DAT";
                break;
            case GALILEO:
                epoFileName = "EPO_GAL_3.DAT";
                break;
            case BEIDOU:
                epoFileName = "EPO_BDS_3.DAT";
                break;
        }

        String EPO_FILE_PATH = getFilesDir() + File.separator + epoFileName;
        Log.d(TAG, "sendEpoFile EPO_FILE_PATH: " + EPO_FILE_PATH);
        mBleConnection.sendEpoFile(new File(EPO_FILE_PATH), CRPEpoType.GPS, new CRPFileTransListener() {
            @Override
            public void onTransProgressStarting() {
                Log.d(TAG, "onTransProgressStarting");
            }

            @Override
            public void onTransProgressChanged(int percent) {
                Log.d(TAG, "onTransProgressChanged: " + percent);
            }

            @Override
            public void onTransCompleted() {
                Log.d(TAG, "onTransCompleted");
            }

            @Override
            public void onError(int type) {
                Log.d(TAG, "onError: " + type);
            }
        });
    }

    public Bitmap changeBitmapSize(Bitmap bitmap, int width, int height) {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        float scaleWidth = (float) width / bitmapWidth;
        float scaleHeight = (float) height / bitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        return Bitmap.createBitmap(bitmap, 0, 0,
                bitmapWidth, bitmapHeight, matrix, false);
    }

    private CRPStockChangeListener mStockChangeListener = new CRPStockChangeListener() {
        @Override
        public void onSupportStockCount(int i) {
            showToast("onSupportStockCount：" + i);
        }

        @Override
        public void onUpdateStockChange() {
            // Update all stock information to your watch
        }
    };

    private CRPQuickResponsesChangeListener mQuickResponsesChangeListener = new CRPQuickResponsesChangeListener() {
        @Override
        public void onQuickResponsesCount(CRPQuickResponsesCountInfo info) {
            showToast("onQuickResponsesCount：" + info.toString());
        }

        @Override
        public void onQuickResponsesDetail(CRPQuickResponsesDetailInfo info) {
            showToast("onQuickResponsesDetail：" + info.toString());
        }

        @Override
        public void onSendSms(String msg) {
            showToast("onSendSms：" + msg);
        }
    };

    private CRPBreathRateChangeListener mBreathRateChangeListener = new CRPBreathRateChangeListener() {
        @Override
        public void onBreathRate(int breathRate) {
            showToast("onBreathRate：" + breathRate);
        }

        @Override
        public void onHistoryBreathRate(List<CRPHistoryBreathRateInfo> list) {
            showToast("onHistoryBreathRate：" + list.toString());
        }

        @Override
        public void onTimingBreathRateState(boolean enable) {
            showToast("onTimingBreathRateState：" + enable);
        }

        @Override
        public void onTimingBreathRate(CRPBreathRateInfo info) {
            showToast("onTimingBreathRate：" + info);
        }
    };

    private void showToast(String nsg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DeviceActivity.this, nsg, Toast.LENGTH_LONG).show();
            }
        });
    }

    private CRPHrvChangeListener mHrvChangeListener = new CRPHrvChangeListener() {

        @Override
        public void onRealRri(int rri, int activeLevel) {
            Log.d(TAG, "onRealRri rri: " + rri);
            Log.d(TAG, "onRealRri activeLevel: " + activeLevel);
        }

        @Override
        public void onMeasureInterval(int interval) {
            Log.d(TAG, "onMeasureInterval: " + interval);
        }

        @Override
        public void onMeasureCount(int dayIndex, int count) {
            Log.d(TAG, "onMeasureCount: " + dayIndex + "-" + count);
        }

        @Override
        public void onHrvChange(CRPHrvInfo info) {
            Log.d(TAG, "onHrvChange: " + info.getRriList().toString());
        }

        @Override
        public void onMeasureResult(int dayIndex, int index, CRPHrvInfo info) {
            Log.d(TAG, "onMeasureResult: " + dayIndex + "-" + index);
            Log.d(TAG, "onMeasureResult: " + info.getRriList().toString());
        }
    };

    private CRPContactConfigInfo mQuickContactConfigInfo;

    private CRPContactListener mContactListener = new CRPContactListener() {
        @Override
        public void onSavedSuccess(int id) {
            Log.d(TAG, "onSavedSuccess: " + id);
        }

        @Override
        public void onSavedFail(int id) {
            Log.d(TAG, "onSavedFail: " + id);
        }
    };


    CRPTempChangeListener mTempChangeListener = new CRPTempChangeListener() {
        @Override
        public void onContinueState(boolean state) {
            Log.d(TAG, "onContinueState: " + state);
        }

        @Override
        public void onMeasureTemp(float temp) {
            Log.d(TAG, "onMeasureTemp: " + temp);
        }

        @Override
        public void onMeasureState(boolean state) {
            Log.d(TAG, "onTimingState: " + state);
        }

        @Override
        public void onContinueTemp(CRPTempInfo info) {
            Log.d(TAG, "onTimingMeasureTemp: " + info.getType());
            Log.d(TAG, "onTimingMeasureTemp: " + info.getTempList().toString());
        }
    };

    CRPMovementStateListener mMovementStateListener = new CRPMovementStateListener() {
        @Override
        public void onMeasureState(int state) {
            Log.d(TAG, "onMeasureState: " + state);
        }

        @Override
        public void onMeasuring(int i) {

        }

        @Override
        public void onStartSuccess(int i) {
            showToast("onStartSuccess:" + i);
        }

        @Override
        public void onStartFailed() {

        }
    };

    private final List<Integer> trainingList = new ArrayList<>();

    CRPTrainingChangeListener mTrainingChangeListener = new CRPTrainingChangeListener() {
        @Override
        public void onHistoryTrainingChange(List<CRPHistoryTrainingInfo> list) {
            trainingList.clear();
            for (int i = 0; i < list.size(); i++) {
                CRPHistoryTrainingInfo info = list.get(i);
                trainingList.add(info.getId());
            }

            if (!trainingList.isEmpty()) {
                queryTrainingDetail();
            }
        }

        @Override
        public void onTrainingChange(CRPTrainingInfo info) {
            Log.d(TAG, "onTrainingChange: " + info);

            queryTrainingDetail();
        }

        @Override
        public void onRealtimeTrainingChange(CRPTrainingRealtimeInfo crpTrainingRealtimeInfo) {

        }

        @Override
        public void onPerformanceInsightsChange(CRPPerformanceInsightsInfo info) {
            Log.d(TAG, "onPerformanceInsightsChange: " + info);
        }
    };

    private void queryTrainingDetail() {
        if (!this.trainingList.isEmpty()) {
            Integer trainingId = this.trainingList.remove(0);
           mBleConnection.queryTraining(trainingId);
        }
    }


    CRPSleepActionChangeListener mSleepActionChangeListener = new CRPSleepActionChangeListener() {
        @Override
        public void onSleepActionChange(CRPSleepActionInfo info) {
            int hour = info.getHour();
            Log.d(TAG, "onSleepActionChange Hour: " + hour);
            List<Integer> actionList = info.getActionList();
            for (Integer integer : actionList) {
                Log.d(TAG, "onSleepActionChange action: " + integer);
            }
        }
    };


    CRPStepsCategoryChangeListener mStepsCategoryChangeListener = new CRPStepsCategoryChangeListener() {
        @Override
        public void onStepsCategoryChange(CRPStepsCategoryInfo info) {
            List<Integer> stepsList = info.getStepsList();
            Log.d(TAG, "onStepsCategoryChange: " + stepsList);
        }
    };

    CRPStepChangeListener mStepChangeListener = new CRPStepChangeListener() {
        @Override
        public void onStepChange(CRPStepInfo info) {
            Log.d(TAG, "onStepChange: " + info.toString());
            updateStepInfo(info.getSteps(), info.getDistance(), info.getCalories());
            showToast(info.toString());
        }

        @Override
        public void onHistoryStepChange(CRPHistoryDay historyDay, CRPStepInfo info) {
            Log.d(TAG, "onPastStepChange: " + historyDay.getValue() + " - " + info.toString());
        }

    };

    CRPSleepChangeListener mSleepChangeListener = new CRPSleepChangeListener() {
        @Override
        public void onSleepChange(CRPSleepInfo info) {
            List<CRPSleepInfo.DetailBean> details = info.getDetails();
            if (details == null) {
                return;
            }
            Log.d(TAG, "onSleepChange: " + info);
            updateSleepInfo(info.getRestfulTime(), info.getLightTime());
        }

        @Override
        public void onHistorySleepChange(CRPHistoryDay historyDay, CRPSleepInfo info) {
            Log.d(TAG, "onHistorySleepChange: " + historyDay + " - " + info.toString());
        }

        @Override
        public void onHistoryNapSleepChange(CRPHistoryDay historyDay, List<CRPNapSleepInfo> list) {
            Log.d(TAG, "onHistoryNapSleepChange: " + historyDay + " - " + list.size());
        }
    };

    CRPHeartRateChangeListener mHeartRateChangListener = new CRPHeartRateChangeListener() {
        @Override
        public void onMeasuring(int rate) {
            Log.d(TAG, "onMeasuring: " + rate);
            updateTextView(tvHeartRate, String.format(getString(R.string.heart_rate), rate));
        }

        @Override
        public void onOnceMeasureComplete(int rate) {
            Log.d(TAG, "onOnceMeasureComplete: " + rate);
        }

        @Override
        public void onHistoryHeartRate(List<CRPHistoryHeartRateInfo> list) {
            for (CRPHistoryHeartRateInfo info : list) {
                Log.d(TAG, "onHistoryHeartRate: " + info.getDate());
                Log.d(TAG, "onHistoryHeartRate: " + info.getHr());
            }
        }

        @Override
        public void onMeasureComplete(CRPHistoryDynamicRateType type, CRPHeartRateInfo info) {
            Log.d(TAG, "onMeasureComplete type: " + type.getValue());
            Log.d(TAG, "onMeasureComplete hr list: " + info.getHeartRateList().toString());

            mBleConnection.queryMovementHeartRate();
        }

        @Override
        public void on24HourMeasureResult(CRPHeartRateInfo info) {
            Log.d(TAG, "on24HourMeasureResult: " + info.toString());
        }

        @Override
        public void onMovementMeasureResult(List<CRPMovementHeartRateInfo> list) {
            for (CRPMovementHeartRateInfo info : list) {
                if (info != null) {
                    Log.d(TAG, "onMovementMeasureResult: " + info.getStartTime());
                }
            }
        }

    };

    CRPBloodPressureChangeListener mBloodPressureChangeListener = new CRPBloodPressureChangeListener() {
        @Override
        public void onContinueState(boolean state) {
            Log.d(TAG, "onContinueState: " + state);
        }

        @Override
        public void onBloodPressureChange(int sbp, int dbp) {
            Log.d(TAG, "sbp: " + sbp + ",dbp: " + dbp);
            updateTextView(tvBloodPressure,
                    String.format(getString(R.string.blood_pressure), sbp, dbp));
        }

        @Override
        public void onHistoryBloodPressure(List<CRPHistoryBloodPressureInfo> list) {
            for (CRPHistoryBloodPressureInfo info : list) {
                Log.d(TAG, "onHistoryBloodPressure: " + info.getDate());
                Log.d(TAG, "onHistoryBloodPressure: " + info.getSbp());
                Log.d(TAG, "onHistoryBloodPressure: " + info.getDbp());
            }
        }

        @Override
        public void onContinueBloodPressure(CRPBloodPressureInfo info) {
            if (info != null) {
                Log.d(TAG, "onContinueBloodPressure: " + info.getType());
                int emptCount = 0;
                for (CRPBloodPressureInfo.BpBean bean : info.getList()) {
                    if (bean == null) {
                        emptCount++;
                    }
                }
                Log.d(TAG, "onContinueBloodPressure size: " + emptCount);
            }
        }
    };

    CRPBloodOxygenChangeListener mBloodOxygenChangeListener = new CRPBloodOxygenChangeListener() {

        @Override
        public void onContinueState(boolean state) {
            Log.d(TAG, "onContinueState: " + state);
        }

        @Override
        public void onTimingMeasure(int interval) {
            Log.d(TAG, "onTimingMeasure: " + interval);
        }

        @Override
        public void onBloodOxygen(int bloodOxygen) {
            updateTextView(tvBloodOxygen,
                    String.format(getString(R.string.blood_oxygen), bloodOxygen));
        }

        @Override
        public void onHistoryBloodOxygen(List<CRPHistoryBloodOxygenInfo> list) {
            for (CRPHistoryBloodOxygenInfo info : list) {
                Log.d(TAG, "onHistoryBloodOxygen: " + info.getDate());
                Log.d(TAG, "onHistoryBloodOxygen: " + info.getBo());
            }
        }

        @Override
        public void onContinueBloodOxygen(CRPBloodOxygenInfo info) {
            if (info != null) {
                Log.d(TAG, "onContinueBloodOxygen: " + info.getType());
                Log.d(TAG, "onContinueBloodOxygen: " + info.getList().toString());
            }
        }
    };

    CRPBleECGChangeListener mECGChangeListener = new CRPBleECGChangeListener() {
        @Override
        public void onECGChange(int[] ecg) {
            for (int i = 0; i < ecg.length; i++) {
                Log.d(TAG, "ecg: " + ecg[i]);
            }
        }

        @Override
        public void onMeasureComplete() {
            Log.d(TAG, "onMeasureComplete");
        }

        @Override
        public void onTransCpmplete(Date date) {
            Log.d(TAG, "onTransCpmplete");
        }

        @Override
        public void onCancel() {
            Log.d(TAG, "onCancel");
        }

        @Override
        public void onFail() {
            Log.d(TAG, "onFail");
        }
    };


    private void queryLastMeasureECGData() {
        this.mBleConnection.queryLastMeasureECGData();
    }


    CRPFindPhoneListener mFindPhoneListener = new CRPFindPhoneListener() {
        @Override
        public void onFindPhone() {
            Log.d(TAG, "onFindPhone");
        }

        @Override
        public void onFindPhoneComplete() {
            Log.d(TAG, "onFindPhoneComplete");
        }
    };

    CRPBleFirmwareUpgradeListener mFirmwareUpgradeListener = new CRPBleFirmwareUpgradeListener() {
        @Override
        public void onFirmwareDownloadStarting() {
            Log.d(TAG, "onFirmwareDownloadStarting");
            updateTextView(tvUpgradeState, getString(R.string.dfu_status_download_starting));
        }

        @Override
        public void onFirmwareDownloadComplete() {
            Log.d(TAG, "onFirmwareDownloadComplete");
            updateTextView(tvUpgradeState, getString(R.string.dfu_status_download_complete));
        }

        @Override
        public void onUpgradeProgressStarting(boolean recoverable) {
            Log.d(TAG, "onUpgradeProgressStarting: " + recoverable);
            updateTextView(tvUpgradeState, getString(R.string.dfu_status_starting));
        }

        @Override
        public void onUpgradeProgressChanged(int percent, float speed) {
            Log.d(TAG, "onUpgradeProgressChanged: " + percent);
            String status = String.format(getString(R.string.dfu_status_uploading_part), percent);
            updateTextView(tvUpgradeState, status);
        }

        @Override
        public void onUpgradeCompleted() {
            Log.d(TAG, "onUpgradeCompleted");
            updateTextView(tvUpgradeState, getString(R.string.dfu_status_completed));
            isUpgrade = true;
        }

        @Override
        public void onUpgradeAborted() {
            Log.d(TAG, "onUpgradeAborted");
            updateTextView(tvUpgradeState, getString(R.string.dfu_status_aborted));
        }

        @Override
        public void onError(int errorType, String message) {
            Log.d(TAG, "onError: " + errorType);
            updateTextView(tvUpgradeState, message);
//            mBleConnection.abortFirmwareUpgrade();
        }
    };


    void updateStepInfo(int step, int distance, int calories) {
        updateTextView(tvStep, String.format(getString(R.string.step), step));
        updateTextView(tvDistance, String.format(getString(R.string.distance), distance));
        updateTextView(tvCalorie, String.format(getString(R.string.calorie), calories));
    }

    void updateSleepInfo(int restful, int light) {
        updateTextView(tvRestful, String.format(getString(R.string.restful), restful));
        updateTextView(tvLight, String.format(getString(R.string.light), light));
    }

    void updateConnectState(final int state) {
        if (state < 0) {
            return;
        }
        updateTextView(tvConnectState, getString(state));
    }

    void updateTextView(final TextView view, final String con) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setText(con);
            }
        });
    }

}
