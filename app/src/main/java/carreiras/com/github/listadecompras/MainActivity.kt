package carreiras.com.github.listadecompras;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;
import carreiras.com.github.listadecompras.adapter.ItemsAdapter;
import carreiras.com.github.listadecompras.model.ItemModel;

/**
 * MainActivity é a classe principal do aplicativo.
 * extends ComponentActivity indica que é uma classe de atividade.
 */
public class MainActivity extends ComponentActivity {

    // OnCreate é o método que é chamado quando a atividade é criada pela primeira vez.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout para esta atividade, buscando em /res/layout.
        setContentView(R.layout.activity_main);

        /** 
         * O RecyclerView é um contêiner para exibir grandes conjuntos de dados que podem ser rolados de maneira muito eficiente 
         * mantendo um número limitado de views. Ele é usado para criar listas e grades complexas de elementos,
         * sendo mais versátil e flexível do que o ListView.
        */
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Cria uma instância de ItemsAdapter que será usada para gerenciar os itens no RecyclerView.
        ItemsAdapter itemsAdapter = new ItemsAdapter();

        // O Adapter é responsável por converter um conjunto de dados em views que podem ser exibidas dentro do RecyclerView. 
        recyclerView.setAdapter(itemsAdapter);

        // Encontra os widgets Button e EditText pelos seus IDs no arquivo de recurso de layout.
        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);

        // O setOnClickListener e usado para definir um ouvinte que será chamado quando o usuário clicar no botão.
        button.setOnClickListener(view -> {
            if (editText.getText().isEmpty()) {
                editText.setError("Preencha um valor");
                return;
            }

            // Cria um novo modelo de item com o texto do EditText como o nome do item.
            // Define uma função lambda para lidar com a ação de remoção do item dentro do adaptador.
            ItemModel item = new ItemModel(
                editText.getText().toString(),
                it -> itemsAdapter.removeItem(it)
            );

            // Adiciona o novo item ao adaptador.
            itemsAdapter.addItem(item);

            // Limpa o EditText após adicionar o item.
            editText.getText().clear();
        });
    }
}
