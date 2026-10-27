-- Um pagamento pertence a uma venda OU a uma comanda (ver PagamentoService),
-- então venda_id precisa aceitar nulo. Bancos antigos ainda tinham NOT NULL
-- e rejeitavam pagamentos de comanda.
ALTER TABLE tbpagamento ALTER COLUMN venda_id DROP NOT NULL;
