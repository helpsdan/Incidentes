package br.com.almacel.incidentes.java;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

        import br.com.almacel.incidentes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AbrirCadastrarAtendente(View view) {
        Intent it = new Intent(this, CadastrarAtendenteActivity.class);
        startActivity(it);
    }

    public void AbrirCadastrarCliente(View view) {
        Intent it = new Intent(this, CadastrarClienteActivity.class);
        startActivity(it);
    }

    public void AbrirCadastrarIncidente(View view) {
        Intent it = new Intent(this, CadastrarIncidenteActivity.class);
        startActivity(it);
    }

    public void AbrirListarIncidentes(View view) {
        Intent it = new Intent(this, ListarIncidentesActivity.class);
        startActivity(it);
    }
}
