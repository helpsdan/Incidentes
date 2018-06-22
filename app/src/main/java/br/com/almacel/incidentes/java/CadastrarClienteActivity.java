package br.com.almacel.incidentes.java;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.almacel.incidentes.R;
import br.com.almacel.incidentes.banco.BancoController;

public class CadastrarClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);
    }

    public void CadastrarCliente(View view) {
        BancoController crud = new BancoController(getBaseContext());
        EditText nome = (EditText)findViewById(R.id.editText);
        String nomeAtendente = nome.getText().toString();
        crud.insereAtendente(nomeAtendente);


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Cadastrar Novo Cliente", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Voltar Ao Início", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (getIntent().getBooleanExtra("EXIT", false)){
                    finish();
                }
            }
        });
    }
}
