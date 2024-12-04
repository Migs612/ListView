package com.example.listview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private TextView texto;
    private RadioButton radioButtonPulsado;
    private ArrayList<Encapsulador> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        texto = findViewById(R.id.texto);
        datos = new ArrayList<>();

        // Agregar datos al ArrayList
        datos.add(new Encapsulador(R.drawable.imagen1, "Dragonite", "Tipo: Dragón/Volador. \n Conocido por su velocidad y fuerza.", false));
        datos.add(new Encapsulador(R.drawable.imagen2, "Gengar", "Tipo: Fantasma/Veneno. \n Experto en movimientos sigilosos.", false));
        datos.add(new Encapsulador(R.drawable.imagen3, "Umbreon", "Tipo: Siniestro. \n Evolución de Eevee con alta defensa.", false));
        datos.add(new Encapsulador(R.drawable.imagen4, "Articuno", "Tipo: Hielo/Volador. \n Legendario de las islas heladas.", false));
        datos.add(new Encapsulador(R.drawable.imagen5, "Garchomp", "Tipo: Dragón/Tierra. \n Maestro de los ataques rápidos.", false));
        datos.add(new Encapsulador(R.drawable.imagen6, "Onix", "Tipo: Roca/Tierra. \n Gigantesco y de alta resistencia.", false));
        datos.add(new Encapsulador(R.drawable.imagen7, "Nidoqueen", "Tipo: Veneno/Tierra. \n Protector natural de su equipo.", false));
        datos.add(new Encapsulador(R.drawable.imagen8, "Alakazam", "Tipo: Psíquico. \n Su alto IQ es incomparable.", false));
        datos.add(new Encapsulador(R.drawable.imagen9, "Blastoise", "Tipo: Agua. \n Usa sus cañones como defensa y ataque.", false));
        datos.add(new Encapsulador(R.drawable.imagen10, "Raichu", "Tipo: Eléctrico. \n Rápido y poderoso con sus ataques eléctricos.", false));
        datos.add(new Encapsulador(R.drawable.imagen11, "Blastoise", "Tipo: Agua. \n Resistente y estratégico en combate.", false));
        datos.add(new Encapsulador(R.drawable.imagen12, "Charizard", "Tipo: Fuego/Volador. \n Famoso por su poderosa llamarada.", false));


        // Configurar el adaptador personalizado
        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                Encapsulador item = (Encapsulador) entrada;

                TextView titulo = view.findViewById(R.id.texto_titulo);
                TextView datos = view.findViewById(R.id.texto_datos);
                ImageView imagen = view.findViewById(R.id.imagen);
                RadioButton miRadio = view.findViewById(R.id.boton);

                // Asignar valores desde el objeto Encapsulador
                titulo.setText(item.getTitulo());
                datos.setText(item.getTexto());
                imagen.setImageResource(item.getIdImagen());

                // Configurar comportamiento del RadioButton
                miRadio.setOnClickListener(v -> {
                    if (radioButtonPulsado != null)
                        radioButtonPulsado.setChecked(false); // Desmarcar el anterior
                    radioButtonPulsado = (RadioButton) v;
                    texto.setText("Marcada una opción");
                });
            }
        });
    }

    // Clase Encapsulador (POJO) para manejar los datos
    public static class Encapsulador {
        private int imagen;
        private String titulo;
        private String texto;
        private boolean dato;

        public Encapsulador(int imagen, String titulo, String texto, boolean dato) {
            this.imagen = imagen;
            this.titulo = titulo;
            this.texto = texto;
            this.dato = dato;
        }

        public int getIdImagen() { return imagen; }
        public String getTitulo() { return titulo; }
        public String getTexto() { return texto; }
        public boolean getDato() { return dato; }
    }
}
