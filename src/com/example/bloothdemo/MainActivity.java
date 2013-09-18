package com.example.bloothdemo;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private TextView main_img;
	private boolean isopent = false;
	private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        main_img=(TextView)findViewById(R.id.main_img);
        
        main_img.setOnClickListener(this);
        
    }


    @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
    	if (!isopent) {
			Toast.makeText(getApplicationContext(), "���Ѿ������ֵ�Ͳ", 0)
					.show();
			camera = Camera.open();
			Parameters params = camera.getParameters();
			params.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(params);
			camera.startPreview(); // ��ʼ����

			isopent = true;
		} else {
			Toast.makeText(getApplicationContext(), "�ر����ֵ�Ͳ",
					Toast.LENGTH_SHORT).show();
			camera.stopPreview(); // �ص�����
			camera.release(); // �ص������
			isopent = false;
		}
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
