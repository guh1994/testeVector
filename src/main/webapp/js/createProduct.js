    $(document).ready(function () {
        $('#formProduct').submit(function (event) {
            event.preventDefault();

            const codigoProduto = $('#codigoProduto').val();
            const descricaoProduto = $('#decricaoProduto').val();
            const valorProduto = $('#valorProduto').val();

            $.ajax({
                url: '/testeVector/createproduct',
                method: 'POST',
                data: {
                    codigoProduto: codigoProduto,
                    decricaoProduto: descricaoProduto,
                    valorProduto: valorProduto
                },
                dataType: 'json',
                success: function (response) {
                    if (response.status === "sucesso") {
                        alert(response.mensagem);
                    } else {
                        alert("Erro: " + response.mensagem);
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Erro na requisição AJAX:", status, error);
                    alert("Ocorreu um erro ao enviar os dados. Tente novamente.");
                }
            });
        });
    });
