package com.example.myimc;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ImageView;

import static com.example.myimc.R.string.Sobrepeso;

public class MainActivity extends AppCompatActivity {

    private TextView nPeso = null;
    private TextView nEstatura = null;
    private TextView nIMC = null;
    private ImageView iFoto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nPeso = findViewById(R.id.caja_Peso);
        nEstatura = findViewById(R.id.caja_Estatura);
        nIMC = findViewById(R.id.caja_IMC);
        iFoto = findViewById(R.id.imageIMC);
        if (savedInstanceState != null) {
            nIMC.setText(savedInstanceState.getString("nIMC").toString());
            int ii = savedInstanceState.getInt("iFoto");
            iFoto.setImageResource(ii);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MiAPP", "--onSaveInstanceState---");
        outState.putString("nIMC", nIMC.getText().toString());
        outState.putInt("iFoto", R.id.imageIMC);
    }

    public void calculaIMC(View view) {
        Log.d("MiAPP", "boton ha sido Tocado: ");

        Float vPeso = Float.valueOf(0), vEsta = Float.valueOf(0);
        Float vIMC  = Float.valueOf(0);
        vPeso = Float.parseFloat(nPeso.getText().toString());
        vEsta = Float.parseFloat(nEstatura.getText().toString())/100;
        if (vEsta != 0) {
            vIMC = (vPeso / (vEsta * vEsta));
        }
        else {
            Log.d("MiAPP", "Estatura no puede ser Cero.");
        }

        ImageView iRes = null;
        String sRes = getString(R.string.SinDatos);
        if (vIMC < 16){
            sRes = getString(R.string.Desnutrido) + Float.toString(vIMC);
        } else if ((vIMC >= 16) && (vIMC < 18)){
            sRes = getString(R.string.Delgado) + vIMC;
            iFoto.setImageResource(R.drawable.delgado);
        } else if ((vIMC >= 18) && (vIMC < 25)){
            sRes = getString(R.string.Ideal) + vIMC;
            iFoto.setImageResource(R.drawable.chicanormal);
        } else if ((vIMC >= 25) && (vIMC < 31)){
            sRes = getString(Sobrepeso) + vIMC;
            iFoto.setImageResource(R.drawable.gordo);
        } else if (vIMC >= 31){
            sRes = getString(R.string.Obesidad) + vIMC;
        }

        //nIMC.setText(Float.toString(vIMC));
        nIMC.setText(sRes);
        //iRes.setImageResource();
    }

    public void limpiarTodo(View view) {
        nIMC.setText("");
        nPeso.setText("");
        nEstatura.setText("");
    }

    // Inflado del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_info, menu);

        return super.onCreateOptionsMenu(menu);

    }

    //Chequeo del elemento tocado del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                Log.d("MIAPP", "Para aTRás  <--");
                break;
            case R.id.info:
                Log.d("MIAPP", "Menu salir");
                break;
                // Ir a la otra actividad via Intent
                finish();
                Intent intent = new Intent(this,);
                startActivity(intent);



                break;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    ImageView imagenDelgado = findViewById(R.id.imageView);
    imagenDelgado.setImageResource(R.drawable.delgado);

 */
}
