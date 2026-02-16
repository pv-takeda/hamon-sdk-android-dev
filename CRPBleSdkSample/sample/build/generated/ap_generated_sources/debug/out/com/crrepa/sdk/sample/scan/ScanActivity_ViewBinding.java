// Generated code from Butter Knife. Do not modify!
package com.crrepa.sdk.sample.scan;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.crrepa.sdk.sample.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScanActivity_ViewBinding implements Unbinder {
  private ScanActivity target;

  private View view7f0800a3;

  @UiThread
  public ScanActivity_ViewBinding(ScanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScanActivity_ViewBinding(final ScanActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_scan_toggle, "field 'scanToggleBtn' and method 'onViewClicked'");
    target.scanToggleBtn = Utils.castView(view, R.id.btn_scan_toggle, "field 'scanToggleBtn'", Button.class);
    view7f0800a3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.scanResults = Utils.findRequiredViewAsType(source, R.id.scan_results, "field 'scanResults'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.scanToggleBtn = null;
    target.scanResults = null;

    view7f0800a3.setOnClickListener(null);
    view7f0800a3 = null;
  }
}
