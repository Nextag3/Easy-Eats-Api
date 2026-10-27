-- CAIXA e CUPONS foram adicionados ao enum Funcionalidade depois que a
-- constraint já existia; mesmo problema da V2.
ALTER TABLE tbsegmento_funcionalidade DROP CONSTRAINT IF EXISTS tbsegmento_funcionalidade_funcionalidade_check;
ALTER TABLE tbsegmento_funcionalidade ADD CONSTRAINT tbsegmento_funcionalidade_funcionalidade_check
    CHECK (funcionalidade IN ('OPERACAO', 'PEDIDO', 'COZINHA', 'DELIVERY', 'ESTOQUE', 'COMPRAS',
                              'FINANCEIRO', 'PRODUTOS', 'CLIENTES', 'USUARIOS', 'CONFIGURACOES',
                              'CAIXA', 'CUPONS'));
