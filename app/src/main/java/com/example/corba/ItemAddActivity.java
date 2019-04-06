package com.example.corba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ItemAddActivity extends AppCompatActivity {

    Button btnPhotoAdd;
    EditText ed_konu;
    Button btnEkle;
    Bitmap imageBitmap;
    Bundle itemBdl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add);
        btnPhotoAdd=findViewById(R.id.btnPhotoAdd);
        btnPhotoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        btnEkle=findViewById(R.id.btnEkle);
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
               itemBdl = new Bundle();
                final Intent lstIntent = new Intent(getApplicationContext(),ListActivity.class);
                ed_konu=findViewById(R.id.ed_konu);
                String konu = ed_konu.getText().toString();
                itemBdl.putString("title",konu);
                ImageView img = findViewById(R.id.img_new);
                itemBdl.putInt("icon",(int)img.getImageAlpha());
                lstIntent.putExtras(itemBdl);
                startActivity(lstIntent);
            }
        });

    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.img_new);
            imageView.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap,225,225,false));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
