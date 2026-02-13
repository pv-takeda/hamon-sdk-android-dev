// Generated code from Butter Knife. Do not modify!
package com.crrepa.sdk.sample.scan;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScanResultsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ScanResultsAdapter.ViewHolder target;

  @UiThread
  public ScanResultsAdapter$ViewHolder_ViewBinding(ScanResultsAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.line1 = Utils.findRequiredViewAsType(source, android.R.id.text1, "field 'line1'", TextView.class);
    target.line2 = Utils.findRequiredViewAsType(source, android.R.id.text2, "field 'line2'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScanResultsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.line1 = null;
    target.line2 = null;
  }
}
