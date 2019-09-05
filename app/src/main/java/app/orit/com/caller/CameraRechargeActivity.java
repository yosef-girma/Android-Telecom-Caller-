package app.orit.com.caller;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.vision.CameraSource;

public class CameraRechargeActivity extends AppCompatActivity {


    private SurfaceView cameraView;
    private EditText hiddenTextInput;
    private CameraSource cameraSource;
    private ImageButton flashBtn;
    boolean isFlashLightOn =false;
    Camera camera;
    Camera.Parameters parameter;
    boolean hasDeviceFlash;
    final int RequestCameraPermissionID = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_recharge);

    }
}
