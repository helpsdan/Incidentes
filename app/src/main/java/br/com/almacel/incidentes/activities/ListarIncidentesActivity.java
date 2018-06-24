package br.com.almacel.incidentes.activities;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ListView;

        import br.com.almacel.incidentes.R;

/**
 * @author Daniel Aguiar
 * Classe responsável pela manipulação da View "activity_listar_incidentes.xml"
 */
public class ListarIncidentesActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_incidentes);


    }
    @Override
    public void onClick(View v) {

    }
}
