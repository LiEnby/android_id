package pink.yuv.android_id;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.widget.TextView;
import org.jetbrains.annotations.Nullable;

public class MainActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView androidIdTextView = (TextView)findViewById(R.id.androidId);
        String android_id = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
        System.out.println("android_id: "+android_id);
        androidIdTextView.setText("android_id: "+android_id);

        String psmAppId = "app not installed";

        try{
            ApplicationInfo psmAppInfo = this.getApplicationContext().getPackageManager().getApplicationInfo("com.playstation.psstore", 0);
            if(psmAppInfo != null)
                psmAppId = String.valueOf(psmAppInfo.uid);
        }
        catch (PackageManager.NameNotFoundException e) { };

        TextView psmAppIdTextView = (TextView)findViewById(R.id.psmAppId);
        System.out.println("psstore_uid: "+psmAppId);
        psmAppIdTextView.setText("psstore_uid: "+psmAppId);
    }
}
