package carreiras.com.github.listadecompras.model;

public data class ItemModel(
    val name: String,

    /**
     * Ação de callback para remover o item da lista. É chamada quando
     * o item precisa ser removido, permitindo a manipulação da ação de remoção
     * diretamente no modelo de dados.
     */
    val onRemove: (ItemModel) -> Unit
)
