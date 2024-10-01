function toggleCNPJField() {
    var pessoa = document.getElementById('pessoa');
    var cnpjField = document.getElementById('cnpj-field');
    var empresaField = document.getElementById('empresa-field');
    var cnpjInput = document.getElementById('cnpj');
    var empresaInput = document.getElementById('empresa');

    if (pessoa.value === 'juridica') {
        cnpjField.classList.remove('hidden');
        empresaField.classList.remove('hidden');
        cnpjInput.setAttribute('required', 'required');
        empresaInput.setAttribute('required', 'required');
    } else {
        cnpjField.classList.add('hidden');
        empresaField.classList.add('hidden');
        cnpjInput.removeAttribute('required');
        empresaInput.removeAttribute('required');
    }
}

function toggleCNPJField() {
    var pessoa = document.getElementById('pessoa');
    var cnpjField = document.getElementById('cnpj-field');
    var empresaField = document.getElementById('empresa-field');
    
    if (pessoa.value === 'juridica') {
        // Se for pessoa jurídica, cria os campos novamente se eles não existirem
        if (!cnpjField) {
            var cnpjDiv = document.createElement('div');
            cnpjDiv.classList.add('form-group');
            cnpjDiv.id = 'cnpj-field';
            cnpjDiv.innerHTML = `
                <label for="cnpj">CNPJ</label>
                <input type="text" id="cnpj" name="cnpj" required>
            `;
            document.querySelector('form').insertBefore(cnpjDiv, document.getElementById('empresa-field'));

            var empresaDiv = document.createElement('div');
            empresaDiv.classList.add('form-group');
            empresaDiv.id = 'empresa-field';
            empresaDiv.innerHTML = `
                <label for="empresa">Nome da Empresa</label>
                <input type="text" id="empresa" name="empresa" required>
            `;
            document.querySelector('form').insertBefore(empresaDiv, document.querySelector('.form-group:last-of-type'));
        }
    } else {
        // Remove os campos de CNPJ e Empresa se for pessoa física
        if (cnpjField) {
            cnpjField.remove();
        }
        if (empresaField) {
            empresaField.remove();
        }
    }
}
