package com.example.yournight10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class RegistrarCuenta extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private StorageReference mStorage;
    RadioGroup radioGroup;
    RadioButton rdmasculino, rdfemenino,rdnobinario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);

        radioGroup = findViewById(R.id.rgGenero);
        rdfemenino= findViewById(R.id.rbFemenino);
        rdmasculino= findViewById(R.id.rbMasculino);
        rdnobinario= findViewById(R.id.rbNoBinario);

        //mStorage = FirebaseStorage.getInstance().getReference();
    }
    /*public void tomar_foto(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode== RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imfoto =(ImageView) findViewById(R.id.ivfoto);
            imfoto.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap, 500,500, false));
            StorageReference fotoRef = mStorage.child("images/foto.jpg");
            //arreglo de bytes

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // bitmap al formato y calidad
            imageBitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
            byte[] data1 = baos.toByteArray();
            //subir
            UploadTask uploadTask = fotoRef.putBytes(data1);
        };
    }*/
    public void registrar(View v ){

        //recupero view
        EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        //recupero valor
        String usuario = etUsuario.getText().toString();


        //recupero view
        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        //recupero valor
        String correo = etCorreo.getText().toString();


       /*///recupero view
        RadioGroup rgGenero = (RadioGroup) findViewById(R.id.rgGenero);
        //recupero valor
        int d = rgGenero.getCheckedRadioButtonId();
        String genero = "";
        switch (d) {
            case R.id.rbFemenino:
                genero = "Femenino";
                break;
            case R.id.rbNoBinario:
                genero="No binario";
                break;
            case R.id.rbMasculino:
                genero="Masculino";
                break;
            default:
                Toast.makeText(this, "Error en la seleccion de genero", Toast.LENGTH_SHORT).show();

        }*/
        EditText etPassword1 = (EditText) findViewById(R.id.etPassword1);
        String password = etPassword1.getText().toString();


        EditText Password2 = (EditText) findViewById(R.id.etPassword2);
        String password2 = Password2.getText().toString();

        if(password.equals(password2)){
            Toast.makeText(this, "Registo con exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Registro fallido ", Toast.LENGTH_SHORT).show();

        }
    }

}
