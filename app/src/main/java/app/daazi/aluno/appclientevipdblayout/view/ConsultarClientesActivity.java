package app.daazi.aluno.appclientevipdblayout.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.daazi.aluno.appclientevipdblayout.R;
import app.daazi.aluno.appclientevipdblayout.api.ClienteAdapter;
import app.daazi.aluno.appclientevipdblayout.controller.ClienteController;
import app.daazi.aluno.appclientevipdblayout.model.Cliente;

public class ConsultarClientesActivity extends AppCompatActivity {

    List<Cliente> clientes;
    ClienteAdapter adapter;
    Cliente obj;
    ClienteController controller;

    RecyclerView rvClientesVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);

        rvClientesVip = findViewById(R.id.rvClientesVip);

        controller = new ClienteController(getApplicationContext());

        clientes = controller.listar();

        /*clientes = new ArrayList<>();

        for (int i = 0; i < 50; i++){

            obj = new Cliente();
            obj.setPrimeiroNome("Cliente "+i);
            obj.setPessoaFisica(i % 2==0);

            clientes.add(obj);

        }*/

        adapter = new ClienteAdapter(clientes, getApplicationContext());

        rvClientesVip.setAdapter(adapter);

        rvClientesVip.setLayoutManager(new LinearLayoutManager(this));
    }
}