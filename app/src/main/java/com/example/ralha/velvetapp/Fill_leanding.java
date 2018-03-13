package com.example.ralha.velvetapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fill_leanding extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_leanding);

        context = getApplicationContext();
        imgView1 = (ImageButton) findViewById(R.id.photo1);
        submit = findViewById(R.id.submitApp);
        submit.setOnClickListener(this);



        //or
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    public static final int PICK_PHOTO_FOR_AVATAR = 1;
    private ImageButton imgView;
    private ImageButton imgView1;


    public void pickImage(View view) {
        imgView = (ImageButton) view;
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            Uri selectedImage = data.getData();
            decodeUri(selectedImage);


        }
    }


    Boolean validateFields() {

        ViewGroup container = (LinearLayout) findViewById(R.id.container);
        int count = container.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = container.getChildAt(i);
            if (v instanceof EditText && ((EditText) v).getText().toString().trim().isEmpty()) {
                ((EditText) v).setError("Field Cannot be Empty");
                return false;
            }
        }
        return true;
    }

    public void decodeUri(Uri uri) {
        ParcelFileDescriptor parcelFD = null;
        try {
            parcelFD = getContentResolver().openFileDescriptor(uri, "r");
            FileDescriptor imageSource = parcelFD.getFileDescriptor();

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(imageSource, null, o);

            // the new size we want to scale to
            final int REQUIRED_SIZE = imgView1 == imgView ? 200 : 100;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor(imageSource, null, o2);

            imgView.setImageBitmap(bitmap);

        } catch (FileNotFoundException e) {
            // handle errors
        }
  /*      catch (IOException e) {
            // handle errors
        } */
        finally {
            if (parcelFD != null)
                try {
                    parcelFD.close();
                } catch (IOException e) {
                    // ignored
                }
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.submitApp){
            if(validateFields())
            {
//                MainActivity mainActivityInstance = new MainActivity();
//                mainActivityInstance.AddItem();

            }

        }
    }
}

