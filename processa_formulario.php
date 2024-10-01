<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $telefone = $_POST['telefone'];
    $pessoa = $_POST['pessoa'];
    $cnpj = isset($_POST['cnpj']) ? $_POST['cnpj'] : 'N/A';
    $empresa = isset($_POST['empresa']) ? $_POST['empresa'] : 'N/A';
    $servico = $_POST['servico'];
    
    // Verifica se existe um arquivo de foto anexado
    $foto = $_FILES['foto'];
    $foto_path = '';
    if ($foto['error'] == UPLOAD_ERR_OK) {
        $foto_path = 'uploads/' . basename($foto['name']);
        move_uploaded_file($foto['tmp_name'], $foto_path);
    }

    // Configuração de e-mail
    $to = "lf791371@gmail.com";
    $subject = "Novo Pedido de Orçamento de " . $nome;
    $message = "
        Nome Completo: $nome\n
        Email: $email\n
        Telefone: $telefone\n
        Pessoa: $pessoa\n
        CNPJ: $cnpj\n
        Empresa: $empresa\n
        Serviço: $servico\n
        Foto: $foto_path\n
    ";
    
    // Enviar o e-mail
    $headers = "From: $email";
    
    if (mail($to, $subject, $message, $headers)) {
        echo "Solicitação enviada com sucesso!";
    } else {
        echo "Falha ao enviar a solicitação.";
    }
} else {
    echo "Método de requisição não suportado.";
}
?>
