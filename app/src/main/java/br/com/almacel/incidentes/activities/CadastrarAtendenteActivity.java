package br.com.almacel.incidentes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.almacel.incidentes.R;
import br.com.almacel.incidentes.bean.Atendente;
import br.com.almacel.incidentes.crud.Update;

public class CadastrarAtendenteActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCadAtendente;
    EditText edtNomeAtendente;
    EditText edtIdAtendente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_atendente);
        edtNomeAtendente = findViewById(R.id.edtNomeAtendente);
        edtIdAtendente = findViewById(R.id.edtIdAtendente);
        btnCadAtendente = findViewById(R.id.btnCadAtendente);
        btnCadAtendente.setOnClickListener(this);
    }


    public void CadastrarAtendente(View view) {
    }

    @Override
    public void onClick(View v) {
        String nome = edtNomeAtendente.getText().toString();

       if (v.getId() == R.id.btnCadAtendente){
            Atendente atendente = new Atendente();
            atendente.setId(Integer.parseInt(edtIdAtendente.getText().toString()));
            atendente.setNome(edtNomeAtendente.getText().toString());
            Update up = new Update(getApplicationContext());
            if (up.insertAtendente(atendente)){
                Toast.makeText(this, "O antendente "+nome+" foi inserido com sucesso", Toast.LENGTH_LONG).show();
                edtIdAtendente.setText("");
                edtNomeAtendente.setText("");
            } else {
                Toast.makeText(this, "Erro ao inserir atendente", Toast.LENGTH_LONG).show();
                edtIdAtendente.setText("");
                edtNomeAtendente.setText("");
            }
        };

    }
}
