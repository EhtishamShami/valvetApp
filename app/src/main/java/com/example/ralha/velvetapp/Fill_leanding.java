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
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fill_leanding extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button submit;

    private EditText itemStory;
    private EditText itemYear;
    private EditText itemBrand;
    private EditText itemTitle;
    private EditText itemRentalPrice;
    private Spinner categoryList;
    private Spinner colorList;
    private Spinner sizeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_leanding);

        context = getApplicationContext();
        imgView1 = (ImageButton) findViewById(R.id.photo1);
        submit = findViewById(R.id.submitApp);
        submit.setOnClickListener(this);



        itemStory= (EditText) findViewById(R.id.storyText);
        itemBrand= (EditText) findViewById(R.id.itemBrand);
        itemTitle= (EditText) findViewById(R.id.itemTitle);
        itemRentalPrice= (EditText) findViewById(R.id.itemRentalPrice);
        itemYear= (EditText) findViewById(R.id.itemYear);
        categoryList= (Spinner) findViewById(R.id.category);
        colorList= (Spinner) findViewById(R.id.color);
        sizeList= (Spinner) findViewById(R.id.size);


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


    // make it public so it is accessable in other class
    public void AddItem(){
        String story = itemStory.getText().toString().trim();
        String brand = itemBrand.getText().toString().trim();
        String title = itemTitle.getText().toString().trim();
        String retailPrice = itemRentalPrice.getText().toString().trim();
        String rentalPrice = itemRentalPrice.getText().toString().trim();
        String year = itemYear.getText().toString().trim();
        String category = categoryList.getSelectedItem().toString();
        String color = colorList.getSelectedItem().toString();
        String size = sizeList.getSelectedItem().toString();

//        if(!TextUtils.isEmpty(story)){
//            String id=  databaseItems.push().getKey();
//            Items item = new Items(story, brand, title, year, retailPrice, rentalPrice, category, color, size);
//            databaseItems.child(id).setValue(item);
//
//            Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();
//
//        }else{
//            Toast.makeText(this, "You should enter a story", Toast.LENGTH_SHORT).show();
//        }

        if(!TextUtils.isEmpty(brand)){

        }else{
            Toast.makeText(this, "You should enter a brand name", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(title)){

        }else{
            Toast.makeText(this, "You should enter a title", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(retailPrice)){

        }else{
            Toast.makeText(this, "You should enter retail price", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(rentalPrice)){

        }else{
            Toast.makeText(this, "You should enter rental price", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(year)){

        }else{
            Toast.makeText(this, "You should enter a year of purchase", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(category)){

        }else{
            Toast.makeText(this, "You should enter a category", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(size)){

        }else{
            Toast.makeText(this, "You should enter the size", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(color)){

        }else{
            Toast.makeText(this, "You should enter the color", Toast.LENGTH_SHORT).show();
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
                AddItem();
            }

        }
    }
}

