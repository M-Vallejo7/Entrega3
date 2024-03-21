package com.vallejo.entrega3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotoPerfil = {
                R.drawable.cristiano2008,
                R.drawable.james2014,
                R.drawable.mbappe2022,
                R.drawable.neymar2012,
                R.drawable.ronaldo2002,
        };
        String[] nombres = {
                "Cristiano Ronaldo Dos Santos Aveiro",
                "James David Rodriguez Rubio",
                "Kylian Mbappé Lottin",
                "Neymar Da Silva Santos Jr",
                "Ronaldo Luís Nazario de Lima",
        };
        String[] biografias = {
                "The G.O.A.T, El Comandante, El Bicho, CR7, La Máquina, Mr. Champions, El Batipibe. 5 veces ganador del Ballon d'Or. 5 veces campeón de UEFA Champions League. Campeón de Eurocopa 2016 y Campeón de UEFA Nations League en 2019. Máximo goleador de la historia del fútbol, máximo goleador de la champions, máximo goleador del Real Madrid. Puskás 2008.",
                "Top #1 de la historia de Colombia. Mejor jugador del mundial Brasil 2014. Puskás 2014. El 10 del Real Madrid. Dos veces campeón de UEFA Champions League. Campeón de la Bundesliga.",
                "La Tortuga. Donatello. Hat-Trick en una final del mundo vs Argentina. Actual mejor jugador del mundo. Campeón del mundo en 2018. Mejor jugador de la League One.",
                "El último heredero del Jogo Bonito. El príncipe que no quiso ser Rey. El pájaro carpintero. Campeón de UEFA Champions League. Top#3 Mejores jugadores de la década. Ídolo de la selección de Brasil.",
                "O´fenômeno. R9. El mejor delantero de la historia. El jugador mas joven en ganar el balón de oro. Dos veces campeón del mundo. Ídolo de la selección Brasileña.",
        };
        String[] telefonos = {
                "625 mill",
                "51.9 mill",
                "112 mill",
                "220 mill",
                "30 mill",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil,biografias);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Vista, int Posicion, long Id){

                Intent EnviarInfo = new Intent(MainActivity.this, UserActivity.class)
                        .putExtra("Nombre: ", nombres[Posicion])
                        .putExtra("Teléfono: ", telefonos[Posicion])
                        .putExtra("Foto de Perfil: ", fotoPerfil[Posicion])
                        .putExtra("Biografia: ", biografias[Posicion]);
                startActivity(EnviarInfo);
            }
        });
    }
}