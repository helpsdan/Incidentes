package br.com.almacel.incidentes.activities;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

        import br.com.almacel.incidentes.R;
import br.com.almacel.incidentes.crud.Create;
import br.com.almacel.incidentes.crud.Delete;
import br.com.almacel.incidentes.crud.Update;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Delete d = new Delete(getApplicationContext());
        if(d.deleteTables() == true){
            System.out.println("*************** TABELAS DELETADAS COM SUCESSO ***************");
        }else{
            System.out.println("*************** ERRO AO DELETAR TABELAS ***************");
        }
        Create c = new Create(getApplicationContext());
        if(c.createTableAtendente() == true){
            System.out.println("*************** TABELA ATENDENTE CRIADA COM SUCESSO ***************");
        }else{
            System.out.println("*************** ERRO AO CRIAR TABELA ATENDENTE ***************");
        }
        if(c.createTableCliente() == true){
            System.out.println("*************** TABELA CLIENTE CRIADA COM SUCESSO ***************");
        }else{
            System.out.println("*************** ERRO AO CRIAR TABELA CLIENTE ***************");
        }
        if(c.createTableIncidente()==true){
            System.out.println("*************** TABELA INCIDENTE CRIADA COM SUCESSO ***************");
        }else{
            System.out.println("*************** ERRO AO CRIAR TABELA INCIDENTE ***************");
        }
        Update up = new Update(getApplicationContext());
        if(up.insertInAtendente()==true){
            System.out.println("******* INSERINDO ATENDENTE *******");
        }else{
            System.out.println("******* ERRO AO INSERIR ANTEDENTE *******");
        }
        if (up.insertInCliente()==true){
            System.out.println("******* INSERINDO CLIENTE *******");
        }else{
            System.out.println("******* ERRO AO INSERIR CLIENTE *******");
        }


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
