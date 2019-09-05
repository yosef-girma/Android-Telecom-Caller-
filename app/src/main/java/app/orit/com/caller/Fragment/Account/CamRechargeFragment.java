package app.orit.com.caller.Fragment.Account;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;

import app.orit.com.caller.R;


public class CamRechargeFragment extends Fragment implements View.OnClickListener {


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_camrecharge, container, false);
        cameraView = (SurfaceView) view.findViewById(R.id.surface_view);
        hiddenTextInput = (EditText) view.findViewById(R.id.hidden_text);
        flashBtn = (ImageButton)view.findViewById(R.id.flash_btn);


        hasDeviceFlash =getActivity().getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);

        flashBtn.setOnClickListener(this);


        TextRecognizer textRecognizer = new TextRecognizer.Builder(getActivity().getApplicationContext()).build();

        if (!textRecognizer.isOperational()) {
            Log.w("MainActivity", "Detector dependencies are not yet available");
        } else {

            cameraSource = new CameraSource.Builder(getActivity().getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();
            cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {

                    if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.CAMERA},
                                RequestCameraPermissionID);
                        return;
                    }


                    try {

                        cameraSource.start(cameraView.getHolder());

                    }catch (Exception e)
                    {

                    }


                }

                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    cameraSource.stop();
                }
            });

            textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {

                    final SparseArray<TextBlock> items = detections.getDetectedItems();
                    if(items.size() != 0)
                    {
                        hiddenTextInput.post(new Runnable() {
                            @Override
                            public void run() {
                                StringBuilder stringBuilder = new StringBuilder();
                                for(int i =0;i<items.size();++i)
                                {
                                    TextBlock item = items.valueAt(i);
                                    stringBuilder.append(item.getValue());
                                    stringBuilder.append("\n");
                                }
                               // hiddenTextInput.setText(stringBuilder.toString());
                            }
                        });
                    }
                }
            });
        }
        return view;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cameraSource.release();
    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.flash_btn)
        {

            setUpFlash();

        }

    }

    private void setUpFlash() {


        if (! hasDeviceFlash)
            Toast.makeText(getActivity().getApplicationContext(),"No Flash light on your device",Toast.LENGTH_LONG).show();

        else
        {
            this.camera = Camera.open(0);
            parameter = this.camera.getParameters();
        }


        if (! isFlashLightOn)
        {
            Log.d("IS The Flash Light on"," "+ isFlashLightOn);
            turnOnFlashLight();

        }
        else
        {
            Log.d("Is The Flash Light off" ,""+isFlashLightOn);

        }}

    private void turnOnFlashLight()
    {
        Log.d("Turning on the flash","");
        if(this.camera != null)
        {
            parameter = this.camera.getParameters();
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            this.camera.setParameters(parameter);
            this.camera.startPreview();
            isFlashLightOn = true;

            flashBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_flash_off_black_24dp));
        }
        else
        {
            Log.d("Camera Null","Null");
        }
    }


    private void turnOffTheFlash() {

        Log.d("Turn off","off");
        parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        this.camera.setParameters(parameter);
        this.camera.stopPreview();
        isFlashLightOn = false;
        flashBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_flash_on_black_24dp));
    }

    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                parameter = camera.getParameters();
            } catch (RuntimeException e) {
                System.out.println("Error: Failed to Open: " + e.getMessage());
            }
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if(this.camera != null){
            this.camera.release();
            this.camera = null;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        turnOffTheFlash();
    }
    @Override
    public void onResume() {
        super.onResume();
        if(isFlashLightOn){
            turnOffTheFlash();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getCamera();
    }

}
