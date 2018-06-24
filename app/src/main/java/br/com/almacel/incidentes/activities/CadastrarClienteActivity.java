package br.com.almacel.incidentes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.almacel.incidentes.R;
import br.com.almacel.incidentes.bean.Atendente;
import br.com.almacel.incidentes.bean.Cliente;
import br.com.almacel.incidentes.crud.Update;

/**
 * @author Daniel Aguiar
 * Classe responsável pela manipulação da View "activity_cadastrar_cliente.xml"
 */
public class CadastrarClienteActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtIdCliente;
    EditText edtNomeCliente;
    EditText edtEmpresaCliente;
    Button btnCadCliente;

    /**
     * Método para inicialização de componentes da View.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);
        edtIdCliente = findViewById(R.id.edtIdCliente);
        edtNomeCliente = findViewById(R.id.edtNomeCliente);
        edtEmpresaCliente = findViewById(R.id.edtEmpresaCliente);
        btnCadCliente = findViewById(R.id.btnCadCliente);
        btnCadCliente.setOnClickListener(this);
    }

    /**
     * @param view view
     * Método do clique do botão
     */
    public void CadastrarCliente(View view) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCadCliente){
            String nome = edtNomeCliente.getText().toString();
                            Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(edtIdCliente.getText().toString()));
                cliente.setNome(edtNomeCliente.getText().toString());
                cliente.setEmpresa(edtEmpresaCliente.getText().toString());

                Update up = new Update(getApplicationContext());
                if (up.insertCliente(cliente)){
                    Toast.makeText(this, "O cliente "+nome+" foi inserido com sucesso", Toast.LENGTH_LONG).show();
                    edtIdCliente.setText("");
                    edtNomeCliente.setText("");
                    edtEmpresaCliente.setText("");
                } else {
                    Toast.makeText(this, "Erro ao inserir cliente", Toast.LENGTH_LONG).show();
                    edtIdCliente.setText("");
                    edtNomeCliente.setText("");
                    edtEmpresaCliente.setText("");
                }
        };
    }
}
