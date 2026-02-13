package com.crrepa.sdk.sample.scan;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crrepa.ble.CRPBleClient;
import com.crrepa.ble.scan.CRPScanRecordParser;
import com.crrepa.ble.scan.bean.CRPScanDevice;
import com.crrepa.ble.scan.bean.CRPScanRecordInfo;
import com.crrepa.ble.scan.callback.CRPScanCallback;
import com.crrepa.sdk.sample.PermissionUtils;
import com.crrepa.sdk.sample.R;
import com.crrepa.sdk.sample.SampleApplication;
import com.crrepa.sdk.sample.device.DeviceActivity;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScanActivity extends AppCompatActivity {
    private static final String TAG = "ScanActivity";
    private static final int SCAN_PERIOD = 10 * 1000;

    private static final int REQUEST_UPDATEBANDCONFIG = 4;
    private static final String[] LOCATION_PERMISSION_UPDATEBANDCONFIG = new String[]{
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION"};

    private static final String[] BLUETOOTH_PERMISSION_UPDATEBANDCONFIG = new String[]{
            "android.permission.BLUETOOTH_CONNECT",
            "android.permission.BLUETOOTH_SCAN"};

    @BindView(R.id.btn_scan_toggle)
    Button scanToggleBtn;
    @BindView(R.id.scan_results)
    RecyclerView scanResults;

    private CRPBleClient mBleClient;
    private ScanResultsAdapter mResultsAdapter;
    private boolean mScanState = false;

    private static final String UPGRADE_APP_FILE_PATH = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "crrepa" + File.separator + "app_band-hs.bin";
    private static final String UPGRADE_USER_FILE_PATH = Environment.getExternalStorageDirectory().getPath()
            + File.separator + "crrepa" + File.separator + "usr.bin";
    private static final String USER_START_ADDRESS = "23000";
    private static final String BAND_ADDRESS = "FB:09:C5:C7:1A:90";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);
        mBleClient = SampleApplication.getBleClient(this);

        configureResultList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cancelScan();
    }

    @SuppressLint("MissingPermission")
    @OnClick({R.id.btn_scan_toggle})
    public void onViewClicked(View view) {
        if (requestPermissions()) {
            return;
        }

        if (!mBleClient.isBluetoothEnable()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBtIntent);
            return;
        }

        switch (view.getId()) {
            case R.id.btn_scan_toggle:
                if (mScanState) {
                    cancelScan();
                } else {
                    startScan();
                }
                break;
        }

    }

    private void startScan() {
        boolean success = mBleClient.scanDevice(new CRPScanCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onScanning(final CRPScanDevice device) {
                String name = device.getDevice().getName();
                Log.d(TAG, "name: " + name);
                Log.d(TAG, "address: " + device.getDevice().getAddress());
                if (TextUtils.isEmpty(name)) {
                    return;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mResultsAdapter.addScanResult(device);
                    }
                });
            }

            @Override
            public void onScanComplete(List<CRPScanDevice> results) {
                if (mScanState) {
                    mScanState = false;
                    updateButtonUIState();
                }
            }
        }, SCAN_PERIOD);
        if (success) {
            mScanState = true;
            updateButtonUIState();
            mResultsAdapter.clearScanResults();
        }
    }

    private void cancelScan() {
        mBleClient.cancelScan();
    }


    private void configureResultList() {
        scanResults.setHasFixedSize(true);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        scanResults.setLayoutManager(recyclerLayoutManager);
        mResultsAdapter = new ScanResultsAdapter();
        scanResults.setAdapter(mResultsAdapter);
        mResultsAdapter.setOnAdapterItemClickListener(new ScanResultsAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterViewClick(View view) {
                final int childAdapterPosition = scanResults.getChildAdapterPosition(view);
                final CRPScanDevice itemAtPosition = mResultsAdapter.getItemAtPosition(childAdapterPosition);
                onAdapterItemClick(itemAtPosition);
            }
        });
    }


    private void onAdapterItemClick(CRPScanDevice scanResults) {
        final String address = scanResults.getDevice().getAddress();
        mBleClient.cancelScan();

        final Intent intent = new Intent(this, DeviceActivity.class);
        intent.putExtra(DeviceActivity.DEVICE_ADDRESS, address);
        CRPScanRecordInfo scanRecordInfo = CRPScanRecordParser.parseScanRecord(scanResults.getScanRecord());
        if (scanRecordInfo != null) {
            CRPScanRecordInfo.McuPlatform platform = scanRecordInfo.getPlatform();
            if (platform != null) {
                intent.putExtra(DeviceActivity.DEVICE_MCU_PLATFORM, platform.getValue());
                startActivity(intent);
                return;
            }
        }

        Toast.makeText(this, "No platform found", Toast.LENGTH_SHORT).show();
    }


    private void updateButtonUIState() {
        scanToggleBtn.setText(mScanState ? R.string.stop_scan : R.string.start_scan);
    }

    boolean requestPermissions() {
        if (!PermissionUtils.hasSelfPermissions(this, LOCATION_PERMISSION_UPDATEBANDCONFIG)) {
            ActivityCompat.requestPermissions(
                    this, LOCATION_PERMISSION_UPDATEBANDCONFIG, REQUEST_UPDATEBANDCONFIG);
            return true;
        }

        if (Build.VERSION_CODES.S <= Build.VERSION.SDK_INT && !PermissionUtils.hasSelfPermissions(this, BLUETOOTH_PERMISSION_UPDATEBANDCONFIG)) {
            ActivityCompat.requestPermissions(
                    this, BLUETOOTH_PERMISSION_UPDATEBANDCONFIG, REQUEST_UPDATEBANDCONFIG);
            return true;
        }

        return false;
    }
}
