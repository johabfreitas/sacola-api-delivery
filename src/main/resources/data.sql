INSERT INTO cliente (id, cep, complemento, nome) VALUES
(1l, '123456', 'Rua Cliente 1', 'Cliente 1'),
(2l, '654321', 'Rua Cliente 2', 'Cliente 2'),
(3l, '789012', 'Rua Cliente 3', 'Cliente 3');

INSERT INTO restaurante (id, cep, complemento, nome) VALUES
(1l, '100001', 'Rua Loja Sorvete','Loja 01'),
(2l, '100002', 'Rua Loja Açaí','Loja 02'),
(3l, '100003', 'Rua Loja Pastel','Loja 03');

INSERT INTO produto (id, disponivel, nome, valor_unitario, restaurante_id) VALUES
(1l, true, 'Carioca Sushi', 2.0, 1l),
(2l, true, 'Joy Joy Sushi', 3.0, 1l),
(3l, true, 'Cupuaçu na Tigela', 20.0, 2l),
(4l, true, 'Acai na Tigela', 25.0, 2l),
(5l, true, 'Pastel de Palmito', 2.0, 3l),
(6l, true, 'Pastel de Queijo', 2.0, 3l);

INSERT INTO sacola (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
(1l, 0, false, 0.0, 1l);

INSERT INTO item (id, quantidade, produto_id, sacola_id) VALUES
(1l, 3, 5l, 1l);