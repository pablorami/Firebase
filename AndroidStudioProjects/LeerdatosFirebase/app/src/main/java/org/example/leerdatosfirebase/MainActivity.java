package org.example.leerdatosfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
//import de google firebase
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
//nuestra clase estudiante
import org.example.leerdatosfirebase.modelo.Medida;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textview1 = (TextView)findViewById(R.id.textview1);
        final TextView textview2 = (TextView)findViewById(R.id.textview2);

        //Instancia a la base de datos
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        //apuntamos al nodo que queremos leer
        DatabaseReference myRef = fdb.getReference("medida");

        //Agregamos un ValueEventListener para que los cambios que se hagan en la base de datos
        //se reflejen en la aplicacion
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                //leeremos un objeto de tipo Medida
                GenericTypeIndicator<Medida> t = new GenericTypeIndicator<Medida>() {};
                Medida medida = dataSnapshot.getValue(t);

                //formamos el resultado en un string
                String resultado_temp =  "Temperatura: " +medida.getTemperatura() + " ºC";
                String resultado_hum =  "\nHumedad: "+medida.getHumedad()+ " %";

                //mostramos en el textview
                textview1.setText(resultado_temp);
                textview2.setText(resultado_hum);

            }
            @Override
            public void onCancelled(DatabaseError error){
                Log.e("ERROR FIREBASE",error.getMessage());
            }

        });

    }//onCreate:end

}
