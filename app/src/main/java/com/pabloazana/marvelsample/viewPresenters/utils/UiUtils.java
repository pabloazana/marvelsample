package com.pabloazana.marvelsample.viewPresenters.utils;

import android.view.View;

/**
 * Created by pablo-azana on 14/05/15.
 */

public class UiUtils {

    public static void setAccessibilityIgnore(View view) {
        view.setClickable(false);
        view.setFocusable(false);
        view.setContentDescription("");
        view.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
    }
}
