package br.com.almacel.incidentes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

import br.com.almacel.incidentes.R;
import br.com.almacel.incidentes.bean.Atendente;
import br.com.almacel.incidentes.bean.Incidente;
import br.com.almacel.incidentes.bean.Status;
import br.com.almacel.incidentes.crud.Read;
import br.com.almacel.incidentes.crud.Update;

public class CadastrarIncidenteActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCadIncidente;
    EditText edtIdIncidente;
    EditText edtNomeAtendenteIncidente;
    EditText edtNomeClienteIncidente;
    EditText edtDescricaoIncidente;
    RadioGroup rdgStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_incidente);
        edtIdIncidente = findViewById(R.id.edtIdIncidente);
        edtNomeAtendenteIncidente = findViewById(R.id.edtNomeAtendenteIncidente);
        edtNomeClienteIncidente = findViewById(R.id.edtNomeClienteIncidente);
        edtDescricaoIncidente = findViewById(R.id.edtDescricaoIncidente);
        rdgStatus = findViewById(R.id.rdgStatus);
        btnCadIncidente = findViewById(R.id.btnCadIncidente);
        btnCadIncidente.setOnClickListener(this);
    }
    public void CadastrarIncidente(View view) {
    }

    @Override
    public void onClick(View v) {
        int idAtendente;
        int idCliente;
        String nomeAtendente = edtNomeAtendenteIncidente.getText().toString();
        String nomeCliente = edtNomeClienteIncidente.getText().toString();
        String status;
        String creation_time;
        Date dataAtual = new Date(System.currentTimeMillis());
        Read read = new Read(getApplicationContext());
        Update up = new Update(getApplicationContext());
        idAtendente = read.getIdAtendente(nomeAtendente);
        idCliente = read.getIdCliente(nomeCliente);
        rdgStatus.getCheckedRadioButtonId();
        if (rdgStatus.getCheckedRadioButtonId() == R.id.rdbAberto){
            status = "ABERTO";
        }else{
            status = "FINALIZADO";
        }
        creation_time = String.valueOf(dataAtual);
        if (v.getId() == R.id.btnCadIncidente){
                Incidente incidente = new Incidente();
                incidente.setId(Integer.parseInt(edtIdIncidente.getText().toString()));
                incidente.setAtendente(idAtendente);
                incidente.setCliente(idCliente);
                incidente.setDescricao(edtDescricaoIncidente.getText().toString());
                incidente.setStatus(Status.valueOf(status));
                incidente.setCreationTime(creation_time);
                if (idAtendente == 0 || idAtendente == 0){
                    Toast.makeText(this, "Erro ao inserir incidente (Atendente ou cliente não encontrado)", Toast.LENGTH_LONG).show();
                }else if (up.insertIncidente(incidente)){
                    Toast.makeText(this, "O incidente foi inserido com sucesso", Toast.LENGTH_LONG).show();
                    edtIdIncidente.setText("");
                    edtNomeAtendenteIncidente.setText("");
                    edtNomeClienteIncidente.setText("");
                    edtDescricaoIncidente.setText("");
                } else {
                    Toast.makeText(this, "Erro ao inserir incidente", Toast.LENGTH_LONG).show();
                    edtIdIncidente.setText("");
                    edtNomeAtendenteIncidente.setText("");
                    edtNomeClienteIncidente.setText("");
                    edtDescricaoIncidente.setText("");
            }

            }
    }
}
