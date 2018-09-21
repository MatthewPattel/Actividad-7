package com.example.thematthewpattel.intentsexternos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etTelefono, etPagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTelefono = (EditText)findViewById(R.id.inumtel);
        etPagina = (EditText)findViewById(R.id.ipagweb);

    }

    public void intentTelefono(View view) {
        String num = etTelefono.getText().toString();

        if(TextUtils.isDigitsOnly(num) && num.length() == 10) {
            Intent intTel = new Intent(Intent.ACTION_DIAL);
            intTel.setData(Uri.parse("tel:" + num));
            startActivity(intTel);
        } else {
            etTelefono.setError("El telefono tiene que ser de 10 digitos");
        }
    }

    public void intentPagina(View view) {
        String url = etPagina.getText().toString();

        if(URLUtil.isValidUrl(url)) {
            Intent intWeb = new Intent(Intent.ACTION_VIEW);
            intWeb.setData(Uri.parse(url));
            startActivity(intWeb);
        } else {
            etPagina.setError("Debe ser una pagina valida");
        }
    }

    public void intentMapas(View view) {
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}
