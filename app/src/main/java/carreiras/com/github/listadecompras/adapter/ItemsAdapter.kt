package carreiras.com.github.listadecompras.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import carreiras.com.github.listadecompras.R;
import carreiras.com.github.listadecompras.model.ItemModel;

/**
 * Adaptador para o RecyclerView que gerencia uma lista de ItemModel.
 * Este adaptador é responsável por fornecer as views e vincular os dados dos itens
 * a essas views dentro de um RecyclerView.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private final List<ItemModel> items = new ArrayList<>();

    /**
     * Adiciona um novo item à lista e notifica o RecyclerView de que os dados foram alterados.
     */
    public void addItem(ItemModel newItem) {
        items.add(newItem);
        notifyDataSetChanged();
    }

    /**
     * Remove um item da lista e notifica o RecyclerView de que os dados foram alterados.
     */
    public void removeItem(ItemModel item) {
        items.remove(item);
        notifyDataSetChanged();
    }

    /**
     * Cria novas views (invocado pelo layout manager do RecyclerView).
     */
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    /**
     * Retorna o tamanho da lista de itens.
     * 
     * @return O número total de itens na lista.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Substitui o conteúdo de uma view (invocado pelo layout manager do RecyclerView).
     *
     * @param holder O ViewHolder que deve ter seu conteúdo atualizado.
     * @param position A posição dos dados a serem vinculados.
     */
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.bind(item);
    }

    /**
     * ViewHolder que fornece uma referência para as views para cada item de dados.
     * Itens complexos podem precisar de mais de uma view por item, e você fornece acesso a todas as views
     * para um item de dados em um holder de view.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageButton button;

        /**
         * Constrói o ViewHolder, recuperando as instâncias das views que serão usadas.
         *
         * @param view A view base que contém outros widgets como TextView e ImageButton.
         */
        public ItemViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewItem);
            button = view.findViewById(R.id.imageButton);
        }

        /**
         * Vincula um item de modelo a este ViewHolder, configurando os textos das views e definindo listeners.
         *
         * @param item O modelo de item que será vinculado a este ViewHolder.
         */
        public void bind(ItemModel item) {
            textView.setText(item.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.onRemove(item);
                }
            });
        }
    }
}
