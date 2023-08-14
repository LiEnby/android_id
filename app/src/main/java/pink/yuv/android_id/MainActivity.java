package pink.yuv.android_id;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView androidIdTextView = (TextView)findViewById(R.id.textView);
        String android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        System.out.println("android_id: "+android_id);
        androidIdTextView.setText("android_id: "+android_id);
    }
}
