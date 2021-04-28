package edu.hrbeu.ConfigWidget;


import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ConfigActivity  extends Activity {

    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setResult(RESULT_CANCELED);
        setContentView(R.layout.widget_config);

        findViewById(R.id.btn_change).setOnClickListener(mOnClickListener);
 
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            final Context context = ConfigActivity.this;

            int textColor = 0;
            RadioButton rbt0 = (RadioButton)findViewById(R.id.radio0);
            RadioButton rbt1 = (RadioButton)findViewById(R.id.radio1);
            RadioButton rbt2 = (RadioButton)findViewById(R.id.radio2);
            if (rbt0.isChecked()) textColor = android.graphics.Color.RED;
            if (rbt1.isChecked()) textColor = android.graphics.Color.WHITE;
            if (rbt2.isChecked()) textColor = android.graphics.Color.BLACK;
            
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            WidgetProvider.updateTextColor(context, appWidgetManager, mAppWidgetId,textColor);

            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    };

    }


